package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    private static String answerStylish;
    private static String answerPlain;
    private static String answerJson;

    @BeforeAll
    public static void testsAnswer() throws Exception {

        answerStylish = Files.readString(Paths.get("src/test/resources/fixtures/answerStylish"));
        answerPlain = Files.readString(Paths.get("src/test/resources/fixtures/answerPlain"));
        answerJson = Files.readString(Paths.get("src/test/resources/fixtures/answerJson"));
    }

    @Test
    public void testStylishFormat() throws Exception {
        String result = Differ.generate("file1.yaml", "file2.yaml");

        assertEquals(result, answerStylish);
    }

    @Test
    public void testPlainFormat() throws Exception {
        String result = Differ.generate("src/main/resources/fixtures/file1.yml",
                "src/main/resources/fixtures/file2.yml", "plain");

        assertEquals(result, answerPlain);
    }

    @Test
    public void testJsonFormat() throws Exception {
        String result = Differ.generate("src/main/resources/fixtures/file1.json",
                "src/main/resources/fixtures/file2.json", "json");

        assertEquals(result, answerJson);
    }
}
