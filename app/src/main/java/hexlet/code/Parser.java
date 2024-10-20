package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> scoreByName = mapper.readValue(content, Map.class);
        return scoreByName;
    }
}
