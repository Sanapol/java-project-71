package hexlet.code.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Constants;
import hexlet.code.Merger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Json {
    public static String json(List<Map<String, Object>> listMaps) throws JsonProcessingException {
        StringBuilder list = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> maps = Merger.mergerMaps(listMaps);
        List<String> formatKeys = Merger.mergerKeys(listMaps);

        formatKeys.sort(Comparator.comparing(s -> s.substring(Constants.KEY_WITHOUT_MARK)));

        for (String readyKeys : formatKeys) {
            list.append("  ").append(readyKeys).append(": ")
                    .append(maps.get(readyKeys));
        }
        return objectMapper.writeValueAsString(list.toString());
    }
}
