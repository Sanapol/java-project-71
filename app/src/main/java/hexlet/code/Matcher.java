package hexlet.code;

import java.util.*;

public class Matcher {

    public static List<String> match(Map<String, Object> parsedFile1, Map<String, Object> parsedFile2) {
        List<String> result = new ArrayList<>();
        Set<Map.Entry<String, Object>> file1 = parsedFile1.entrySet();
        Set<Map.Entry<String, Object>> file2 = parsedFile2.entrySet();

        for (Map.Entry<String, Object> entry : file1) {
            if (parsedFile2.containsKey(entry.getKey())) {
                if (entry.getValue().equals(parsedFile2.get(entry.getKey()))) {
                    System.out.println(entry.getValue());
                    System.out.println(parsedFile2.get(entry.getKey()));
                    result.add(createString(entry.getKey(), entry.getValue(), "not change"));
                } else {
                    result.add(createString(entry.getKey(), entry.getValue(), "change"));
                    result.add(createString(entry.getKey(), parsedFile2.get(entry.getKey()), "add"));
                }
            } else {
                result.add(createString(entry.getKey(), entry.getValue(), "change"));
            }
        }

        for (Map.Entry<String, Object> entry : file2) {
            if (!parsedFile1.containsKey(entry.getKey())) {
                result.add(createString(entry.getKey(), entry.getValue(), "add"));
            }
        }

        return result;
    }

    public static String createString(String key, Object value, String status) {
        String stringMap = "";
        switch (status) {
            case "not change":
                return "  " + key + ": " + value;
            case "change":
                return "- " + key + ": " + value;
            case "add":
                return "+ " + key + ": " + value;
            default:
                throw new RuntimeException("wrong operations");
        }
    }
}
