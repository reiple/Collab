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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeManagerTest {
    private List<String> commandStringList1 ;
    private static final String employeeManagerSaveFileTestFilePath = "src/test/resources/EmployeeManagerSaveFileTest.txt";
    private static final String employeeManagerFileToFileTestFilePath = "src/test/resources/EmployeeManagerFileToFileTest.txt";
    private List<String> commandInitStringList;
    private EmployeeManager tempEmployeeManager;


    @BeforeEach
    public void initStringList() throws Exception{
        commandStringList1 = Arrays.asList(
                "ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO",
                "SCH,-p,-d, ,birthday,04",
                "MOD,-p, , ,name,TWU QSOLT,cl,CL3",
                "DEL,-p,-l, ,name,QSOLT"
        );

        commandInitStringList = new ArrayList<>();
        commandInitStringList.add("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        commandInitStringList.add("ADD, , , ,17112609,FB NTAWR,CL4,010-5645-6122,19861203,PRO");
        commandInitStringList.add("ADD, , , ,18115040,TTETHU HBO,CL3,010-4581-2050,20080718,ADV");
        commandInitStringList.add("ADD, , , ,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO");
        commandInitStringList.add("ADD, , , ,19129568,SRERLALH HMEF,CL2,010-3091-9521,19640910,PRO");
        commandInitStringList.add("ADD, , , ,17111236,VSID TVO,CL1,010-3669-1077,20120718,PRO");
        commandInitStringList.add("ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO");
        commandInitStringList.add("ADD, , , ,08123556,WN XV,CL1,010-7986-5047,20100614,PRO");
        commandInitStringList.add("ADD, , , ,02117175,SBILHUT LDEXRI,CL4,010-2814-1699,19950704,ADV");
        commandInitStringList.add("ADD, , , ,03113260,HH LTUPF,CL2,010-5798-5383,19791018,PRO");
        commandInitStringList.add("ADD, , , ,14130827,RPO JK,CL4,010-3231-1698,20090201,ADV");
        commandInitStringList.add("ADD, , , ,01122329,DN WD,CL4,010-7174-5680,20071117,PRO");
        commandInitStringList.add("ADD, , , ,08108827,RTAH VNUP,CL4,010-9031-2726,19780417,ADV");
        commandInitStringList.add("ADD, , , ,85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV");
        commandInitStringList.add("ADD, , , ,08117441,BMU MPOSXU,CL3,010-2703-3153,20010215,ADV");
        commandInitStringList.add("ADD, , , ,10127115,KBU MHU,CL3,010-3284-4054,19660814,ADV");
        commandInitStringList.add("ADD, , , ,12117017,LFIS JJIVL,CL1,010-7914-4067,20120812,PRO");
        commandInitStringList.add("ADD, , , ,11125777,TKOQKIS HC,CL1,010-6734-2289,19991001,PRO");
        commandInitStringList.add("ADD, , , ,11109136,QKAHCEX LTODDO,CL4,010-2627-8566,19640130,PRO");
        commandInitStringList.add("ADD, , , ,05101762,VCUHLE HMU,CL4,010-3988-9289,20030819,PRO");
        commandInitStringList.add("SCH,-p,-d, ,birthday,04");
        commandInitStringList.add("MOD,-p, , ,name,FB NTAWR,birthday,20050520");
        commandInitStringList.add("SCH, , , ,employeeNum,79110836");
        commandInitStringList.add("DEL, , , ,employeeNum,18115040");
        commandInitStringList.add("DEL,-p,-l, ,name,MPOSXU");
        commandInitStringList.add("SCH,-p, , ,certi,PRO");
        commandInitStringList.add("SCH, , , ,certi,ADV");
        commandInitStringList.add("SCH,-p, , ,cl,CL4");
        commandInitStringList.add("SCH, ,-m, ,birthday,09");
        commandInitStringList.add("MOD,-p, , ,name,FB NTAWR,cl,CL3");
        commandInitStringList.add("MOD,-p, , ,employeeNum,08123556,birthday,20110706");
        commandInitStringList.add("SCH,-p,-y, ,birthday,2003");
        commandInitStringList.add("SCH,-p, , ,employeeNum,05101762");
        commandInitStringList.add("SCH,-p,-m, ,phoneNum,3112");
        commandInitStringList.add("SCH,-p,-l, ,phoneNum,4605");
        commandInitStringList.add("SCH,-p, , ,employeeNum,10127115");
        commandInitStringList.add("MOD,-p, , ,phoneNum,010-8900-1478,certi,PRO");
        commandInitStringList.add("SCH, ,-f, ,name,LDEXRI");
        commandInitStringList.add("MOD, , , ,name,VCUHLE HMU,birthday,19910808");
        commandInitStringList.add("SCH, , , ,name,FB NTAWR");

        tempEmployeeManager = mock(EmployeeManager.class);
        when(tempEmployeeManager.loadCommandStringListFromFile(anyString())).thenReturn(commandInitStringList);
    }

    @Test
    public void commandParseTest() throws Exception{
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
    public void executeCommandTest() throws Exception{
        EmployeeManager employeeManager = new EmployeeManager();
        List<ICommand> commandList = employeeManager.parseCommandList(commandStringList1);
        String executionResult = employeeManager.executeCommandList(commandList);
        assertEquals(executionResult, "SCH,NONE" + System.lineSeparator() +
                "MOD,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO" + System.lineSeparator() +
                "DEL,18117906,TWU QSOLT,CL3,010-6672-7186,20030413,PRO"  + System.lineSeparator());

        String[] resultLines = executionResult.split(System.lineSeparator());
        assertTrue(resultLines.length == 3);
        assertEquals("SCH,NONE", resultLines[0].trim());
        assertEquals("MOD,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO", resultLines[1].trim());
        assertEquals("DEL,18117906,TWU QSOLT,CL3,010-6672-7186,20030413,PRO", resultLines[2].trim());
    }

    @Test
    void saveResultToFileTest() throws Exception {
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

        String[] resultLines = executionResult.split(System.lineSeparator());
        assertTrue(resultLines.length == contents.size());
        for (int i = 0 ; i < resultLines.length; i++){
            assertEquals(resultLines[i], contents.get(i));
        }
    }

    @Test
    void loadCommandListFromFileTest() throws Exception {
        String filePath = "src/test/resources/input_20_20.txt";
        assertTrue(new File(filePath).exists());
        EmployeeManager employeeManager = new EmployeeManager();

        List<String> commandStringList = employeeManager.loadCommandStringListFromFile(filePath);
        assertTrue(commandStringList.size() == 40);
        commandStringList.get(0).equals("ADD, , , ,15123099,VXIHXOTH JHOP,CL3,010-3112-2609,19771211,ADV");
        commandStringList.get(39).equals("SCH, , , ,name,FB NTAWR");
    }


    @Test
    void employeeManagerFileToFileTest() throws Exception {
        String inFilePath = "src/test/resources/input_20_20.txt";
        String outFilePath = "src/test/resources/output_20_20.txt";

        assertTrue(new File(inFilePath).exists());
        assertTrue(!new File(employeeManagerFileToFileTestFilePath).exists());

        EmployeeManager employeeManager = new EmployeeManager();

        List<String> commandStringList = employeeManager.loadCommandStringListFromFile(inFilePath);
        List<ICommand> commandList = employeeManager.parseCommandList(commandStringList);
        String executionResult = employeeManager.executeCommandList(commandList);

        String stringAnswers = new String(Files.readAllBytes(Paths.get(outFilePath)), StandardCharsets.UTF_8);
        assertEquals(stringAnswers, executionResult);
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

        for (int i = 0 ; i < answers.size(); i++){
            assertEquals(answers.get(i), testOutput.get(i));
            //System.out.println(testOutput.get(i));
        }
        assertEquals(answers.size(), testOutput.size());

        String stringOurs = new String(Files.readAllBytes(Paths.get(employeeManagerFileToFileTestFilePath)), StandardCharsets.UTF_8);
        assertEquals(stringAnswers, stringOurs);
    }

    @AfterAll
    static void clearTestedFiles() throws Exception{
        File employeeManagerSaveFileTestFile = new File(employeeManagerSaveFileTestFilePath);
        if (employeeManagerSaveFileTestFile.exists()) employeeManagerSaveFileTestFile.delete();

        File employeeManagerFileToFileTestFile = new File(employeeManagerFileToFileTestFilePath);
        if (employeeManagerFileToFileTestFile.exists()) employeeManagerFileToFileTestFile.delete();
    }

}
