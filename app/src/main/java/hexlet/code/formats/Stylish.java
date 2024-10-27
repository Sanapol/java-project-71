package hexlet.code.formats;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Stylish {

    public static String stylish(List<Map<String, Object>> listMaps) {
        StringBuilder result = new StringBuilder("{");
        Map<String, Object> maps = mergeMaps(listMaps);
        List<String> formatKeys = mergeKeys(listMaps);

        formatKeys.sort(Comparator.comparing(s -> s.substring(1)));

        for (String readyKeys : formatKeys) {
            result.append("\n  ").append(readyKeys).append(": ").append(maps.get(readyKeys));
        }
        result.append("\n}");
        return result.toString();
    }

    private static List<String> mergeKeys(List<Map<String, Object>> listMaps) {
        List<String> formatKeys = new ArrayList<>();
        List<String> keysUpdate = new ArrayList<>(listMaps.get(0).keySet());
        List<String> keysAdd = new ArrayList<>(listMaps.get(1).keySet());
        List<String> keysRemove = new ArrayList<>(listMaps.get(2).keySet());
        List<String> keysNothing = new ArrayList<>(listMaps.get(3).keySet());
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
        Map<String, Object> map1 = new HashMap<>(listMaps.get(0));
        Map<String, Object> map2 = new HashMap<>(listMaps.get(1));
        Map<String, Object> map3 = new HashMap<>(listMaps.get(2));
        Map<String, Object> map4 = new HashMap<>(listMaps.get(3));
        maps.putAll(map1);
        maps.putAll(map2);
        maps.putAll(map3);
        maps.putAll(map4);

        return maps;
    }
}
