package infor.xml.log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 日志工具类
 */
public class LogUtil {

    public static void outputToFile(String filename,Logbook logbook){
        Path path = Paths.get(filename);
        try (BufferedWriter writer =
                     Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (LogLine line:logbook){
                writer.write(line.toString()+"\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
