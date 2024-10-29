package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, String format) throws Exception {
        ObjectMapper mapperJson = new ObjectMapper();
        ObjectMapper mapperYaml = new YAMLMapper();
        format = format.toLowerCase();

        return switch (format) {
            case Constants.JSON_FORMAT -> mapperJson.readValue(content, Map.class);
            case Constants.YAML_FORMAT, Constants.YML_FORMAT -> mapperYaml.readValue(content, Map.class);
            default -> throw new RuntimeException("Unknown format");
        };

    }
}
