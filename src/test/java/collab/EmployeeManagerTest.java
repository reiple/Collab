package collab;

import collab.options.first.NoneFirstOption;
import collab.options.first.PrintOption;
import collab.options.second.DayOfBirthdayOption;
import collab.options.second.EmptySecondOption;
import collab.options.second.LastNameOption;
import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeManagerTest {
    private List<String> commandStringList1 ;
    private static final String employeeManagerSaveFileTestFilePath = "src/test/resources/EmployeeManagerSaveFileTest.txt";
    private static final String employeeManagerFileToFileTestFilePath = "src/test/resources/EmployeeManagerFileToFileTest.txt";
    @BeforeEach
    public void initStringList(){
        commandStringList1 = Arrays.asList(
                "ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO",
                "SCH,-p,-d, ,birthday,04",
                "MOD,-p, , ,name,TWU QSOLT,cl,CL3",
                "DEL,-p,-l, ,name,QSOLT"
        );
    }

    @Test
    public void commandParseTest() {
        EmployeeManager employeeManager = new EmployeeManager();
        List<ICommand> commandList = employeeManager.parseCommandList(commandStringList1);
        assertTrue(commandList.size() == 4);
        assertTrue(commandList.get(0) instanceof AddCommand);
        assertTrue(((AddCommand) commandList.get(0)).getFirstOption() instanceof NoneFirstOption);
        assertTrue(((AddCommand) commandList.get(0)).getSecondOption() instanceof NoneSecondOption);
        assertTrue(((AddCommand) commandList.get(0)).getThirdOption() instanceof NoneThirdOption);

        assertTrue(commandList.get(1) instanceof SearchCommand);
        assertTrue(((SearchCommand) commandList.get(1)).getFirstOption() instanceof PrintOption);
        assertTrue(((SearchCommand) commandList.get(1)).getSecondOption() instanceof DayOfBirthdayOption);
        assertTrue(((SearchCommand) commandList.get(1)).getThirdOption() instanceof NoneThirdOption);

        assertTrue(commandList.get(2) instanceof ModifyCommand);
        assertTrue(((ModifyCommand) commandList.get(2)).getFirstOption() instanceof PrintOption);
        assertTrue(((ModifyCommand) commandList.get(2)).getSecondOption() instanceof EmptySecondOption);
        assertTrue(((ModifyCommand) commandList.get(2)).getThirdOption() instanceof NoneThirdOption);

        assertTrue(commandList.get(3) instanceof DeleteCommand);
        assertTrue(((DeleteCommand) commandList.get(3)).getFirstOption() instanceof PrintOption);
        assertTrue(((DeleteCommand) commandList.get(3)).getSecondOption() instanceof LastNameOption);
        assertTrue(((DeleteCommand) commandList.get(3)).getThirdOption() instanceof NoneThirdOption);
    }

    @Test
    public void executeCommandTest() {
        EmployeeManager employeeManager = new EmployeeManager();
        List<ICommand> commandList = employeeManager.parseCommandList(commandStringList1);
        String executionResult = employeeManager.executeCommandList(commandList);
        String[] resultLines = executionResult.split("\n");
        assertTrue(resultLines.length == 3);
        resultLines[0].equals("SCH,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        resultLines[1].equals("MOD,18117906,TWU QSOLT,CL3,010-6672-7186,20030413,PRO");
        resultLines[2].equals("DEL,18117906,TWU QSOLT,CL3,010-6672-7186,20030413,PRO");
    }

    @Test
    void saveResultToFileTest() throws IOException {
        assertTrue(!new File(employeeManagerSaveFileTestFilePath).exists());
        EmployeeManager employeeManager = new EmployeeManager();
        List<ICommand> commandList = employeeManager.parseCommandList(commandStringList1);
        String executionResult = employeeManager.executeCommandList(commandList);
        employeeManager.saveExecutionResultToFile(employeeManagerSaveFileTestFilePath, executionResult);

        assertTrue(new File(employeeManagerSaveFileTestFilePath).exists());
        ArrayList<String> contents = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(employeeManagerSaveFileTestFilePath));
        String str;
        while ((str = br.readLine()) != null) {
            contents.add(str);
        }
        br.close();
        String[] resultLines = executionResult.split("\n");
        assertTrue(resultLines.length == contents.size());
        for (int i = 0 ; i < resultLines.length; i++){
            assertEquals(resultLines[i], contents.get(i));
        }
    }

    @Test
    void loadCommandListFromFileTest() throws IOException {
        String filePath = "src/test/resources/input_20_20.txt";
        assertTrue(new File(filePath).exists());
        EmployeeManager employeeManager = new EmployeeManager();
        List<String> commandStringList = employeeManager.loadCommandStringListFromFile(filePath);
        assertTrue(commandStringList.size() == 40);
        commandStringList.get(0).equals("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        commandStringList.get(39).equals("SCH, , , ,name,FB NTAWR");
    }
    @Test
    void employeeManagerFileToFileTest() throws IOException {
        String inFilePath = "src/test/resources/input_20_20.txt";
        String outFilePath = "src/test/resources/output_20_20.txt";

        assertTrue(new File(inFilePath).exists());
        assertTrue(!new File(employeeManagerFileToFileTestFilePath).exists());

        EmployeeManager employeeManager = new EmployeeManager();
        List<String> commandStringList = employeeManager.loadCommandStringListFromFile(inFilePath);
        List<ICommand> commandList = employeeManager.parseCommandList(commandStringList);
        String executionResult = employeeManager.executeCommandList(commandList);
        employeeManager.saveExecutionResultToFile(employeeManagerFileToFileTestFilePath, executionResult);

        assertTrue(new File(outFilePath).exists());
        ArrayList<String> answers = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(outFilePath));
        String str;
        while ((str = br.readLine()) != null) {
            answers.add(str);
        }
        br.close();

        assertTrue(new File(employeeManagerFileToFileTestFilePath).exists());
        ArrayList<String> testOutput = new ArrayList<String>();
        BufferedReader testBr = new BufferedReader(new FileReader(employeeManagerFileToFileTestFilePath));
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
    static void clearTestedFiles() throws IOException{
        File employeeManagerSaveFileTestFile = new File(employeeManagerSaveFileTestFilePath);
        if (employeeManagerSaveFileTestFile.exists()) employeeManagerSaveFileTestFile.delete();

        File employeeManagerFileToFileTestFile = new File(employeeManagerFileToFileTestFilePath);
        if (employeeManagerFileToFileTestFile.exists()) employeeManagerFileToFileTestFile.delete();
    }

}
