package collab;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.collab.DataBase;
import main.java.collab.Employee;

class ModifyTest {
  
  DataBase empDB = new DataBase();
    @BeforeEach
    public void setUp() {
      empDB.addEmployee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV"));
      empDB.addEmployee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      empDB.addEmployee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV"));
    }
    
    @Test
    public void modifyTest_returnEmployee() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.updateEmployee("", "employeeNum", "17112609", "name", "TEST TEST").get(0);

      assertEquals(foundEmployee.getEmployeeNumber(), targetEmployee.getEmployeeNumber());
      assertEquals(foundEmployee.getName(), targetEmployee.getName());
    }
    
    @Test
    public void modifyTest_Name() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      
      // name 변경 Test
      empDB.updateEmployee("", "employeeNum", "17112609", "name", "TEST TEST");

      assertTrue(empDB.searchEmployee("","name","FB NTAWR").size()==0);
      assertTrue(empDB.searchEmployee("-f","name","FB").size()==0);
      assertTrue(empDB.searchEmployee("-l","name","NTAWR").size()==0);
      
      assertTrue(empDB.searchEmployee("","name","TEST TEST").size()==1);
      assertTrue(empDB.searchEmployee("-f","name","TEST").size()==1);
      assertTrue(empDB.searchEmployee("-l","name","TEST").size()==1);
    }
    
    @Test
    public void modifyTest_Cl() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      
      // cl 변경 Test
      empDB.updateEmployee("", "employeeNum", "17112609", "cl", "CL5");
      
      assertTrue(empDB.searchEmployee("","cl","CL4").size()==0);
      
      assertTrue(empDB.searchEmployee("","cl","CL5").size()==1);
    }
    
    @Test
    public void modifyTest_PhoneNum() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      
      // phoneNum 변경 Test
      empDB.updateEmployee("", "employeeNum", "17112609", "phoneNum", "010-0000-0000");
            
      assertTrue(empDB.searchEmployee("","phoneNum","010-5645-6122").size()==0);
      assertTrue(empDB.searchEmployee("-m","phoneNum","5645").size()==0);
      assertTrue(empDB.searchEmployee("-l","phoneNum","6122").size()==0);
      
      assertTrue(empDB.searchEmployee("","phoneNum","010-0000-0000").size()==1);
      assertTrue(empDB.searchEmployee("-m","phoneNum","0000").size()==1);
      assertTrue(empDB.searchEmployee("-l","phoneNum","0000").size()==1);
    }
    
    @Test
    public void modifyTest_Birthday() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      
      // birthday 변경 Test
      empDB.updateEmployee("", "employeeNum", "17112609", "birthday", "19001101");
            
      assertTrue(empDB.searchEmployee("","birthday","19860903").size()==0);
      assertTrue(empDB.searchEmployee("-y","birthday","1986").size()==0);
      assertTrue(empDB.searchEmployee("-m","birthday","09").size()==0);
      assertTrue(empDB.searchEmployee("-d","birthday","03").size()==0);
      
      assertTrue(empDB.searchEmployee("","birthday","19001101").size()==1);
      assertTrue(empDB.searchEmployee("-y","birthday","1900").size()==1);
      assertTrue(empDB.searchEmployee("-m","birthday","11").size()==1);
      assertTrue(empDB.searchEmployee("-d","birthday","01").size()==1);
    }    
    
    @Test
    public void modifyTest_certi() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      
      // certi 변경 Test
      empDB.updateEmployee("", "employeeNum", "17112609", "certi", "EX");
      
      assertTrue(empDB.searchEmployee("","certi","PRO").size()==0);
      
      assertTrue(empDB.searchEmployee("","certi","EX").size()==1);
    }
}

