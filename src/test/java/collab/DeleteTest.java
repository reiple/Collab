package collab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteTest {
  
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
    public void delTest_DeletedData() {
      Employee answer = new Employee("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO");
      Employee deletedEmployee;
      
      // 삭제 전 Test
      assertTrue(searchTest_Total(answer)==13);

      // 삭제
      deletedEmployee = empDB.deleteEmployee("", "certi", "PRO").get(0);
      // 삭제 결과 비교
      assertTrue(deletedEmployee.getBirthday().equals(answer.getBirthday()));
      assertTrue(deletedEmployee.getCareerLevel().equals(answer.getCareerLevel()));
      assertTrue(deletedEmployee.getName().equals(answer.getName()));
      assertTrue(deletedEmployee.getEmployeeNumber().equals(answer.getEmployeeNumber()));
      assertTrue(deletedEmployee.getPhoneNumber().equals(answer.getPhoneNumber()));
      assertTrue(deletedEmployee.getCerti().equals(answer.getCerti()));
    }
      
    @Test
    public void delTest_NoResult() {
      Employee answer = new Employee("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO");
      
      // 삭제 전 조회 가능
      assertTrue(searchTest_Total(answer)==13);
      // 삭제
      empDB.deleteEmployee("", "certi", "PRO").get(0);
      // 삭제 후 조회 불가
      assertTrue(searchTest_Total(answer)==0);
    }
}

