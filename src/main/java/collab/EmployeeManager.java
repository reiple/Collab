package collab;

import java.util.List;

public class EmployeeManager  {
    private IDAO dao;
    private CommandParser parser;
    public EmployeeManager(){
        this.dao = new EmployeeDAO();
        dao.initDatabase();
        parser = new CommandParser();
    }

    public List<String> getCommandStringListFromFile(String filePath){
        return null;
    }

    public List<ICommand> parseCommandList(List<String> commandStrList){
        return null;
    }

    public String executeCommandList(List<ICommand> commandList){
        return null;
    }

    public String saveExecutionResultToFile(String filePath, String excutionResult){
        return null;
    }
}

