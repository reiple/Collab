package collab;

public class ResultStringMaker {

  public static String makeResultString(String command, String[][] data) {

    // TODO: 리턴에 명령어 포함일 경우, 이 부분 수정해야 함
    boolean needCommand = false;
    boolean needLastNewLine = false;
    boolean useSystemNewLine = false;

    StringBuilder builder = new StringBuilder();
    for(int next = 0; next < data.length; next++) {
      String[] employeeData = data[next];

      if(needCommand) {
        builder.append(command);
        builder.append(",");
      }

      for (int index = 0; index < employeeData.length; index++) {
        builder.append(employeeData[index]);
        if (index == employeeData.length - 1) {
          break;
        }
        builder.append(",");
      }

      if(!needLastNewLine) {
        if(next == data.length - 1) {
          break;
        }
      }

      if(useSystemNewLine) {
        builder.append(System.lineSeparator());
      } else {
        builder.append("\n");
      }


    }

    return builder.toString();
  }

}
