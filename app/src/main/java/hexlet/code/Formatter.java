package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formats.Json;
import hexlet.code.formats.Plain;
import hexlet.code.formats.Stylish;

import java.util.List;
import java.util.Map;


public class Formatter {

    public static String format(List<Map<String, Object>> map, String format) throws JsonProcessingException {
        String trueFormat = format.toLowerCase();

        return switch (trueFormat) {
            case Constants.STYLISH_FORMAT -> Stylish.create(map);
            case Constants.PLAIN_FORMAT -> Plain.create(map);
            case Constants.JSON_FORMAT -> Json.create(map);
            default -> throw new RuntimeException("format error");
        };
    }
}
