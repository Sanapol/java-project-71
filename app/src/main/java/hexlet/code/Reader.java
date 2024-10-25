package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader {

    public static String readFile(String fileName) throws Exception {
        Path filepath = null;
        if (fileName.contains("/")) {
            filepath = Paths.get(fileName);
        } else {
            filepath = Paths.get("src", "main", "resources", "fixtures", fileName)
                    .toAbsolutePath().normalize();
        }
        return Files.readString(filepath).trim();
    }

    public static String getFormat(String filepath) {
        var format = filepath.split("\\.");
        return format[format.length - 1];
    }
}
