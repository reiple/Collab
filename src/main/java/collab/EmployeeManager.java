package collab;

public class EmployeeManager  {
    private IDAO dao;
    public EmployeeManager(){
        this.dao = new EmployeeDAO();
    }
}
