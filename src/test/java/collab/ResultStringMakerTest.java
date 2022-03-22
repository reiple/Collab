package collab;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ResultStringMakerTest {


  @Test
  void testMakeResultString() {
    String[][] data = {
        {"88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"}
    };

    String result = ResultStringMaker.makeResultString("SCH", data);

    assertEquals("SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO", result);

  }

  @Test
  void testMakeResultStringMultiple() {
    String[][] data = {
        {"88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"},
        {"85125741", "FBAH RTIJ", "CL1", "010-8900-1478", "19780228", "ADV"}
    };

    String result = ResultStringMaker.makeResultString("SCH", data);

    assertEquals(
        "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO"
            + System.lineSeparator()
            + "SCH,85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV"
        , result);
  }

}
