package hexlet.code;

import java.util.*;

public class Formatter {

    public static String format(List<Map<String, Object>> map, String format) {
        String trueFormat = format.toLowerCase();

        return switch (trueFormat) {
            case "stylish" -> stylish(map);
            case "plain" -> plain(map);
            default -> throw new RuntimeException("format error");
        };
    }

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


    public static String plain(List<Map<String, Object>> listMaps) {
        StringBuilder result = new StringBuilder();
        List<String> formatResult = new ArrayList<>();
        List<String> map1 = new ArrayList<>(listMaps.get(0).keySet());
        List<String> map2 = new ArrayList<>(listMaps.get(1).keySet());
        List<String> map3 = new ArrayList<>(listMaps.get(2).keySet());

            for (int i = 0; i < map1.size() / 2; i = i + 1) {
                formatResult.add("Property '" + map1.get(i).substring(2) + "' was updated. From " +
                        listMaps.get(0).get(map1.get(map1.size() / 2 + i)) + " to " + listMaps.get(0).get(map1.get(i)));
            }


        for (String format : formatResult) {
            result.append("\n").append(format);
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
