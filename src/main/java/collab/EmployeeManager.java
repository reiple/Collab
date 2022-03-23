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
        return this.fileManager.loadFile(filePath);
    }

    public List<ICommand> parseCommandList(List<String> commandStrList) throws Exception{
        return this.parser.parseToCommandList(commandStrList);
    }

    public String executeCommandList(List<ICommand> commandList) throws Exception{
        String executionResult = "";
        for (ICommand command : commandList){
            String commandResult = command.executeCommand(this.dao);
            if (!commandResult.isEmpty()) executionResult += commandResult + System.lineSeparator();
        }
        return executionResult;
    }

    public void saveExecutionResultToFile(String filePath, String executionResult) throws Exception{
        this.fileManager.saveFile(filePath, executionResult);
    }
}

