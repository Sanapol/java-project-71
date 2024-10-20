package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {

    public static String readFile(String filepath) throws Exception{
        var path = Paths.get(filepath);
        return Files.readString(path).trim();
    }

    public static String getFormat(String filepath) {
        return "";
    }
}
