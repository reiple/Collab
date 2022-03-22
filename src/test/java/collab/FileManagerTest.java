package collab;

import collab.FileManager;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileManagerTest {
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

}
