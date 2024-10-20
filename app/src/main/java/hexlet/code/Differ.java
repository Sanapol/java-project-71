package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {

    public static Map<String, Object> generate(String filepath1, String filepath2) throws Exception {
        String file1 = Reader.readFile(filepath1);
        String file2 = Reader.readFile(filepath2);

        String fileFormat1 = Reader.getFormat(filepath1);
        String fileFormat2 = Reader.getFormat(filepath2);

        Map<String, Object> parsedFile1 = Parser.parse(file1);
        Map<String, Object> parsedFile2 = Parser.parse(file2);

        //List<Map<String, Object>> result = Matcher.match(parsedFile1, parsedFile2);
        //return Formatter.format(result);
        return parsedFile1;
    }
}
