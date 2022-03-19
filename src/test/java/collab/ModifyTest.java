package DataBase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModifyTest {
  
  DataBase empDB = new DataBase();
    @BeforeEach
    public void setUp() {
      empDB.addEmployee(new Employee("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV"));
      empDB.addEmployee(new Employee("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      empDB.addEmployee(new Employee("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV"));
    }

    public int searchTest_EmployeeNum(Employee answer) {
      ArrayList<Employee> empList;
      int resultCount=0;
      empList = empDB.searchEmployee("", "employeeNum", answer.getEmployeeNumber());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      return resultCount;// 0 or 1
    }
    
    public int searchTest_Name(Employee answer) {
      ArrayList<Employee> empList;
      int resultCount=0;
      empList = empDB.searchEmployee("-l", "name", answer.getLastName());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      
      empList = empDB.searchEmployee("-f", "name", answer.getFirstName());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      
      empList = empDB.searchEmployee("", "name", answer.getName());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }

      return resultCount;// 0 or 3
      
    }    

    public int searchTest_Cl(Employee answer) {
      ArrayList<Employee> empList;
      int resultCount=0;
      empList = empDB.searchEmployee("", "cl", answer.getCareerLevel());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }

      return resultCount;// 0 or 1
    }

    public int searchTest_PhoneNum(Employee answer) {
      ArrayList<Employee> empList;
      int resultCount=0;
      empList = empDB.searchEmployee("-m", "phoneNum", answer.getMiddlePhoneNumber());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      
      empList = empDB.searchEmployee("-l", "phoneNum", answer.getLastPhoneNumber());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      
      empList = empDB.searchEmployee("", "phoneNum", answer.getPhoneNumber());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      return resultCount;// 0 or 3
    }

    public int searchTest_BirthDay(Employee answer) {
      ArrayList<Employee> empList;
      int resultCount=0;
      empList = empDB.searchEmployee("-y", "birthday", answer.getBirthYearOnly());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      
      empList = empDB.searchEmployee("-m", "birthday", answer.getBirthMonthOnly());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      
      empList = empDB.searchEmployee("-d", "birthday", answer.getBirthDayOnly());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      
      empList = empDB.searchEmployee("", "birthday", answer.getBirthday());
      if(empList.size()==1) {
        resultCount++;
        assertEquals(empList.get(0).getEmployeeNumber(), answer.getEmployeeNumber());
      }
      return resultCount;// 0 or 4
    }
    
    public int searchTest_Certi(Employee answer) {
      ArrayList<Employee> empList;
      int resultCount=0;
      empList = empDB.searchEmployee("", "certi", answer.getCerti());
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
    public void modiTest_VerifyResult() {
      Employee beforeAnswer = new Employee("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO");
      Employee afterAnswer= new Employee(beforeAnswer.getEmployeeNumber(), beforeAnswer.getName(), beforeAnswer.getCareerLevel(), beforeAnswer.getPhoneNumber(), beforeAnswer.getBirthday(), beforeAnswer.getCerti());
      Employee result;
      
      // 변경 전 Test
      assertTrue(searchTest_Total(beforeAnswer)==13);

      // 변경 Test
      String AfterName = "TEST TEST";
      afterAnswer.setName(AfterName);
      result = empDB.updateEmployee("", "certi", "PRO", "name", AfterName).get(0);
      
      // 동일한 결과
      assertTrue(result.getBirthday().equals(beforeAnswer.getBirthday()));
      assertTrue(result.getCareerLevel().equals(beforeAnswer.getCareerLevel()));
      assertTrue(result.getName().equals(beforeAnswer.getName()));
      assertTrue(result.getEmployeeNumber().equals(beforeAnswer.getEmployeeNumber()));
      assertTrue(result.getPhoneNumber().equals(beforeAnswer.getPhoneNumber()));
      assertTrue(result.getCerti().equals(beforeAnswer.getCerti()));
    }

    @Test
    public void modiTest_FoundResult() {
      Employee beforeAnswer = new Employee("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO");
      Employee afterAnswer= new Employee(beforeAnswer.getEmployeeNumber(), beforeAnswer.getName(), beforeAnswer.getCareerLevel(), beforeAnswer.getPhoneNumber(), beforeAnswer.getBirthday(), beforeAnswer.getCerti());
      
      // 변경 전 Test
      searchTest_Total(beforeAnswer);

      // 변경 Test
      String AfterName = "TEST TEST";
      empDB.updateEmployee("", "certi", "PRO", "name", AfterName).get(0);
      
      // 조회 가능 : 조회 가능
      afterAnswer.setName(AfterName);
      assertTrue(searchTest_Total(afterAnswer)==13);
    }
    
    @Test
    public void modiTest_NoFoundResult() {
      Employee beforeAnswer = new Employee("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO");
      
      // 변경 전 Test
//      searchTest_Total(beforeAnswer);

      // 변경 Test
      String AfterName = "TEST TEST";
      empDB.updateEmployee("", "certi", "PRO", "name", AfterName).get(0);
      
      // 조회 불가능
      assertTrue(searchTest_Total(beforeAnswer)==10); // 13-3(이름 조회 되는 경우)
    }
    
}


