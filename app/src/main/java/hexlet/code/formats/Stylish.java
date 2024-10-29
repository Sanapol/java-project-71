package hexlet.code.formats;

import hexlet.code.Constants;
import hexlet.code.Merger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Stylish {

    public static String stylish(List<Map<String, Object>> listMaps) {
        StringBuilder result = new StringBuilder("{");
        Map<String, Object> maps = Merger.mergerMaps(listMaps);
        List<String> formatKeys = Merger.mergerKeys(listMaps);

        formatKeys.sort(Comparator.comparing(s -> s.substring(Constants.KEY_WITHOUT_MARK)));

        for (String readyKeys : formatKeys) {
            result.append("\n  ").append(readyKeys).append(": ").append(maps.get(readyKeys));
        }
        result.append("\n}");
        return result.toString();
    }
}
