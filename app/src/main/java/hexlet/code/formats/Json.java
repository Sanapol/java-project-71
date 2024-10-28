package hexlet.code.formats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Constains;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Json {
    public static String json(List<Map<String, Object>> listMaps) throws JsonProcessingException {
        StringBuilder list = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> maps = mergeMaps(listMaps);
        List<String> formatKeys = mergeKeys(listMaps);

        formatKeys.sort(Comparator.comparing(s -> s.substring(1)));

        for (String readyKeys : formatKeys) {
            objectMapper.writeValueAsString(list.append("\n  ").append(readyKeys).append(": ")
                    .append(maps.get(readyKeys)));
        }
        return list.toString();
    }

    private static List<String> mergeKeys(List<Map<String, Object>> listMaps) {
        List<String> formatKeys = new ArrayList<>();
        List<String> keysUpdate = new ArrayList<>(listMaps.get(Constains.UPDATE_MAP).keySet());
        List<String> keysAdd = new ArrayList<>(listMaps.get(Constains.ADD_MAP).keySet());
        List<String> keysRemove = new ArrayList<>(listMaps.get(Constains.REMOVE_MAP).keySet());
        List<String> keysNothing = new ArrayList<>(listMaps.get(Constains.NOTHING_MAP).keySet());
        formatKeys.addAll(keysAdd);
        formatKeys.addAll(keysRemove);
        formatKeys.addAll(keysNothing);

        for (int i = keysUpdate.size() - 1; i >= 0; i--) {
            formatKeys.add(keysUpdate.get(i));
        }
        return formatKeys;
    }

    private static Map<String, Object> mergeMaps(List<Map<String, Object>> listMaps) {
        Map<String, Object> maps = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>(listMaps.get(Constains.UPDATE_MAP));
        Map<String, Object> map2 = new HashMap<>(listMaps.get(Constains.ADD_MAP));
        Map<String, Object> map3 = new HashMap<>(listMaps.get(Constains.REMOVE_MAP));
        Map<String, Object> map4 = new HashMap<>(listMaps.get(Constains.NOTHING_MAP));
        maps.putAll(map1);
        maps.putAll(map2);
        maps.putAll(map3);
        maps.putAll(map4);

        return maps;
    }
}
