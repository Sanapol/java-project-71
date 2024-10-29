package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class Matcher {

    public static List<Map<String, Object>> match(Map<String, Object> parsedFile1, Map<String, Object> parsedFile2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> update = new TreeMap<>();
        Map<String, Object> add = new TreeMap<>();
        Map<String, Object> remove = new TreeMap<>();
        Map<String, Object> nothing = new TreeMap<>();
        Set<Map.Entry<String, Object>> file1 = parsedFile1.entrySet();
        Set<Map.Entry<String, Object>> file2 = parsedFile2.entrySet();

        for (Map.Entry<String, Object> entry : file1) {

            if (parsedFile2.containsKey(entry.getKey())) {

                if (entry.getValue() == null || parsedFile2.get(entry.getKey()) == null
                        || !entry.getValue().equals(parsedFile2.get(entry.getKey()))) {
                    update.put("- " + entry.getKey(), entry.getValue());
                    update.put("+ " + entry.getKey(), parsedFile2.get(entry.getKey()));
                } else {
                    nothing.put("  " + entry.getKey(), entry.getValue());
                }

            } else {
                remove.put("- " + entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<String, Object> entry : file2) {

            if (!parsedFile1.containsKey(entry.getKey())) {
                add.put("+ " + entry.getKey(), entry.getValue());
            }
        }
        result.add(update);
        result.add(add);
        result.add(remove);
        result.add(nothing);
        return result;
    }
}
