package collab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DataBase {

    HashSet<String> registerEmployeeNum = new HashSet<String>();
    private ArrayList<Employee> employeeData = new ArrayList<Employee>();

    public ArrayList<Employee> getEmployeeAllData() {
        return employeeData;
    }

    public void add(Employee employee) {
        if (registerEmployeeNum.contains(employee.getEmployeeNumber())) {
            System.out.println(
                employee.getEmployeeNumber() + "Register Fail!! Employee Data Duplicate!!");
            return;
        }
        registerEmployeeNum.add(employee.getEmployeeNumber());
        employeeData.add(employee);
    }


    public Employee searchItem(String id) {
        List<Employee> foundItems = searchItems("employeeNum", id);
      if (foundItems.isEmpty()) {
        return null;
      }
        return foundItems.get(0);
    }

    public List<Employee> searchItems(String field, String value) {
        return employeeData.stream()
            .filter(item -> item.getField(field).equals(value))
            .collect(Collectors.toList());
    }

    public Employee modifyItem(Employee employee) {
        Employee foundItem = searchItem(employee.getEmployeeNumber());
      if (foundItem == null) {
        return null;
      }

        Employee returnItem = makeEmployee(foundItem);
        copyEmployee(employee, foundItem);
        return returnItem;
    }

    public Employee modifyItemById(String id, String field, String value) {
        List<Employee> foundItems = modifyItemByCondition("employeeNum", id, field, value);
      if (foundItems.isEmpty()) {
        return null;
      }
        return foundItems.get(0);
    }

    public List<Employee> modifyItemByCondition(String sField, String sValue, String cField,
        String cValue) {
        List<Employee> foundItems = searchItems(sField, sValue);

        List<Employee> returnItems = new ArrayList<Employee>();
        for (Employee employee : foundItems) {
            returnItems.add(makeEmployee(employee));
            employee.setField(cField, cValue);
        }

        return returnItems;
    }

    public Employee deleteItem(Employee item) {
        return deleteItemById(item.getEmployeeNumber());
    }

    public Employee deleteItemById(String id) {
        List<Employee> foundItems = deleteItemByCondition("employeeNum", id);
      if (foundItems.isEmpty()) {
        return null;
      }
        return foundItems.get(0);
    }

    public List<Employee> deleteItemByCondition(String field, String value) {
        List<Employee> foundItems = searchItems(field, value);

        List<Employee> returnItems = new ArrayList<Employee>();
        for (Employee employee : foundItems) {
            returnItems.add(makeEmployee(employee));
            registerEmployeeNum.remove(employee.getEmployeeNumber());
            employeeData.remove(employee);
        }

        return returnItems;
    }


    private Employee makeEmployee(Employee employeeInfo) {
        return new Employee(Arrays.asList(employeeInfo.getEmployeeNumber(), employeeInfo.getName(),
            employeeInfo.getCareerLevel(), employeeInfo.getPhoneNumber(),
            employeeInfo.getBirthday(), employeeInfo.getCerti()));
    }

    private void copyEmployee(Employee source, Employee target) {
        target.setName(source.getName());
        target.setCareerLevel(source.getCareerLevel());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setBirthday(source.getBirthday());
        target.setCerti(source.getCerti());
    }
}
