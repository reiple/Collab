package collab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import main.java.collab.Employee;

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

  public ArrayList<Employee> searchItems(String field, String value) {    
    ArrayList<Employee> result = new ArrayList<>();
    result.addAll(employeeData.stream().filter(employee -> isFound(employee, field, value))
                 .collect(Collectors.toList()));
    return result;
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
    switch(field) {
      case "eployeeNum": employee.setBirthday(value); break;
      case "name": employee.setName(value); break;
      case "cl": employee.setCareerLevel(value); break;
      case "phoneNum": employee.setPhoneNumber(value); break;
      case "birthday": employee.setBirthday(value); break;
      case "certi": employee.setCerti(value); break;
    }
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
      returnEmployee.add(new Employee(Arrays.asList(employee.getEmployeeNumber(),employee.getName(), employee.getCareerLevel(), employee.getPhoneNumber(), employee.getBirthday(), employee.getCerti())));
      employeeData.remove(employee);
    }
    return returnEmployee;
  }
   
  
  private Employee makeEmployee(Employee employeeInfo) {
    return new Employee(Arrays.asList(employeeInfo.getEmployeeNumber(), employeeInfo.getName(), employeeInfo.getCareerLevel(), employeeInfo.getPhoneNumber(), employeeInfo.getBirthday(), employeeInfo.getCerti()));
  }    
  
  private boolean isFound(Employee employee, String searchColumn, String searchData) {
    switch(searchColumn) {
      case "employeeNum": return isFoundEmployeeNum(employee, searchData);
      case "name": return isFoundName(employee, searchData);
      case "cl": return isFoundCarrarLevel(employee, searchData);
      case "phoneNum": return isFoundPhoneNumber(employee, searchData);
      case "birthday": return isFoundBirthday(employee, searchData);
      case "certi": return isFoundCerti(employee, searchData);
    }
    return false;
  }  
  
  private boolean isFoundEmployeeNum(Employee employee, String searchData) {
      return employee.getEmployeeNumber().equals(searchData);
  }

  private boolean isFoundName(Employee employee, String searchData) {
      return employee.getName().equals(searchData);
  }
  
  private boolean isFoundCarrarLevel(Employee employee, String searchData) {
    return employee.getCareerLevel().equals(searchData);
  }
  
  private boolean isFoundPhoneNumber(Employee employee, String searchData) {
    return employee.getPhoneNumber().equals(searchData);
  }
  private boolean isFoundCerti(Employee employee, String searchData) {
    return employee.getCerti().equals(searchData);
  }
  
  private boolean isFoundBirthday(Employee employee, String searchData) {
    return employee.getBirthday().equals(searchData);
  }
}