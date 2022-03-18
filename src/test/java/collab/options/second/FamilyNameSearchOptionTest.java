package collab.options.second;

import collab.options.Columns;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class FamilyNameSearchOptionTest {


  private ArrayList<String> list;

  @BeforeEach
  void setup() {
    list = mock(ArrayList.class);
    when(list.get(0)).thenReturn("DN WD");
    when(list.get(1)).thenReturn("SBILHUT LDEXRI");
    when(list.get(2)).thenReturn("HH LTUPF");
    when(list.get(3)).thenReturn("VCUHLE HMU");
    when(list.get(4)).thenReturn("RTAH VNUP");
    when(list.get(5)).thenReturn("BMU MPOSXU");
    when(list.get(6)).thenReturn("WN XV");
    when(list.get(7)).thenReturn("KBU MHU");
    when(list.get(8)).thenReturn("QKAHCEX LTODDO");
    when(list.get(9)).thenReturn("TKOQKIS HC");
    when(list.get(10)).thenReturn("LFIS JJIVL");
    when(list.get(11)).thenReturn("RPO JK");
    when(list.get(12)).thenReturn("VXIHXOTH JHOP");
    when(list.get(13)).thenReturn("VSID TVO");
    when(list.get(14)).thenReturn("FB NTAWR");
    when(list.get(15)).thenReturn("TTETHU HBO");
    when(list.get(16)).thenReturn("TWU QSOLT");
    when(list.get(17)).thenReturn("SRERLALH HMEF");
    when(list.get(18)).thenReturn("FBAH RTIJ");
    when(list.get(19)).thenReturn("NQ LVARW");

    when(list.size()).thenReturn(20);


  }

  @Test
  void 성명의_성_검색_옵션_테스트() {

    FamilyNameSearchOption familyNameSearchOption = new FamilyNameSearchOption(Columns.COLUMN_NAME, "LDEXRI");
    familyNameSearchOption.setDao(list);

    List<String> filteredList = familyNameSearchOption.getFilterList();

    assertEquals(1, filteredList.size());
    assertEquals("SBILHUT LDEXRI", filteredList.get(0));
  }

  @Test
  void 성명의_성_검색_실패_옵션_테스트() {
    FamilyNameSearchOption familyNameSearchOption = new FamilyNameSearchOption(Columns.COLUMN_NAME, "TESTER");
    familyNameSearchOption.setDao(list);

    List<String> filteredList = familyNameSearchOption.getFilterList();

    assertEquals(0, filteredList.size());
  }
}
