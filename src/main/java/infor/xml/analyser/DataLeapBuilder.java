package infor.xml.analyser;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import infor.xml.bean.informatica.*;
import infor.xml.log.Logbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class DataLeapBuilder {

    private final Logger logger= LoggerFactory.getLogger(DataLeapBuilder.class);

    /**
     * 解析后的folder对象
     */
    private final Folder folder;

    /**
     * 执行日志
     */
    private final Logbook logbook;

    public DataLeapBuilder(MappingAnalyser.Result result) {
        this.folder = result.getFolder();
        this.logbook = result.getLogbook();
    }


    /**
     * 构建DataLeap支持的JSON
     * @return
     */
    public Map<String,JsonObject> build(){
        Map<String,JsonObject> result=new HashMap<>();
        this.folder.getMappings().forEach(mapping->{
            String mappingName=this.folder.getNAME()+"_"+mapping.getNAME();
            JsonObject root= null;
            try {
                root = createRoot();
                JsonObject conf=createConf();
                setReaderWriterColumns(conf,mapping);
                root.getAsJsonArray("tasks").get(0).getAsJsonObject().addProperty("conf",conf.toString());
                logbook.success(mappingName+"构建JSON");
            } catch (Exception e) {
                logger.error("出现异常",e);
                logbook.seriousError(mappingName+"构建JSON",e.getMessage());
            }
            result.put(mappingName,root);
        });
        return result;
    }

    /**
     * 创建Reader的列
     * @return
     */
    private void setReaderWriterColumns(JsonObject conf,Mapping mapping){
        JsonArray sourceColumns=new JsonArray();
        JsonArray targetColumns=new JsonArray();
        //获取链接
        List<Connector> connectors=mapping.getConnectors();
        //获取实例
        List<Instance> instances=mapping.getInstances();
        Instance sourceInstance=instances.stream().filter(item->"SOURCE".equals(item.getTYPE())).findFirst().orElse(null);
        Instance targetInstance=instances.stream().filter(item->"TARGET".equals(item.getTYPE())).findFirst().orElse(null);
        Instance transInstance=instances.stream().filter(item->"TRANSFORMATION".equals(item.getTYPE())&&"Expression".equals(item.getTRANSFORMATION_TYPE())).findFirst().orElse(null);
        if(sourceInstance==null){
            throw new RuntimeException("SOURCE实例不存在");
        }
        if(targetInstance==null){
            throw new RuntimeException("TARGET实例不存在");
        }
        if(transInstance==null){
            throw new RuntimeException("Expression类型的TRANSFORMATION实例不存在");
        }
        //获取转换字段
        Map<String,String> transformFields=getTransformFields(mapping,transInstance.getTRANSFORMATION_NAME());
        Map<String,String> sourceFields=getSourceFields(sourceInstance.getTRANSFORMATION_NAME());
        Map<String,String> targetFields=getTargetFields(targetInstance.getTRANSFORMATION_NAME());

        List<Connector> sourceToTrans=connectors.stream()
                .filter(item->item.getFROMINSTANCE().equals(sourceInstance.getNAME())
                        &&item.getTOINSTANCE().equals(transInstance.getNAME())).collect(Collectors.toList());
        List<Connector> transToTarget=connectors.stream()
                .filter(item->item.getFROMINSTANCE().equals(transInstance.getNAME())
                        &&item.getTOINSTANCE().equals(targetInstance.getNAME())).collect(Collectors.toList());
        sourceToTrans.forEach(item->{
            JsonObject column = new JsonObject();
            column.addProperty("type", sourceFields.get(item.getFROMFIELD()));
            column.addProperty("name", item.getFROMFIELD());
            column.addProperty("description", "");
            sourceColumns.add(column);
        });
        transToTarget.forEach(item->{
            JsonObject column = new JsonObject();
            column.addProperty("type", targetFields.get(item.getTOFIELD()));
            column.addProperty("name", item.getTOFIELD());
            column.addProperty("description", "");
            targetColumns.add(column);
        });
        conf.getAsJsonObject("configuration").getAsJsonObject("reader").getAsJsonObject("parameter").add("columns",sourceColumns);
        conf.getAsJsonObject("configuration").getAsJsonObject("writer").getAsJsonObject("parameter").add("columns",targetColumns);
    }

    private Map<String,String> getTransformFields(Mapping mapping,String transformationName){
        return mapping.getTransformations().stream().filter(item->item.getNAME().equals(transformationName)).findFirst()
                .map(value ->
                        value.getTransformfields().stream().collect(Collectors.toMap(Transformation.Transformfield::getNAME, Transformation.Transformfield::getDATATYPE))).orElse(new HashMap<>()
                );
    }

    private Map<String,String> getSourceFields(String sourceName){
        return this.folder.getSources().stream().filter(item->item.getNAME().equals(sourceName)).findFirst().map(item->
                item.getSourcefields().stream().collect(Collectors.toMap(Source.Sourcefield::getNAME, Source.Sourcefield::getDATATYPE))
        ).orElse(new HashMap<>());
    }

    private Map<String,String> getTargetFields(String targetName){
        return this.folder.getTargets().stream().filter(item->item.getNAME().equals(targetName)).findFirst().map(item->
                item.getTargetfields().stream().collect(Collectors.toMap(Target.Targetfield::getNAME, Target.Targetfield::getDATATYPE))
        ).orElse(new HashMap<>());
    }

    private JsonObject createRoot(){
        InputStream inputStream=this.getClass().getResourceAsStream("/data_leap_default.json");
        String jsonStr=readJsonFromStream(inputStream);
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

    private JsonObject createConf(){
        InputStream inputStream=this.getClass().getResourceAsStream("/data_leap_conf_default.json");
        String jsonStr=readJsonFromStream(inputStream);
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

    /**
     * 从流中读取JSON字符串 结束后会关闭流
     * @param inputStream
     * @return
     */
    private String readJsonFromStream(InputStream inputStream){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
            StringBuilder sb=new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("从文件中读取默认JSON出错",e);
        }
    }

}
