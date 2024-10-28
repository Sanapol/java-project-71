package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    public void test1() throws Exception {
        var result = Differ.generate("file1.yaml", "file2.yaml");
        var answer = Files.readString(Paths.get("src/test/resources/fixtures/answerStylish")).trim();

        assertEquals(result, answer);
    }

    @Test
    public void test2() throws Exception {
        var result = Differ.generate("src/main/resources/fixtures/file1.json",
                "src/main/resources/fixtures/file2.json", "plain");
        var answer = Files.readString(Paths.get("src/test/resources/fixtures/answerPlain")).trim();

        assertEquals(result, answer);
    }

    @Test
    public void test3() throws Exception {
        var result = Differ.generate("src/main/resources/fixtures/file1.json",
                "src/main/resources/fixtures/file2.json", "json");
        var answer = Files.readString(Paths.get("src/test/resources/fixtures/answerJson")).trim();

        assertEquals(result, answer);
    }
}
