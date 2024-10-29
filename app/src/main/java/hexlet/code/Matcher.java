package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

public class Matcher {

    public static List<Map<String, Object>> match(Map<String, Object> parsedFile1, Map<String, Object> parsedFile2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Set<Map.Entry<String, Object>> file1 = parsedFile1.entrySet();
        Set<Map.Entry<String, Object>> file2 = parsedFile2.entrySet();

        result.add(matchUpdate(file1, parsedFile2));
        result.add(matchAdd(file2, parsedFile1));
        result.add(matchRemove(file1, parsedFile2));
        result.add(matchNothing(file1, parsedFile2));
        return result;
    }

    private static Map<String, Object> matchUpdate(
            Set<Map.Entry<String, Object>> entryFile1, Map<String, Object> parsedFile2) {
        Map<String, Object> update = new TreeMap<>();

        for (Map.Entry<String, Object> entry : entryFile1) {

            if (parsedFile2.containsKey(entry.getKey())) {

                if (entry.getValue() == null || parsedFile2.get(entry.getKey()) == null
                        || !entry.getValue().equals(parsedFile2.get(entry.getKey()))) {
                    update.put("- " + entry.getKey(), entry.getValue());
                    update.put("+ " + entry.getKey(), parsedFile2.get(entry.getKey()));
                }
            }
        }
        return update;
    }

    private static Map<String, Object> matchNothing(
            Set<Map.Entry<String, Object>> entryFile1, Map<String, Object> parsedFile2) {
        Map<String, Object> nothing = new TreeMap<>();

        for (Map.Entry<String, Object> entry : entryFile1) {

            if (parsedFile2.containsKey(entry.getKey())) {

                if (entry.getValue() != null && parsedFile2.get(entry.getKey()) != null
                        && entry.getValue().equals(parsedFile2.get(entry.getKey()))) {
                    nothing.put("  " + entry.getKey(), entry.getValue());
                }
            }
        }
        return nothing;
    }

    private static Map<String, Object> matchRemove(
            Set<Map.Entry<String, Object>> entryFile1, Map<String, Object> parsedFile2) {
        Map<String, Object> remove = new TreeMap<>();

        for (Map.Entry<String, Object> entry : entryFile1) {

            if (!parsedFile2.containsKey(entry.getKey())) {

                remove.put("- " + entry.getKey(), entry.getValue());
            }
        }
        return remove;
    }

    private static Map<String, Object> matchAdd(
            Set<Map.Entry<String, Object>> entryFile2, Map<String, Object> parsedFile1) {
        Map<String, Object> add = new TreeMap<>();

        for (Map.Entry<String, Object> entry : entryFile2) {

            if (!parsedFile1.containsKey(entry.getKey())) {
                add.put("+ " + entry.getKey(), entry.getValue());
            }
        }
        return add;
    }
}
