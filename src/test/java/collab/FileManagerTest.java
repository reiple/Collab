package collab;

import collab.FileManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {
    private static final String saveFilePassTestFilePath = "src/test/resources/saveFilePassTestPath.txt";
    @Test
    public void loadFilePassTest() throws IOException {
        String filePath = "src/test/resources/input_20_20.txt";
        FileManager fileManager = new FileManager();
        List<String> contents = fileManager.loadFile(filePath);
        assertTrue(contents.size() == 40);
        contents.get(0).equals("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        contents.get(39).equals("SCH, , , ,name,FB NTAWR");
    }

    @Test
    public void loadFileFailTest(){
        String filePath = "src/test/resources/input_20_202.txt";
        assertTrue(!new File(filePath).exists());
        FileManager fileManager = new FileManager();
        Throwable exception = assertThrows(IOException.class, () -> {
            List<String> contents = fileManager.loadFile(filePath);
        });
    }

    @Test
    public void saveFilePassTest() throws IOException {
        String filePath = "src/test/resources/input_20_20.txt";
        FileManager fileManager = new FileManager();
        List<String> answers = fileManager.loadFile(filePath);

        assertTrue(!new File(saveFilePassTestFilePath).exists());
        fileManager.saveFile(saveFilePassTestFilePath, answers.stream().collect(Collectors.joining("\n")));

        assertTrue(new File(saveFilePassTestFilePath).exists());
        ArrayList<String> testOutput = new ArrayList<String>();
        BufferedReader testBr = new BufferedReader(new FileReader(saveFilePassTestFilePath));
        String testStr;
        while ((testStr = testBr.readLine()) != null) {
            testOutput.add(testStr);
        }
        testBr.close();
        assertTrue(answers.size() == testOutput.size());
        for (int i = 0 ; i < answers.size(); i++){
            assertEquals(answers.get(i), testOutput.get(i));
        }
    }

    @AfterAll
    static public void clearTestFile(){
        File saveFilePassTestFile = new File(saveFilePassTestFilePath);
        if (saveFilePassTestFile.exists()) saveFilePassTestFile.delete();
    }
}
