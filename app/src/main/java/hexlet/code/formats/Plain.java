package hexlet.code.formats;

import hexlet.code.Constants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Plain {

    public static String plain(List<Map<String, Object>> listMaps) {

        StringBuilder result = new StringBuilder();
        List<String> formatResult = new ArrayList<>();
        List<String> updateKeys = new ArrayList<>(listMaps.get(Constants.UPDATE_MAP).keySet());
        List<String> addKeys = new ArrayList<>(listMaps.get(Constants.ADD_MAP).keySet());
        List<String> removeKeys = new ArrayList<>(listMaps.get(Constants.REMOVE_MAP).keySet());

        for (int i = 0; i < updateKeys.size() / 2; i = i + 1) {
            formatResult.add("Property '" + updateKeys.get(i).substring(2) + "' was updated. From "
                    + formatValue(listMaps.get(Constants.UPDATE_MAP).get(updateKeys.get(updateKeys.size() / 2 + i)))
                    + " to " + formatValue(listMaps.get(Constants.UPDATE_MAP).get(updateKeys.get(i))));
        }

        for (String key : addKeys) {
            formatResult.add("Property '" + key.substring(2) + "' was added with value: "
                    + formatValue(listMaps.get(1).get(key)));
        }

        for (String key : removeKeys) {
            formatResult.add("Property '" + key.substring(2) + "' was removed");
        }

        formatResult.sort(Comparator.comparing(s -> s.substring(10)));

        for (String format : formatResult) {
            result.append("\n").append(format);
        }
        return result.toString();
    }

    private static Object formatValue(Object object) {

        if (object instanceof List || object instanceof Map) {
            object = "[complex value]";
        } else if (object instanceof String) {
            object = "'" + object + "'";
        }
        return object;
    }
}
