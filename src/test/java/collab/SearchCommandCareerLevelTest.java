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

public class SearchCommandCareerLevelTest {

  private EmployeeDAO employeeDAO;

  @BeforeEach
  void setup() {

    employeeDAO = mock(EmployeeDAO.class);
    List<Employee> list = new ArrayList<>();

    String[][] data = {
        {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"},
        {"99117175", "FIRST LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"},
        {"03113260", "FIRST LTUPF", "CL2", "010-5798-5383", "19791018", "PRO"},
    };

    for(String[] employeeData: data) {
      Employee employee = new Employee(Arrays.asList(employeeData));
      list.add(employee);

    }
    when(employeeDAO.getAllItems()).thenReturn(list);

  }

  @Test
  void testSearchCareerLevelFail() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new EmptySecondOption(Arrays.asList("cl", "CL1")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("0", result);

  }

  @Test
  void testSearchCareerLevelSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new NoneFirstOption(), new EmptySecondOption(Arrays.asList("cl", "CL4")));

    String[][] data = {
        {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"},
        {"99117175", "FIRST LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"}
    };

    String result = command.executeCommand(employeeDAO);
    assertEquals("2", result);

  }

  @Test
  void testSearchCareerLevelAndPrintFail() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new EmptySecondOption(Arrays.asList("cl", "CL1")));

    String result = command.executeCommand(employeeDAO);
    assertEquals("NONE", result);

  }

  @Test
  void testSearchCareerLevelAndPrintSuccess() throws Exception {
    ICommand command = new SearchCommand(
        new PrintOption(), new EmptySecondOption(Arrays.asList("cl", "CL4")));

    String[][] data = {
        {"99117175", "FIRST LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"},
        {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"}
    };

    String result = command.executeCommand(employeeDAO);
    assertEquals(ResultStringMaker.makeResultString("SCH", data), result);

  }



}
