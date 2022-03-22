package collab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {
  HashSet<String> registerEmployeeNum = new HashSet<String>();
  public ArrayList<Employee> employeeData = new ArrayList<Employee>();
  
  public ArrayList<Employee> getEmployeeAllData() {
    return employeeData;
  }
  
  public void add(Employee employee) {
    if(registerEmployeeNum.contains(employee.getEmployeeNumber())) {
      System.out.println(employee.getEmployeeNumber() + "Register Fail!! Employee Data Duplicated!!");
      return;
    }
    registerEmployeeNum.add(employee.getEmployeeNumber());
    employeeData.add(employee);
  }
  
  
  public Employee searchItem(String id) {
    List<Employee> foundItems = searchItems("employeeNum", id); 
    if(foundItems == null) return null;
    return foundItems.get(0);
  }

  public List<Employee> searchItems(String field, String value) {
      List<Employee> resultItem = new ArrayList<Employee>();
      resultItem.addAll(employeeData.stream()
              .filter(item -> item.getField(field).equals(value))
              .collect(Collectors.toList()));
      if(resultItem.size()==0) {
        System.out.println("(field:"+field +" value : "+value+ ") can't find!!");
        return null;
      }
      return resultItem;
  }
  
  public Employee modifyItem(Employee employee) {
    Employee foundItem = searchItem(employee.getEmployeeNumber());
    if(foundItem == null) return null;
    return makeEmployee(foundItem);
  }
  
  public Employee modifyItemById(String id, String field, String value) {
    List<Employee> foundItems = modifyItemByCondition("employeeNum", id, field, value);
    if(foundItems == null) return null;
    return foundItems.get(0);
  }
  
  public List<Employee> modifyItemByCondition(String sField, String sValue, String cField, String cValue) {
    List<Employee> foundItems = searchItems(sField, sValue);
    if(foundItems==null) return null;
    
    List<Employee> returnItems = new ArrayList<Employee>();
    for(Employee employee : foundItems) {
      returnItems.add(makeEmployee(employee));
      modify(employee, cField, cValue);
    }
    
    return returnItems;
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
    List<Employee> foundItems = searchItems(field, value);
    if(foundItems==null) return null;
    
    List<Employee> returnItems = new ArrayList<Employee>();
    for(Employee employee : foundItems) {
      returnItems.add(makeEmployee(employee));
      registerEmployeeNum.remove(employee.getEmployeeNumber());
      employeeData.remove(employee);
    }
    
    return returnItems;
  }
   
  
  private Employee makeEmployee(Employee employeeInfo) {
    return new Employee(Arrays.asList(employeeInfo.getEmployeeNumber(), employeeInfo.getName(), employeeInfo.getCareerLevel(), employeeInfo.getPhoneNumber(), employeeInfo.getBirthday(), employeeInfo.getCerti()));
  }
}