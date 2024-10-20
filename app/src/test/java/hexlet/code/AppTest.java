package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    public void app() throws Exception {
        var result = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        var answer = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        assertEquals(result, answer);
    }
}
