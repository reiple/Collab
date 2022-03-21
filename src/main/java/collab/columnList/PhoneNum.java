package collab.columnList;

import collab.AbstractColumn;
import collab.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneNum extends AbstractColumn {
    public PhoneNum(String value){
        super(value);
    }
    
    @Override
    public List<Employee> getFilteredList(ArrayList<Employee> employeeData) {
      List<Employee> resultItem = new ArrayList<Employee>();
      resultItem.addAll(employeeData.stream()
          .filter(item -> item.getPhoneNumber().equals(getValue()))
          .collect(Collectors.toList()));
      return resultItem;
    }
}