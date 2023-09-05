package infor.xml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import infor.xml.analyser.DataLeapBuilder;
import infor.xml.analyser.MappingAnalyser;
import infor.xml.analyser.SituationAnalyser;
import infor.xml.bean.informatica.Folder;
import infor.xml.log.LogLine;
import infor.xml.log.LogUtil;
import infor.xml.log.Logbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Starter {

    public static void main(String[] args) throws IOException {

        Path sourcePath;
        Path outputPath;
        if(args.length==0){
            System.out.println("缺少启动参数：java -jar jarfile 源文件夹 输出文件夹");
            return;
        }else if(args.length==1) {
            sourcePath=Paths.get(args[0]);
            outputPath=Paths.get(System.getProperty("user.dir")+File.separator+"output");
        }else {
            sourcePath=Paths.get(args[0]);
            outputPath=Paths.get(args[1]);
        }

        System.out.println("开始执行...");

        if(!Files.exists(sourcePath)){
            throw new RuntimeException("'"+sourcePath+"' 不存在");
        }
        if(!Files.exists(outputPath)){
            Files.createDirectories(outputPath);
        }

        //convertToJson(sourcePath,outputPath);

        analyseCurrentSituation(sourcePath,outputPath);

        System.out.println("执行完毕，结果输出至："+outputPath);

    }

    /**
     * 分析当前文件难易状况
     * @param sourcePath
     * @param outputPath
     * @throws IOException
     */
    public static void analyseCurrentSituation(Path sourcePath,Path outputPath) throws IOException {
        //开始处理
        AtomicInteger counter=new AtomicInteger();
        List<MappingAnalyser.Result> mappingResults=Files.list(sourcePath).filter(path->path.toString().toLowerCase().endsWith(".xml")).map(path->{
            try {
                System.out.println(counter.incrementAndGet()+"：正在解析文件 "+path);
                MappingAnalyser mappingAnalyser=new MappingAnalyser(Files.newInputStream(path));
                mappingAnalyser.setContinueError(true);
                MappingAnalyser.Result result=mappingAnalyser.analyse();
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println("所有文件解析完毕。");
        SituationAnalyser situationAnalyser=new SituationAnalyser(mappingResults);
        //String str=situationAnalyser.overall(outputPath);
        String str=situationAnalyser.functionUsed(outputPath);

        System.out.println(str);
    }

    /**
     * 转换为json
     * @param sourcePath
     * @param outputPath
     * @throws IOException
     */
    public static void convertToJson(Path sourcePath,Path outputPath) throws IOException {
        //创建文件夹
        String logSuccessPath=outputPath+File.separator+"logs"+File.separator+"success"+File.separator;
        Files.createDirectories(Paths.get(logSuccessPath));
        String logErrorPath=outputPath+File.separator+"logs"+File.separator+"error"+File.separator;
        Files.createDirectories(Paths.get(logErrorPath));

        //开始处理
        Gson gson=new GsonBuilder().setPrettyPrinting().create();
        Files.list(sourcePath).filter(path->path.toString().toLowerCase().endsWith(".xml")).forEach(path->{
            try {
                Path filename=path.getFileName();
                MappingAnalyser mappingAnalyser=new MappingAnalyser(Files.newInputStream(path));
                MappingAnalyser.Result result=mappingAnalyser.analyse();
                if(result.isSuccess()){
                    DataLeapBuilder builder=new DataLeapBuilder(result);
                    Map<String,JsonObject> jos=builder.build();
                    LogUtil.outputToFile(logSuccessPath+filename+".log",result.getLogbook());
                    jos.forEach((mappingName,jo)->outputJsonToFile(outputPath+File.separator+mappingName+".json",gson.toJson(jo)));
                    System.out.println("成功 "+filename);
                }else {
                    LogUtil.outputToFile(logErrorPath+filename+".log",result.getLogbook());
                    System.out.println("失败 "+filename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void outputJsonToFile(String filename, String json){
        Path path = Paths.get(filename);
        try (BufferedWriter writer =
                     Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
