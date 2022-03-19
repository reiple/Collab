package collab;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class DataBase {
    ArrayList<Employee> empList = new ArrayList<>();
    
    public void addEmployee(Employee employee) {
      empList.add(employee);        
    }
    
    public ArrayList<Employee> searchEmployee(String searchOption, String searchColumn, String searchData) {    
      ArrayList<Employee> result = new ArrayList<>();
      result.addAll(empList.stream().filter(employee -> isFound(employee, searchOption, searchColumn, searchData))
                   .collect(Collectors.toList()));
      return result;
    }

    private boolean isFound(Employee employee, String searchOption, String searchColumn, String searchData) {
      switch(searchColumn) {
        case "employeeNum": return isFoundEmployeeNum(employee, searchData);
        case "name": return isFoundName(employee, searchOption, searchData);
        case "cl": return isFoundCarrarLevel(employee, searchOption, searchData);
        case "phoneNum": return isFoundPhoneNumber(employee, searchOption, searchData);
        case "birthday": return isFoundBirthday(employee, searchOption, searchData);
        case "certi": return isFoundCerti(employee, searchOption, searchData);
      }
      return false;
    }

    private boolean isFoundEmployeeNum(Employee employee, String searchData) {
        return employee.getEmployeeNumber().equals(searchData);
    }

    private boolean isFoundName(Employee employee, String searchOption, String searchData) {
      switch(searchOption) {
        case "-f": return employee.getFirstName().equals(searchData);
        case "-l": return employee.getLastName().equals(searchData);
        case "" : return employee.getName().equals(searchData);
      }
      return false;
    }
    
    private boolean isFoundCarrarLevel(Employee employee, String searchOption, String searchData) {
      return employee.getCareerLevel().equals(searchData);
    }
    
    private boolean isFoundPhoneNumber(Employee employee, String searchOption, String searchData) {
      switch(searchOption) {
        case "-m" : return employee.getMiddlePhoneNumber().equals(searchData);
        case "-l" : return employee.getLastPhoneNumber().equals(searchData);
        case "" : return employee.getPhoneNumber().equals(searchData);
      }
      return false;
    }
    
    private boolean isFoundCerti(Employee employee, String searchOption, String searchData) {
      return employee.getCerti().equals(searchData);
    }
    
    private boolean isFoundBirthday(Employee employee, String searchOption, String searchData) {
      switch(searchOption) {
        case "-y" : return employee.getBirthYearOnly().equals(searchData); 
        case "-m" : return employee.getBirthMonthOnly().equals(searchData);
        case "-d" : return employee.getBirthDayOnly().equals(searchData); 
        case "" : return employee.getBirthday().equals(searchData);
      }
      return false;
    }
    
    public ArrayList<Employee> updateEmployee(String option, String searchColumn, String searchData, String changeColumn, String changeData) {
        ArrayList<Employee> targetEmployee = searchEmployee(option, searchColumn, searchData);
        ArrayList<Employee> returnEmployee = new ArrayList<Employee>();

        for(Employee employee : targetEmployee) {
          returnEmployee.add(new Employee(employee.getEmployeeNumber(),employee.getName(), employee.getCareerLevel(), employee.getPhoneNumber(), employee.getBirthday(), employee.getCerti()));
          switch(changeColumn) {
              case "eployeeNum": employee.setEmployeeNumber(changeData); break;
              case "name": employee.setName(changeData); break;
              case "cl": employee.setCareerLevel(changeData); break;
              case "phoneNum": employee.setPhoneNumber(changeData); break;
              case "birthday": employee.setBirthday(changeData); break;
              case "certi": employee.setCerti(changeData); break;
          }          
        }
        return returnEmployee;
    }
    
    public ArrayList<Employee> deleteEmployee(String searchOption, String searchColumn, String searchData) {
        ArrayList<Employee> targetEmployee = searchEmployee(searchOption, searchColumn, searchData);
        ArrayList<Employee> returnEmployee = new ArrayList<Employee>();
        for(Employee employee : targetEmployee) {
          returnEmployee.add(new Employee(employee.getEmployeeNumber(),employee.getName(), employee.getCareerLevel(), employee.getPhoneNumber(), employee.getBirthday(), employee.getCerti()));
          empList.remove(employee);
        }
        return returnEmployee;
    }
}
