package ex46;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReadInputFileTest {
    private ReadInputFile readInputFile;
    private Scanner scanner;
    private File file;
    private HashMap<String,Integer> hMap;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        readInputFile = new ReadInputFile();
        file = new File("src/main/resources/exercise46_input.txt");
        scanner = new Scanner(file);
        hMap = new HashMap<String,Integer>();
    }

    @AfterEach
    void tearDown() {
        readInputFile = null;
    }

    @Test
    void testInputFileAbsolutePath() {
        String inputFile = "exercise46_input.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("exercise46_input.txt").getFile());

        String absolutePath = file.getAbsolutePath();
        System.out.println("abs = " + absolutePath);
        assertTrue(file.exists());
        assertTrue(absolutePath.endsWith("exercise46_input.txt"));
    }

    @Test
    void testReadAsStream() {
        String inputFile = "/exercise46_input.txt";
        InputStream stream = this.getClass().getResourceAsStream(inputFile);
        assertNotNull(stream);
    }

    @Test
    void testReadFile() {
        HashMap<String, Integer> map = readInputFile.readFile();
        var firstVal = map.keySet().iterator().next();
        var snakeCt = map.get("snake");
        var badgerCt = map.get("badger");
        var mushroomCt = map.get("mushroom");

        assertEquals(3, map.size());
        assertEquals("snake", firstVal);
        assertEquals(1, snakeCt);
        assertEquals(7, badgerCt);
        assertEquals(2, mushroomCt);
    }
}
