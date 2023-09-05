package infor.xml.analyser;

import org.dom4j.DocumentException;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MappingAnalyserTest {

    @Test
    public void text() throws DocumentException, IOException {
        String str="IIF(IS_SPACES(name1),null,name1)";
        str=str.replace(" ","").toLowerCase();
        String pattern = "(\\w)+\\(";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        while(m.find())
        {
            System.out.println( "匹配项：" + m.group() ); //group方法返回由以前匹配操作所匹配的输入子序列。
        }
    }

}