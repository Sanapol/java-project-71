package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    public void test1() throws Exception {
        var result = Differ.generate("file1", "file2", "json");
        var answer = Files.readString(Paths.get("src/test/resources/fixtures/answer")).trim();

        System.out.println(result);
        System.out.println("=======================");
        System.out.println(answer);
        assertEquals(result, answer);
    }

    @Test
    public void test2() throws Exception {
        var result = Differ.generate("src/main/resources/fixtures/file1.json", "src/main/resources/fixtures/file2.json");
        var answer = Files.readString(Paths.get("src/test/resources/fixtures/answer")).trim();

        System.out.println(result);
        System.out.println("=======================");
        System.out.println(answer);
        assertEquals(result, answer);
    }
}
