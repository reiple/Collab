package collab;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import collab.options.first.NoneFirstOption;
import collab.options.first.PrintOption;
import collab.options.second.EmptySecondOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchCommandCertiTest {

  private EmployeeDAO employeeDAO;
  private String[][] data = {
      {"99117175", "FIRST LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"},
      {"08108827", "FIRST VNUP", "CL4", "010-9031-2726", "19780417", "ADV"},
      {"08117441", "FIRST MPOSXU", "CL3", "010-2703-3153", "20010215", "ADV"},
      {"10127115", "KBU MHU", "CL3", "010-3284-4054", "19660814", "ADV"},
      {"18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"},
      {"18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO"},
      {"19129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO"},
      {"85125741", "FBAH RTIJ", "CL1", "010-8900-1478", "19780228", "ADV"}
  };

  void setup() {

    employeeDAO = mock(EmployeeDAO.class);
    List<Employee> list = new ArrayList<>();

    for (String[] employeeData : data) {
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
  void testSearchCertiFail() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new EmptySecondOption(Arrays.asList("certi", "EX")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("SCH,NONE", result);

  }

  @Test
  void testSearchCertiSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new EmptySecondOption(Arrays.asList("certi", "ADV")));

    String[][] data = {
        {"85125741", "FBAH RTIJ", "CL1", "010-8900-1478", "19780228", "ADV"},
        {"99117175", "FIRST LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"},
        {"08108827", "FIRST VNUP", "CL4", "010-9031-2726", "19780417", "ADV"},
        {"08117441", "FIRST MPOSXU", "CL3", "010-2703-3153", "20010215", "ADV"},
        {"10127115", "KBU MHU", "CL3", "010-3284-4054", "19660814", "ADV"},
        // MAX 5
        {"18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"}
    };

    String result = command.executeCommand(employeeDAO);
    assertEquals("SCH," + data.length, result);

  }

  @Test
  void testSearchCertiAndPrintFail() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new EmptySecondOption(Arrays.asList("certi", "EX")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("SCH,NONE", result);

  }

  @Test
  void testSearchCertiAndPrintSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new EmptySecondOption(Arrays.asList("certi", "ADV")));

    String[][] data = {
        {"85125741", "FBAH RTIJ", "CL1", "010-8900-1478", "19780228", "ADV"},
        {"99117175", "FIRST LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"},
        {"08108827", "FIRST VNUP", "CL4", "010-9031-2726", "19780417", "ADV"},
        {"08117441", "FIRST MPOSXU", "CL3", "010-2703-3153", "20010215", "ADV"},
        {"10127115", "KBU MHU", "CL3", "010-3284-4054", "19660814", "ADV"},
        // MAX 5
        //{"18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV"}
    };

    String result = command.executeCommand(employeeDAO);

    assertEquals(ResultStringMaker.makeResultString("SCH", data), result);

  }
}
