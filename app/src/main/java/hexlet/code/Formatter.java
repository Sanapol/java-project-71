package hexlet.code;

import java.util.Comparator;
import java.util.List;

public class Formatter {

    public static String format(List<String> data, String format) {
        data.sort(Comparator.comparing(s -> s.substring(2, 5)));
        return switch (format) {
            case "stylish" -> stylish(data);
            case "change" -> "";
            default -> throw new RuntimeException("format error");
        };
    }

    public static String stylish(List<String> data) {
        StringBuilder result = new StringBuilder("{");

        for (String results : data) {
            result.append("\n  ").append(results);
        }
        result.append("\n}");
        return result.toString();
    }
}
