package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Matcher {

    public static List<Map<String, Object>> match(Map<String, Object> parsedFile1, Map<String, Object> parsedFile2) {
        List<String> keys = new ArrayList<>();
        keys.addAll(parsedFile1.keySet());
        keys.addAll(parsedFile2.keySet());

        return matchChanges(keys, parsedFile1, parsedFile2);
    }

    private static List<Map<String, Object>> matchChanges(
            List<String> keys, Map<String, Object> parsedFile1, Map<String, Object> parsedFile2) {
        List<Map<String, Object>> matchFiles = new ArrayList<>();
        Map<String, Object> update = new TreeMap<>();
        Map<String, Object> nothing = new TreeMap<>();
        Map<String, Object> remove = new TreeMap<>();
        Map<String, Object> add = new TreeMap<>();

        for (String key : keys) {

            if (!parsedFile1.containsKey(key)) {

                add.put("+ " + key, parsedFile2.get(key));

            } else if (!parsedFile2.containsKey(key)) {

                remove.put("- " + key, parsedFile1.get(key));

            } else if (parsedFile1.get(key) == null || parsedFile2.get(key) == null
                    || !parsedFile1.get(key).equals(parsedFile2.get(key))) {

                update.put("- " + key, parsedFile1.get(key));
                update.put("+ " + key, parsedFile2.get(key));

            } else {
                nothing.put("  " + key, parsedFile1.get(key));
            }
        }

        matchFiles.add(update);
        matchFiles.add(add);
        matchFiles.add(remove);
        matchFiles.add(nothing);
        return matchFiles;
    }
}
