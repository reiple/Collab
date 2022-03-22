package collab;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModifyByIDTest {
  
  DataBase empDB = new DataBase();
    @BeforeEach
    void setUp() {
      empDB.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
      empDB.add(new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO")));
      empDB.add(new Employee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV")));
    }
    
    @Test
    void modifyTest_returnCheck_Name() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.modifyItemById("17112609", "name", "TEST TEST");

      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.getEmployeeNumber());
      assertEquals(targetEmployee.getName(), foundEmployee.getName());
      assertTrue(empDB.searchItems("name", "FB NTAWR").isEmpty());
      assertTrue(!empDB.searchItems("name", "TEST TEST").isEmpty());
    }
    
    @Test
    void modifyTest_returnCheck_Cl() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.modifyItemById("17112609", "cl", "CL2");
      
      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.getEmployeeNumber());
      assertEquals(targetEmployee.getCareerLevel(), foundEmployee.getCareerLevel());
      assertTrue(empDB.searchItems("cl", "CL4").isEmpty());
      assertTrue(!empDB.searchItems("cl", "CL2").isEmpty());
    }
    
    @Test
    void modifyTest_returnCheck_PhoneNum() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.modifyItemById("17112609", "phoneNum", "010-5645-0000");

      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.getEmployeeNumber());
      assertEquals(targetEmployee.getPhoneNumber(), foundEmployee.getPhoneNumber());
      assertTrue(empDB.searchItems("phoneNum", "010-5645-6122").isEmpty());
      assertTrue(!empDB.searchItems("phoneNum", "010-5645-0000").isEmpty());
    }
    
    @Test
    void modifyTest_returnCheck_Birthday() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.modifyItemById("17112609", "birthday", "19870903");
      
      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.getEmployeeNumber());
      assertEquals(targetEmployee.getBirthday(), foundEmployee.getBirthday());
      assertTrue(empDB.searchItems("birthday", "19860903").isEmpty());
      assertTrue(!empDB.searchItems("birthday", "19870903").isEmpty());
    }
    
    @Test
    void modifyTest_returnCheck_Certi() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.modifyItemById("17112609", "certi", "EX");
      
      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.getEmployeeNumber());
      assertEquals(targetEmployee.getCerti(), foundEmployee.getCerti());
      assertTrue(empDB.searchItems("certi", "PRO").isEmpty());
      assertTrue(!empDB.searchItems("certi", "EX").isEmpty());
    }
}
