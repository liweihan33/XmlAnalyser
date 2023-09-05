package infor.xml.analyser;

import infor.xml.bean.informatica.*;
import infor.xml.enums.ActionState;
import infor.xml.enums.TransformationType;
import infor.xml.log.Logbook;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * 映射文件解析器
 */
public class MappingAnalyser {

    private final Logger logger= LoggerFactory.getLogger(MappingAnalyser.class);

    /**
     * XML文档
     */
    private Document document;

    /**
     * 解析后的folder对象
     */
    private Folder folder;

    /**
     * 执行日志
     */
    private final Logbook logbook=new Logbook();

    private boolean continueError;

    public MappingAnalyser(File file) throws FileNotFoundException {
        this(new FileInputStream(file));
    }

    public MappingAnalyser(InputStream inputStream) {
        this.loadDocument(inputStream);
    }

    /**
     * 通过流构造解析器 结束后会关闭流
     * @param inputStream 输入流
     */
    private void loadDocument(InputStream inputStream) {
        //加载XML文档
        if(inputStream==null){
            logbook.seriousError("加载XML文档", "Parameter 'inputStream' is null.");
        }
        //读取XML文件
        try(InputStream is=inputStream;
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            SAXReader reader = new SAXReader();
            reader.setValidation(true);
            resetDtdSource(reader);
            this.document = reader.read(isr);
            logbook.success("加载XML文档");
        }catch (Exception e){
            logger.error("加载XML文档失败",e);
            logbook.seriousError("加载XML文档", e.getMessage());
        }
    }

    /**
     * 解析XML文档
     */
    public Result analyse(){
        if(folder!=null){
            return new Result(this.checkSuccess(),this.folder,this.logbook);
        }
        if(document!=null) {
            try {
                this.analyseDocument();
                logbook.success("解析XML文档");
            } catch (Exception e) {
                logger.error("出现异常", e);
                logbook.seriousError("解析XML文档", e.getMessage());
            }
            //返回结果
            return new Result(this.checkSuccess(),this.folder,this.logbook);
        }else {
            throw new RuntimeException("XML文档未加载");
        }
    }

    /**
     * 将XML文档解析为bean
     */
    private void analyseDocument(){
        useChild(document.getRootElement(),"REPOSITORY",repoE->{
            useChild(repoE,"FOLDER",folderE->{
                //解析folder节点
                this.folder=convertToBean(folderE,Folder.class);

                //解析source节点
                useChildren(folderE,"SOURCE",sourcesE->{
                    this.folder.setSources(sourcesE.stream().map(sourceE->{
                        Source source=convertToBean(sourceE, Source.class);
                        useChildren(sourceE,"SOURCEFIELD",sourcefieldsE->{
                            source.setSourcefields(sourcefieldsE.stream().map(element -> convertToBean(element, Source.Sourcefield.class)).collect(Collectors.toList()));
                            logbook.success("解析SOURCEFIELD节点");
                        });
                        return source;
                    }).collect(Collectors.toList()));
                    logbook.success("解析SOURCE节点");
                });

                //解析target节点
                useChildren(folderE,"TARGET",targetsE->{
                    this.folder.setTargets(targetsE.stream().map(targetE->{
                        Target target=convertToBean(targetE, Target.class);
                        useChildren(targetE,"TARGETFIELD",targetfieldsE->{
                            target.setTargetfields(targetfieldsE.stream().map(element -> convertToBean(element, Target.Targetfield.class)).collect(Collectors.toList()));
                            logbook.success("解析TARGETFIELD节点");
                        });
                        return target;
                    }).collect(Collectors.toList()));
                    logbook.success("解析TARGET节点");
                });

                //解析mapping节点
                useChildren(folderE,"MAPPING",mappingsE->{

                    this.folder.setMappings(mappingsE.stream().map(mappingE->{
                        Mapping mapping=convertToBean(mappingE,Mapping.class);
                        //解析TRANSFORMATION节点
                        useChildren(mappingE,"TRANSFORMATION",transformationsE->{
                            if(transformationsE.size()>1||!TransformationType.SOURCE_QUALIFIER.getValue().equals(transformationsE.get(0).attribute("TYPE").getValue())){
                                logbook.seriousError("解析TRANSFORMATION节点","目前只支持单个转换实例，且类型必须为Source Qualifier");
                                if(!continueError) {
                                    return;
                                }
                            }
                            mapping.setTransformations(transformationsE.stream().map(transformationE->{
                                Transformation transformation=convertToBean(transformationE, Transformation.class);
                                //设置转换的字段信息
                                useChildren(transformationE,"TRANSFORMFIELD",transformfieldsE->{
                                    transformation.setTransformfields(transformfieldsE.stream().map(element -> convertToBean(element, Transformation.Transformfield.class)).collect(Collectors.toList()));
                                    logbook.success("解析TRANSFORMFIELD节点");
                                });
                                //设置转换的属性信息
                                useChildren(transformationE,"TABLEATTRIBUTE",tableattributesE->{
                                    transformation.setTableattributes(tableattributesE.stream().map(element -> convertToBean(element, Transformation.Tableattribute.class)).collect(Collectors.toList()));
                                    logbook.success("解析TABLEATTRIBUTE节点");
                                });
                                return transformation;
                            }).collect(Collectors.toList()));
                            logbook.success("解析TRANSFORMATION节点");
                        });

                        //解析INSTANCE节点
                        useChildren(mappingE,"INSTANCE",instancesE->{
                            mapping.setInstances(instancesE.stream().map(element -> convertToBean(element, Instance.class)).collect(Collectors.toList()));
                            logbook.success("解析INSTANCE节点");
                        });

                        //解析CONNECTOR节点
                        useChildren(mappingE,"CONNECTOR",connectorsE->{
                            mapping.setConnectors(connectorsE.stream().map(element -> convertToBean(element, Connector.class)).collect(Collectors.toList()));
                            logbook.success("解析CONNECTOR节点");
                        });
                        return mapping;
                    }).collect(Collectors.toList()));

                });
            });
        });
    }

