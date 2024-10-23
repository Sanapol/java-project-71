package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {

    public static String readFile(String fileName) throws Exception {
        Path filepath = Paths.get("src", "main", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
        return Files.readString(filepath).trim();
    }

    public static String getFormat(String filepath) {
        return "";
    }
}
