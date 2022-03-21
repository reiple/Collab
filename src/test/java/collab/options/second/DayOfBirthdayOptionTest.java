package collab.options.second;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import collab.Employee;
import collab.EmployeeDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;

class DayOfBirthdayOptionTest {

  private EmployeeDAO employeeDAO;

  @BeforeEach
  void setup() {

    employeeDAO = mock(EmployeeDAO.class);
    List<Employee> list = new ArrayList<>();

    String[][] data = {
        {"01122329", "DN WD", "CL4", "010-7174-5680", "20071117", "PRO"},
        {"02117175", "SBILHUT LDEXRI", "CL4", "010-2814-1699", "19950704", "ADV"},
        {"03113260", "HH LTUPF", "CL2", "010-5798-5383", "19791018", "PRO"},
        {"05101762", "VCUHLE HMU", "CL4", "010-3988-9289", "20030819", "PRO"},
        {"08108827", "RTAH VNUP", "CL4", "010-9031-2726", "19780417", "ADV"},
        {"08117441", "BMU MPOSXU", "CL3", "010-2703-3153", "20010215", "ADV"},
        {"08123556", "WN XV", "CL1", "010-7986-5047", "20100614", "PRO"},
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
        {"88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"},
        {"88114053", "CODE TESTER", "CL3", "010-4528-1478", "19911021", "ADV"}
    };

    for(String[] employeeData: data) {
      Employee employee = new Employee(Arrays.asList(employeeData));
      list.add(employee);

    }
    when(employeeDAO.getAll()).thenReturn(list);

  }

  @Test
  void testDayOfBirthDayOptionFail() {

    DayOfBirthdayOption dayOfBirthdayOption = new DayOfBirthdayOption(Arrays.asList("birthday", "02"));
    List<Employee> filteredList = dayOfBirthdayOption.getFilteredList(employeeDAO);
    assertEquals(0, filteredList.size());

  }

  @Test
  void testDayOfBirthDayOptionSuccess() {

    DayOfBirthdayOption dayOfBirthdayOption = new DayOfBirthdayOption(Arrays.asList("birthday", "21"));
    List<Employee> filteredList = dayOfBirthdayOption.getFilteredList(employeeDAO);
    assertEquals(2, filteredList.size());

    String[][] resultData = {
        {"88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"},
        {"88114053", "CODE TESTER", "CL3", "010-4528-1478", "19911021", "ADV"}
    };

    for(int index = 0; index < filteredList.size(); index++) {
      assertEquals(resultData[index][0], filteredList.get(index).getEmployeeNumber());
      assertEquals(resultData[index][1], filteredList.get(index).getName());
      assertEquals(resultData[index][2], filteredList.get(index).getCareerLevel());
      assertEquals(resultData[index][3], filteredList.get(index).getPhoneNumber());
      assertEquals(resultData[index][4], filteredList.get(index).getBirthday());
      assertEquals(resultData[index][5], filteredList.get(index).getCerti());
    }

  }

}
