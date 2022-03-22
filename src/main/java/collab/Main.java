package collab;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        if (args.length !=2) {
            System.out.println("Usage: Main.exe input.txt output.txt");
        }
        String inFilePath = args[0];
        //System.out.println("in: " + inFilePath);
        String outFilePath = args[1];
        //System.out.println("out: " + outFilePath);
        try {
            EmployeeManager employeeManager = new EmployeeManager();
            List<String> commandStringList = employeeManager.loadCommandStringListFromFile(inFilePath);
            //System.out.println("cmdStrList: " + commandStringList);
            List<ICommand> commandList = employeeManager.parseCommandList(commandStringList);
            //System.out.println("cmdList: " + commandList);
            String executionResult = employeeManager.executeCommandList(commandList);
            //System.out.println("exeResult: " + executionResult);
            employeeManager.saveExecutionResultToFile(outFilePath, executionResult);
        }catch(Exception e){
            System.err.println("Error occurred!!!");
            System.out.println(e);
        }
    }
}
