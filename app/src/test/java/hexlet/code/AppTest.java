package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    public void app() throws Exception {
        var file1 = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        var file2 = Differ.generate("src/test/resources/file2.json",
                "src/test/resources/file2.json");

        var result = Matcher.match(file1, file2);
        System.out.println(result);
        assertEquals(file1, file1);
    }
}
