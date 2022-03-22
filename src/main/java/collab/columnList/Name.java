package collab.columnList;

import collab.AbstractColumn;
import collab.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Name extends AbstractColumn {
    public Name(String value){
        super(value);
    }
    
    @Override
    public List<Employee> getFilteredList(ArrayList<Employee> employeeData) {
      List<Employee> resultItem = new ArrayList<Employee>();
      resultItem.addAll(employeeData.stream()
          .filter(item -> item.getName().equals(getValue()))
          .collect(Collectors.toList()));
      return resultItem;
    }
}