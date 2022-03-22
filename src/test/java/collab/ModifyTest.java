package collab;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModifyTest {
  
  DataBase empDB = new DataBase();
    @BeforeEach
    public void setUp() {
      empDB.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
      empDB.add(new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO")));
      empDB.add(new Employee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV")));
    }
    
    @Test
    public void modifyTest_returnCheck() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.modifyItemByCondition("employeeNum", "17112609", "name", "TEST TEST").get(0);

      assertEquals(foundEmployee.getEmployeeNumber(), targetEmployee.getEmployeeNumber());
      assertEquals(foundEmployee.getName(), targetEmployee.getName());
    }
    
    @Test
    public void modifyTest_Name() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition("employeeNum", "17112609", "name", "TEST TEST");

      assertNull(empDB.searchItems("name","FB NTAWR"));
      assertTrue(empDB.searchItems("name","TEST TEST").get(0).getEmployeeNumber() == "17112609");
    }
    
    @Test
    public void modifyTest_Cl() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
        empDB.modifyItemByCondition("employeeNum", "17112609", "cl", "CL1");

        assertNull(empDB.searchItems("cl","CL4"));
        assertTrue(empDB.searchItems("cl","CL1").get(0).getEmployeeNumber() == "17112609");
      
    }
    
    @Test
    public void modifyTest_PhoneNum() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition("employeeNum", "17112609", "phoneNum", "010-0000-0000");

      assertNull(empDB.searchItems("phoneNum","010-5645-6122"));
      assertTrue(empDB.searchItems("phoneNum","010-0000-0000").get(0).getEmployeeNumber() == "17112609");
    }
    
    @Test
    public void modifyTest_Birthday() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition("employeeNum", "17112609", "birthday", "19001101");

      assertNull(empDB.searchItems("birthday","19860903"));
      assertTrue(empDB.searchItems("birthday","19001101").get(0).getEmployeeNumber() == "17112609");
    }    
    
    @Test
    public void modifyTest_certi() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition("employeeNum", "17112609", "certi", "EX");
      
      assertNull(empDB.searchItems("certi","PRO"));
      assertTrue(empDB.searchItems("certi","EX").get(0).getEmployeeNumber() == "17112609");
    }
}


