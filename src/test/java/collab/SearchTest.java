package collab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchTest {
  
  DataBase empDB = new DataBase();
  Employee answer;
  Employee noAnswer;
  
  @BeforeEach
  public void setUp() {
    empDB.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
    empDB.add(new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO")));
    empDB.add(new Employee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV")));
    
    answer = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
    noAnswer = new Employee(Arrays.asList("19010101","TEST TEST","CL2","010-0000-0000","19000101","EX"));
  }
  
  @Test
  public void searchTestFound() {
    searchTest_EmployeeNum(true,answer);
    searchTest_Name(true,answer);
    searchTest_Cl(true,answer);
    searchTest_PhoneNum(true,answer);
    searchTest_BirthDay(true,answer);
    searchTest_Certi(true,answer);
  }
  
  @Test
  public void searchTestNotFound() {
    searchTest_EmployeeNum(false,noAnswer);
    searchTest_Name(false,noAnswer);
    searchTest_Cl(false,noAnswer);
    searchTest_PhoneNum(false,noAnswer);
    searchTest_BirthDay(false,noAnswer);
    searchTest_Certi(false,noAnswer);
  }
  
  public void searchTest_EmployeeNum(boolean isMatch, Employee answer) {
    List<Employee> foundList = empDB.searchItems("employeeNum", answer.getEmployeeNumber());

    if(isMatch) assertEquals(foundList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    if(!isMatch) assertEquals(foundList.size(),0);
  }   
  
  public void searchTest_Name(boolean isMatch, Employee answer) {
    List<Employee> foundList = empDB.searchItems("name", answer.getName());

    if(isMatch) assertEquals(foundList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    if(!isMatch) assertEquals(foundList.size(),0);
  }    

  public void searchTest_Cl(boolean isMatch, Employee answer) {
    List<Employee> foundList = empDB.searchItems("cl", answer.getCareerLevel());

    if(isMatch) assertEquals(foundList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    if(!isMatch) assertEquals(foundList.size(),0);
  }

  public void searchTest_PhoneNum(boolean isMatch, Employee answer) {
    List<Employee> foundList = empDB.searchItems("phoneNum", answer.getPhoneNumber());

    if(isMatch) assertEquals(foundList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    if(!isMatch) assertEquals(foundList.size(),0);
  }

  public void searchTest_BirthDay(boolean isMatch, Employee answer) {
    List<Employee> foundList = empDB.searchItems("birthday", answer.getBirthday());

    if(isMatch) assertEquals(foundList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    if(!isMatch) assertEquals(foundList.size(),0);
  }
  
  public void searchTest_Certi(boolean isMatch, Employee answer) {
    List<Employee> foundList = empDB.searchItems("certi", answer.getCerti());

    if(isMatch) assertEquals(foundList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    if(!isMatch) assertEquals(foundList.size(),0);
  }
}
