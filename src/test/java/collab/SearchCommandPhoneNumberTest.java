package collab;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import collab.options.first.NoneFirstOption;
import collab.options.first.PrintOption;
import collab.options.second.EmptySecondOption;
import collab.options.second.LastPhoneNumberOption;
import collab.options.second.MiddlePhoneNumberOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchCommandPhoneNumberTest {

  private EmployeeDAO employeeDAO;
  private String[][] data = {
      {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"},
      {"99117175", "FIRST LDEXRI", "CL4", "010-7174-1699", "19950704", "ADV"},
      {"03113260", "FIRST LTUPF", "CL2", "010-5798-5383", "19791018", "PRO"},
      {"05101762", "FIRST HMU", "CL4", "010-3988-9289", "20030819", "PRO"},
      {"08108827", "FIRST VNUP", "CL4", "010-9031-2726", "19780417", "ADV"},
      {"08123556", "FIRST XV", "CL1", "010-7986-5047", "20100614", "PRO"},
      {"08117441", "FIRST MPOSXU", "CL3", "010-2703-3153", "20010215", "ADV"},
      {"10127115", "KBU MHU", "CL3", "010-3284-4054", "19660814", "ADV"},
      {"11109136", "QKAHCEX LTODDO", "CL4", "010-2627-8566", "19640130", "PRO"},
      {"11125777", "TKOQKIS HC", "CL1", "010-6734-2289", "19991001", "PRO"},
      {"12117017", "LFIS JJIVL", "CL1", "010-7914-4067", "20120812", "PRO"},
      {"14130827", "RPO JK", "CL4", "010-3231-1698", "20090201", "ADV"},
      {"15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV"},
      {"17111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO"},
      {"17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO"},
      {"18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"},
      {"18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO"},
      {"19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"},
      {"85125741", "FBAH RTIJ", "CL1", "010-8900-1478", "19780228", "ADV"},
      {"01114052", "ABCE LVARW", "CL4", "010-1528-3059", "19911021", "PRO"},
      {"89114053", "DEFRE LVARW", "CL3", "010-2528-3059", "19911021", "PRO"},
      {"69114054", "GDFQW LVARW", "CL2", "010-3528-3059", "19911021", "PRO"},
      {"88114056", "REWAA LVARW", "CL2", "010-4128-3059", "19911021", "PRO"},
      {"88114055", "QWE LVARW", "CL1", "010-4528-3059", "19911021", "PRO"},
      {"00114057", "EREBB LVARW", "CL3", "010-4228-3059", "19911021", "PRO"},
      {"00114058", "QQWE LVARW", "CL4", "010-4328-3059", "19911021", "PRO"}
  };

  void setup() {

    employeeDAO = mock(EmployeeDAO.class);
    List<Employee> list = new ArrayList<>();

    for(String[] employeeData: data) {
      Employee employee = new Employee(Arrays.asList(employeeData));
      list.add(employee);

    }
    when(employeeDAO.getAllItems()).thenReturn(list);

  }

  @BeforeEach
  void setupDAO() throws Exception {
    employeeDAO = new EmployeeDAO();
    employeeDAO.initDatabase();

    for (String[] employeeData : data) {
      employeeDAO.addItemFromStringTokens(Arrays.asList(employeeData));
    }

  }

  @Test
  void testSearchPhoneNumFail() throws Exception {

    ICommand command = new SearchCommand(
        new NoneFirstOption(), new EmptySecondOption(Arrays.asList("phoneNum", "010-0000-0000")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("0", result);

  }

  @Test
  void testSearchPhoneNumSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new EmptySecondOption(Arrays.asList("phoneNum", "010-7174-5680")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("1", result);

  }

  @Test
  void testSearchPhoneNumAndPrintFail() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new EmptySecondOption(Arrays.asList("phoneNum", "010-0000-0000")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("NONE", result);
  }

  @Test
  void testSearchPhoneNumAndPrintSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new EmptySecondOption(Arrays.asList("phoneNum", "010-7174-5680")));

    String[][] data = {
        {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"}
    };
    String result = command.executeCommand(employeeDAO);
    assertEquals(ResultStringMaker.makeResultString("SCH", data), result);
  }

  @Test
  void testSearchMiddlePhoneNumFail() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new MiddlePhoneNumberOption(Arrays.asList("phoneNum", "9777")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("0", result);
  }

  @Test
  void testSearchMiddlePhoneNumSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new MiddlePhoneNumberOption(Arrays.asList("phoneNum", "7174")));

    String[][] data = {
        {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"},
        {"99117175", "FIRST LDEXRI", "CL4", "010-7174-1699", "19950704", "ADV"}
    };
    String result = command.executeCommand(employeeDAO);
    assertEquals("2", result);
  }

  @Test
  void testSearchMiddlePhoneNumAndPrintFail() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new MiddlePhoneNumberOption(Arrays.asList("phoneNum", "9777")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("NONE", result);
  }

  @Test
  void testSearchMiddlePhoneNumAndPrintSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new MiddlePhoneNumberOption(Arrays.asList("phoneNum", "7174")));

    String[][] data = {
        {"99117175", "FIRST LDEXRI", "CL4", "010-7174-1699", "19950704", "ADV"},
        {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"}
    };
    String result = command.executeCommand(employeeDAO);
    assertEquals(ResultStringMaker.makeResultString("SCH", data), result);
  }


  @Test
  void testSearchLastPhoneNumFail() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new LastPhoneNumberOption(Arrays.asList("phoneNum", "0000")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("0", result);
  }

  @Test
  void testSearchLastPhoneNumSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new LastPhoneNumberOption(Arrays.asList("phoneNum", "3059")));

    String[][] data = {
        {"01114052", "ABCE LVARW", "CL4", "010-1528-3059", "19911021", "PRO"},
        {"89114053", "DEFRE LVARW", "CL3", "010-2528-3059", "19911021", "PRO"},
        {"69114054", "GDFQW LVARW", "CL2", "010-3528-3059", "19911021", "PRO"},
        {"88114056", "REWAA LVARW", "CL2", "010-4128-3059", "19911021", "PRO"},
        {"88114055", "QWE LVARW", "CL1", "010-4528-3059", "19911021", "PRO"},
        {"00114057", "EREBB LVARW", "CL3", "010-4228-3059", "19911021", "PRO"},
        {"00114058", "QQWE LVARW", "CL4", "010-4328-3059", "19911021", "PRO"}
    };
    String result = command.executeCommand(employeeDAO);
    assertEquals("" + data.length, result);
  }

  @Test
  void testSearchLastPhoneNumAndPrintFail() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new LastPhoneNumberOption(Arrays.asList("phoneNum", "0000")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("NONE", result);
  }

  @Test
  void testSearchLastPhoneNumAndPrintSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new LastPhoneNumberOption(Arrays.asList("phoneNum", "3059")));

    String[][] data = {
        {"69114054", "GDFQW LVARW", "CL2", "010-3528-3059", "19911021", "PRO"},
        {"88114055", "QWE LVARW", "CL1", "010-4528-3059", "19911021", "PRO"},
        {"88114056", "REWAA LVARW", "CL2", "010-4128-3059", "19911021", "PRO"},
        {"89114053", "DEFRE LVARW", "CL3", "010-2528-3059", "19911021", "PRO"},
        {"00114057", "EREBB LVARW", "CL3", "010-4228-3059", "19911021", "PRO"},
        // MAX 5
        //{"00114058", "QQWE LVARW", "CL4", "010-4328-3059", "19911021", "PRO"},
        //{"01114052", "ABCE LVARW", "CL4", "010-1528-3059", "19911021", "PRO"}
    };
    String result = command.executeCommand(employeeDAO);
    assertEquals(ResultStringMaker.makeResultString("SCH", data), result);
  }


}
