package collab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchTest {
  DataBase empDB = new DataBase();
  @BeforeEach
  public void setUp() {
    empDB.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
    empDB.add(new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO")));
    empDB.add(new Employee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV")));
  }
  
  public int searchTest_EmployeeNum(Employee answer) {
    List<Employee> empList;
    int resultCount=0;
    empList = empDB.searchItems("employeeNum", answer.getEmployeeNumber());
    if(empList.size()==1) {
      resultCount++;
      assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    }
    return resultCount;// 0 or 1
  }
  
  public int searchTest_Name(Employee answer) {
    List<Employee> empList;
    int resultCount=0;

    empList = empDB.searchItems("name", answer.getName());
    if(empList.size()==1) {
      resultCount++;
      assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    }

    return resultCount;
    
  }    

  public int searchTest_Cl(Employee answer) {
    List<Employee> empList;
    int resultCount=0;
    empList = empDB.searchItems("cl", answer.getCareerLevel());
    if(empList.size()==1) {
      resultCount++;
      assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    }

    return resultCount;// 0 or 1
  }

  public int searchTest_PhoneNum(Employee answer) {
    List<Employee> empList;
    int resultCount=0;
    
    empList = empDB.searchItems("phoneNum", answer.getPhoneNumber());
    if(empList.size()==1) {
      resultCount++;
      assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    }
    return resultCount;// 0 or 3
  }

  public int searchTest_BirthDay(Employee answer) {
    List<Employee> empList;
    int resultCount=0;
    
    empList = empDB.searchItems("birthday", answer.getBirthday());
    if(empList.size()==1) {
      resultCount++;
      assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    }
    return resultCount;// 0 or 4
  }
  
  public int searchTest_Certi(Employee answer) {
    List<Employee> empList;
    int resultCount=0;
    empList = empDB.searchItems("certi", answer.getCerti());
    if(empList.size()==1) {
      resultCount++;
      assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
    }
    return resultCount;// 0 or 1
  }
  
  public int searchTest_Total(Employee answer) {
    return searchTest_EmployeeNum(answer)+
    searchTest_Name(answer)+
    searchTest_Cl(answer)+
    searchTest_PhoneNum(answer)+
    searchTest_BirthDay(answer)+
    searchTest_Certi(answer);
  }
  
  @Test
  public void searchTestFound() {
    Employee answer = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
    assertTrue(searchTest_Total(answer)==6);
  }
  
  @Test
  public void searchTestNotFound() {
    assertThrows(RuntimeException.class, () -> {
      Employee noAnswer = new Employee(Arrays.asList("19000000","TEST TEST","CL5","010-0000-0000","19000101","TEST"));
      assertTrue(searchTest_Total(noAnswer)==0);
    });

  }
}

