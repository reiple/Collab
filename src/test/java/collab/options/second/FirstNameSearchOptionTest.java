package collab.options.second;

import collab.Employee;
import collab.EmployeeDAO;
import collab.options.Columns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FirstNameSearchOptionTest {


  private ArrayList<Employee> list;
  private EmployeeDAO employeeDAO;

  @BeforeEach
  void setup() throws Exception {
    //list = mock(ArrayList.class);
    //employeeDAO = mock(EmployeeDAO.class);
    employeeDAO = new EmployeeDAO();
    employeeDAO.initDatabase();

//    String[] data = {
//        "DN WD",
//        "SBILHUT LDEXRI",
//        "HH LTUPF",
//        "VCUHLE HMU",
//        "RTAH VNUP",
//        "BMU MPOSXU",
//        "WN XV",
//        "KBU MHU",
//        "QKAHCEX LTODDO",
//        "TKOQKIS HC",
//        "LFIS JJIVL",
//        "RPO JK",
//        "VXIHXOTH JHOP",
//        "VSID TVO",
//        "FB NTAWR",
//        "TTETHU HBO",
//        "TWU QSOLT",
//        "SRERLALH HMEF",
//        "FBAH RTIJ",
//        "NQ LVARW"
//    };
//
//    for(int index = 0; index < data.length; index++) {
//      Employee employee = new Employee(Arrays.asList("00000000", data[index], "CL1", "010-0000-0000", "19000101", "ADV"));
//      employee.setName(data[index]);
//      when(list.get(index)).thenReturn(employee);
//    }
//
//    when(list.size()).thenReturn(20);

    String[][] data2 = {
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
        {"88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"}
    };

    //List<Employee> dataList = new ArrayList<>();
    for(String[] employeeData: data2) {
//      Employee employee = new Employee(Arrays.asList(employeeData));
//      dataList.add(employee);
      employeeDAO.addItemFromStringTokens(Arrays.asList(employeeData));

    }
    //when(employeeDAO.getAllItems()).thenReturn(dataList);

  }

  @Test
  void 성명의_이름_검색_옵션_테스트() {

    FirstNameOption firstNameSearchOption = new FirstNameOption(Arrays.asList(Columns.COLUMN_NAME, "SBILHUT"));

    List<Employee> filteredList = firstNameSearchOption.getFilteredList(employeeDAO);

    assertEquals(1, filteredList.size());
    assertEquals("SBILHUT LDEXRI", filteredList.get(0).getName());
  }

  @Test
  void 성명의_이름_검색_실패_옵션_테스트() {
    FirstNameOption firstNameSearchOption = new FirstNameOption(Arrays.asList(Columns.COLUMN_NAME, "TESTER"));

    List<Employee> filteredList = firstNameSearchOption.getFilteredList(employeeDAO);

    assertEquals(0, filteredList.size());
  }
}