    /**
     * 加载DTD文件
     * @param reader
     */
    private void resetDtdSource(SAXReader reader){
        InputStream inputStream=this.getClass().getResourceAsStream("/powrmart.dtd");
        if(inputStream!=null){
            reader.setEntityResolver((publicId, systemId) -> new InputSource(inputStream));
        }else {
            logger.error("加载DTD文件失败");
        }
    }

    /**
     * 获取单个下级节点并消费
     * @param element 当前元素
     * @param childName 下级元素名称
     * @param consumer
     */
    private void useChild(Element element, String childName, Consumer<Element> consumer){
        List<Element> children=element.elements(childName);
        if(children.isEmpty()){
            logbook.seriousError("寻找"+childName+"节点","未找到"+childName+"节点");
        }else {
            if(children.size()>1){
                logbook.warning("寻找"+childName+"节点","找到多个"+childName+"节点");
            }else {
                logbook.success("寻找"+childName+"节点");
            }
            consumer.accept(children.get(0));
        }
    }

    /**
     * 获取多个下级节点并消费
     * @param element 当前元素
     * @param childName 下级元素名称
     * @param consumer
     */
    private void useChildren(Element element, String childName, Consumer<List<Element>> consumer){
        List<Element> children=element.elements(childName);
        if(children.isEmpty()){
            logbook.seriousError("寻找"+childName+"节点","未找到"+childName+"节点");
        }else {
            logbook.success("寻找"+childName+"节点");
            consumer.accept(children);
        }
    }

    /**
     * 使用反射将XML元素转换为Java对象
     * @param element XML元素
     * @param clazz Java对象
     * @param <T>
     * @return
     */
    private <T> T convertToBean(Element element,Class<T> clazz) {
        try {
            T object=clazz.newInstance();
            Field[] fields=clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                if(String.class==field.getType()) {
                    Attribute attribute = element.attribute(name);
                    if (attribute != null) {
                        try {
                            field.set(object, attribute.getValue());
                        } catch (IllegalAccessException e) {
                            logger.error("出现异常",e);
                        }
                    }
                }
            }
            return object;
        } catch (InstantiationException | IllegalAccessException e) {
            logger.error(clazz+"缺少无参构造器",e);
            throw new RuntimeException(clazz+"缺少无参构造器",e);
        }
    }

    /**
     * 是否解析成功
     * @return
     */
    private boolean checkSuccess() {
        //没有发生严重错误即为成功
        return !logbook.isEmpty()&&logbook.stream().noneMatch(item->item.getState().equals(ActionState.SERIOUS_ERROR));
    }

    public void setContinueError(boolean continueError) {
        this.continueError = continueError;
    }

    /**
     * 解析结果
     */
    public static class Result {

        /**
         * 是否成功
         */
        private final boolean success;

        /**
         * 解析后的folder对象
         */
        private final Folder folder;

        /**
         * 执行日志
         */
        private final Logbook logbook;

        private Result(boolean success, Folder folder, Logbook logbook) {
            this.success = success;
            this.folder = folder;
            this.logbook = logbook;
        }

        public boolean isSuccess() {
            return success;
        }

        public Folder getFolder() {
            return folder;
        }

        public Logbook getLogbook() {
            return logbook;
        }

    }

}
