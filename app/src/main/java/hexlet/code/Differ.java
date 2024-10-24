package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        String file1 = Reader.readFile(filepath1);
        String file2 = Reader.readFile(filepath2);

        String fileFormat1 = Reader.getFormat(file1);
        String fileFormat2 = Reader.getFormat(file2);

        Map<String, Object> parsedFile1 = Parser.parse(file1);
        Map<String, Object> parsedFile2 = Parser.parse(file2);

        List<String> result = Matcher.match(parsedFile1, parsedFile2);
        return Formatter.format(result);
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String file1 = Reader.readFile(filepath1);
        String file2 = Reader.readFile(filepath2);

        Map<String, Object> parsedFile1 = Parser.parse(file1);
        Map<String, Object> parsedFile2 = Parser.parse(file2);

        List<String> result = Matcher.match(parsedFile1, parsedFile2);
        return Formatter.format(result);
    }
}
