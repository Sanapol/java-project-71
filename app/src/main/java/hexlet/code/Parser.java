package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String format) throws Exception {
        Map<String, Object> result = new HashMap<>();
        ObjectMapper mapperJson = new ObjectMapper();
        ObjectMapper mapperYaml = new YAMLMapper();

        if (format.equals("json")) {
            result = mapperJson.readValue(content, Map.class);
        } else if (format.equals("yaml")) {
            result = mapperYaml.readValue(content, Map.class);
        }
        return result;
    }
}
