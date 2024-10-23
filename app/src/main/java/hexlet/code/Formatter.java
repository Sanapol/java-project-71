package hexlet.code;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Formatter {

    public static String format(List<String> data) {
        String result = "{";
        Collections.sort(data, Comparator.comparing(s -> s.charAt(2)));

        for (String results : data) {
            result = result + "\n  " + results;
        }
        result = result + "\n}";
        return result;
    }
}
