package infor.xml.analyser;

import com.google.gson.Gson;
import infor.xml.bean.informatica.Instance;
import infor.xml.bean.informatica.Transformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * 统计分析当前xml使用转换的多少
 */
public class SituationAnalyser {

    private final Logger logger= LoggerFactory.getLogger(DataLeapBuilder.class);

    /**
     * 解析后的folder对象
     */
    private final List<MappingAnalyser.Result> mappingResults;

    public SituationAnalyser(List<MappingAnalyser.Result> results) {
        this.mappingResults = results;
    }

    public String analyse(Path outputPath){
        StringBuilder sb=new StringBuilder();
        AtomicInteger totalCount=new AtomicInteger(mappingResults.size());
        AtomicInteger successCount=new AtomicInteger();
        AtomicInteger errorCount=new AtomicInteger();
        AtomicInteger multipleTransCount=new AtomicInteger();
        AtomicInteger multipleSourceCount=new AtomicInteger();
        AtomicInteger multipleTargetCount=new AtomicInteger();
        Map<String,Map<String,String>> eachFileResult=new HashMap<>();
        List<Transformation> allTransformations=new ArrayList<>();
        mappingResults.stream().collect(Collectors.groupingBy(r->r.getFolder().getNAME())).forEach((folderName,results)->{
            Map<String,String> map=new HashMap<>();
            eachFileResult.put(folderName,map);

            results.forEach(result->{
                String mappingName=result.getFolder().getMapping().getNAME();
                if(result.isSuccess()){
                    if(mappingName!=null&&!mappingName.trim().equals("")){
                        map.put(mappingName,"成功");
                    }
                    successCount.incrementAndGet();
                }else {
                    if(mappingName!=null&&!mappingName.trim().equals("")){
                        map.put(mappingName,"失败");
                    }
                    errorCount.incrementAndGet();
                }
                List<Transformation> transformations=result.getFolder().getMapping().getTransformations();
                if(transformations!=null) {
                    allTransformations.addAll(transformations);
                    if (transformations.size() > 1) {
                        //有多个转换的文件数量
                        multipleTransCount.incrementAndGet();
                    }
                }
                List<Instance> instances=result.getFolder().getMapping().getInstances();
                if(instances!=null&&!instances.isEmpty()) {
                    //有多个目标的文件数量
                    if(instances.stream().filter(item->item.getTYPE().equals("SOURCE")).count()>1){
                        multipleSourceCount.incrementAndGet();
                    }
                    //有多个转换的文件数量
                    if(instances.stream().filter(item->item.getTYPE().equals("TARGET")).count()>1){
                        multipleTargetCount.incrementAndGet();
                    }
                }
            });
        });
        Map<String,List<Transformation>> group=allTransformations.stream().collect(Collectors.groupingBy(Transformation::getTYPE));
        sb.append("总文件数量：").append(totalCount.get()).append("\n");
        sb.append("成功文件数量：").append(successCount.get()).append("\n");
        sb.append("失败文件数量：").append(errorCount.get()).append("\n");
        sb.append("有多个源的文件数量：").append(multipleSourceCount.get()).append("\n");
        sb.append("有多个目标的文件数量：").append(multipleTargetCount.get()).append("\n");
        sb.append("有多个转换的文件数量：").append(multipleTransCount.get()).append("\n");
        group.forEach((k,v)-> sb.append("转换类型为").append(k).append("的数量：").append(v.size()).append("\n"));

        Path path = Paths.get(outputPath+ File.separator+"output.log");
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson=new Gson();
        List<List<Transformation>> list=mappingResults.stream().map(result -> result.getFolder().getMapping().getTransformations()).collect(Collectors.toList());
        String jsonStr=gson.toJson(list);
        String eachFileResultStr=gson.toJson(eachFileResult);
        Path jsonPath = Paths.get(outputPath+ File.separator+"output.json");
        Path eachFileResultJsonPath = Paths.get(outputPath+ File.separator+"each_file.json");
        try (BufferedWriter writer = Files.newBufferedWriter(jsonPath, StandardCharsets.UTF_8)) {
            writer.write(jsonStr);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = Files.newBufferedWriter(eachFileResultJsonPath, StandardCharsets.UTF_8)) {
            writer.write(eachFileResultStr);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
