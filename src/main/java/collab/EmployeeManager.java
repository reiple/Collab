package collab;

import java.util.List;

public class EmployeeManager  {
    private IDAO dao;
    private CommandParser parser;
    private FileManager fileManager;
    public EmployeeManager(){
        this.dao = new EmployeeDAO();
        this.dao.initDatabase();
        this.parser = new CommandParser();
        this.fileManager = new FileManager();
    }

    public List<String> loadCommandStringListFromFile(String filePath) throws Exception{
        //FileManager 구현 필요
        return this.fileManager.loadFile(filePath);
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

    public void saveExecutionResultToFile(String filePath, String executionResult) throws Exception{
        //FileManager 구현 필요
        this.fileManager.saveFile(filePath, executionResult);
    }
}

