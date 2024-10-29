package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Merger {

    public static List<String> mergerKeys(List<Map<String, Object>> listMaps) {
        List<String> formatKeys = new ArrayList<>();
        List<String> keysUpdate = new ArrayList<>(listMaps.get(Constants.UPDATE_MAP).keySet());
        List<String> keysAdd = new ArrayList<>(listMaps.get(Constants.ADD_MAP).keySet());
        List<String> keysRemove = new ArrayList<>(listMaps.get(Constants.REMOVE_MAP).keySet());
        List<String> keysNothing = new ArrayList<>(listMaps.get(Constants.NOTHING_MAP).keySet());
        formatKeys.addAll(keysAdd);
        formatKeys.addAll(keysRemove);
        formatKeys.addAll(keysNothing);

        for (int i = keysUpdate.size() - 1; i >= 0; i--) {
            formatKeys.add(keysUpdate.get(i));
        }
        return formatKeys;
    }

    public static Map<String, Object> mergerMaps(List<Map<String, Object>> listMaps) {
        Map<String, Object> maps = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>(listMaps.get(Constants.UPDATE_MAP));
        Map<String, Object> map2 = new HashMap<>(listMaps.get(Constants.ADD_MAP));
        Map<String, Object> map3 = new HashMap<>(listMaps.get(Constants.REMOVE_MAP));
        Map<String, Object> map4 = new HashMap<>(listMaps.get(Constants.NOTHING_MAP));
        maps.putAll(map1);
        maps.putAll(map2);
        maps.putAll(map3);
        maps.putAll(map4);

        return maps;
    }
}
