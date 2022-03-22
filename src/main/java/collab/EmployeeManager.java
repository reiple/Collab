package collab;

import java.util.List;

public class EmployeeManager  {
    private IDAO dao;
    private CommandParser parser;
    public EmployeeManager(){
        this.dao = new EmployeeDAO();
        this.dao.initDatabase();
        this.parser = new CommandParser();
    }

    public List<String> loadCommandStringListFromFile(String filePath){
        //FileManager 구현 필요
        return null;
    }

    public List<ICommand> parseCommandList(List<String> commandStrList) throws Exception{
        return this.parser.parseToCommandList(commandStrList);
    }

    public String executeCommandList(List<ICommand> commandList) throws Exception{
        String executionResult = "";
        for (ICommand command : commandList){
            executionResult += command.executeCommand(this.dao);
        }
        return executionResult;
    }

    public String saveExecutionResultToFile(String filePath, String executionResult){
        //FileManager 구현 필요
        return null;
    }
}

