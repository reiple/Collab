package collab;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length !=2) {
            System.out.println("Usage: java -jar Collab.jar input.txt output.txt");
            return;
        }
        String inFilePath = args[0];

        String outFilePath = args[1];

        try {
            EmployeeManager employeeManager = new EmployeeManager();
            List<String> commandStringList = employeeManager.loadCommandStringListFromFile(inFilePath);

            List<ICommand> commandList = employeeManager.parseCommandList(commandStringList);

            String executionResult = employeeManager.executeCommandList(commandList);

            employeeManager.saveExecutionResultToFile(outFilePath, executionResult);
        }catch(Exception e){
            System.err.println("Error occurred!!!");
            System.out.println(e);
        }
    }
}
