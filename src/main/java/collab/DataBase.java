package collab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import collab.Employee;

public class DataBase {
  private ArrayList<Employee> employeeData = new ArrayList<Employee>();
  
  public ArrayList<Employee> getEmployeeAllData() {
    return employeeData;
  }
  
  public void add(Employee employee) {
    employeeData.add(employee);        
  }

  public Employee searchItem(String id) {
    return searchItems("employeeNum", id).get(0);
  }

  public List<Employee> searchItems(String field, String value) {
      List<Employee> resultItem = new ArrayList<Employee>();
      resultItem.addAll(employeeData.stream()
              .filter(item -> item.getField(field).equals(value))
              .collect(Collectors.toList()));
      return resultItem;
  }
  
  public Employee modifyItem(Employee employee) {
    Employee foundItem = searchItems("employeeNum", employee.getEmployeeNumber()).get(0);
    Employee returnItem = makeEmployee(foundItem);
    foundItem = employee;
    
    return returnItem;
  }
  
  public Employee modifyItemById(String id, String field, String value) {
    Employee foundItem = modifyItemByCondition("employeeNum", id, field, value).get(0);
    return foundItem;
  }
  
  public List<Employee> modifyItemByCondition(String sField, String sValue, String cField, String cValue) {
    List<Employee> returnItem = new ArrayList<Employee>();
    
    List<Employee> foundItem = searchItems(sField, sValue);
    for(Employee employee : foundItem) {
      returnItem.add(makeEmployee(employee));
      modify(employee, cField, cValue);
    }
    
    return returnItem;
  }
  
  public void modify(Employee employee, String field, String value) {
    employee.setField(field, value);
  }
  
  
  public Employee deleteItem(Employee item) {
    return deleteItemById(item.getEmployeeNumber());
  }

  public Employee deleteItemById(String id) {
    return deleteItemByCondition("employeeNum", id).get(0);
  }
  
  public List<Employee> deleteItemByCondition(String field, String value) {
    List<Employee> returnEmployee = new ArrayList<Employee>();
    
    List<Employee> targetEmployee = searchItems(field, value);
    for(Employee employee : targetEmployee) {
      returnEmployee.add(makeEmployee(employee));
      employeeData.remove(employee);
    }
    return returnEmployee;
  }
   
  
  private Employee makeEmployee(Employee employeeInfo) {
    return new Employee(Arrays.asList(employeeInfo.getEmployeeNumber(), employeeInfo.getName(), employeeInfo.getCareerLevel(), employeeInfo.getPhoneNumber(), employeeInfo.getBirthday(), employeeInfo.getCerti()));
  }
}