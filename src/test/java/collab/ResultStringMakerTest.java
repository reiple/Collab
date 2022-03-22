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

    // TODO: 리턴에 명령어 포함일 경우, 이 부분 수정해야 함
    //assertEquals("SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO", result);
    assertEquals("88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO", result);

  }

  @Test
  void testMakeResultStringMultiple() {
    String[][] data = {
        {"88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO"},
        {"85125741", "FBAH RTIJ", "CL1", "010-8900-1478", "19780228", "ADV"}
    };

    String result = ResultStringMaker.makeResultString("SCH", data);
//    assertEquals(
//        "SCH,88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO"
//            + System.lineSeparator()
//            + "SCH,85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV"
//        , result);

    // TODO: 개행문자 변경 시, 이 부분 수정해야 함
    // TODO: 리턴에 명령어 포함일 경우, 이 부분 수정해야 함
    assertEquals(
        "88114052,NQ LVARW,CL4,010-4528-3059,19911021,PRO"
            + "\n"
            + "85125741,FBAH RTIJ,CL1,010-8900-1478,19780228,ADV"
        , result);
  }

}
