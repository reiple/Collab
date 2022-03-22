package collab;

import java.util.ArrayList;
import java.util.List;
import main.java.collab.Employee;

public abstract class AbstractColumn {
  protected String value;
  public AbstractColumn(String value){ this.value = value; }
  public String getValue(){ return value; }
  abstract public List<Employee> getFilteredList(ArrayList<Employee> employeeData);
}
