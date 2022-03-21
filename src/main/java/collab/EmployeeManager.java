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

    public List<String> getCommandStringListFromFile(String FilePath){
        return null;
    }

    public List<String> parseCommandList(List<String> cmdStrList){
        return null;
    }

    public String executeCommandList(List<String> cmdStrList){
        return null;
    }

    public String saveExecutionResultToFile(String FilePath){
        return null;
    }
}

