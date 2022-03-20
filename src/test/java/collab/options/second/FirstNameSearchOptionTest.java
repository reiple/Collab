package collab.options.second;

import collab.Employee;
import collab.options.Columns;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FirstNameSearchOptionTest {


  private ArrayList<Employee> list;

  @BeforeEach
  void setup() {
    list = mock(ArrayList.class);

    String[] data = {
        "DN WD",
        "SBILHUT LDEXRI",
        "HH LTUPF",
        "VCUHLE HMU",
        "RTAH VNUP",
        "BMU MPOSXU",
        "WN XV",
        "KBU MHU",
        "QKAHCEX LTODDO",
        "TKOQKIS HC",
        "LFIS JJIVL",
        "RPO JK",
        "VXIHXOTH JHOP",
        "VSID TVO",
        "FB NTAWR",
        "TTETHU HBO",
        "TWU QSOLT",
        "SRERLALH HMEF",
        "FBAH RTIJ",
        "NQ LVARW"
    };

    for(int index = 0; index < data.length; index++) {
      Employee employee = new Employee(Arrays.asList("00000000", data[index], "CL1", "010-0000-0000", "000101", "ADV"));
      employee.setName(data[index]);
      when(list.get(index)).thenReturn(employee);
    }

    when(list.size()).thenReturn(20);


  }

  @Test
  void 성명의_이름_검색_옵션_테스트() {

    FirstNameSearchOption firstNameSearchOption = new FirstNameSearchOption(Columns.COLUMN_NAME, "SBILHUT");
    firstNameSearchOption.setDao(list);

    ArrayList<Employee> filteredList = firstNameSearchOption.getFilterList();

    assertEquals(1, filteredList.size());
    assertEquals("SBILHUT LDEXRI", filteredList.get(0).getName());
  }

  @Test
  void 성명의_이름_검색_실패_옵션_테스트() {
    FirstNameSearchOption firstNameSearchOption = new FirstNameSearchOption(Columns.COLUMN_NAME, "TESTER");
    firstNameSearchOption.setDao(list);

    ArrayList<Employee> filteredList = firstNameSearchOption.getFilterList();

    assertEquals(0, filteredList.size());
  }
}
