package collab;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeleteTest {
  
  DataBase empDB = new DataBase();
    @BeforeEach
    public void setUp() {
      empDB.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
      empDB.add(new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO")));
      empDB.add(new Employee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV")));
    }
      
    @Test
    public void deleteTest_deleteItem() {
      Employee deleteItem = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      empDB.deleteItem(deleteItem);
      assertTrue(empDB.deleteItemByCondition("employeeNum", "17112609").isEmpty());
    }
    
    @Test
    public void deleteTest_deleteItemById() {
      // "17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.deleteItemById("17112609");
      assertTrue(empDB.deleteItemByCondition("employeeNum", "17112609").isEmpty());
    }
    
    @Test
    public void deleteTest_deleteItemByCondition_Name() {
   // "17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.deleteItemByCondition("name", "FB NTAWR");
      assertTrue(empDB.deleteItemByCondition("employeeNum", "17112609").isEmpty());
    }    
    
    @Test
    public void deleteTest_deleteItemByCondition_Cl() {
   // "17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.deleteItemByCondition("cl", "CL4");
      assertTrue(empDB.deleteItemByCondition("employeeNum", "17112609").isEmpty());
    }    
    
    @Test
    public void deleteTest_deleteItemByCondition_PhoneNum() {
   // "17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.deleteItemByCondition("phoneNum", "010-5645-6122");
      assertTrue(empDB.deleteItemByCondition("employeeNum", "17112609").isEmpty());
    }    
    
    @Test
    public void deleteTest_deleteItemByCondition_Birthday() {
   // "17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.deleteItemByCondition("birthday", "19860903");
      assertTrue(empDB.deleteItemByCondition("employeeNum", "17112609").isEmpty());
    }    
    
    @Test
    public void deleteTest_deleteItemByCondition_Certi() {
      //"15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
      //"18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV")));
      
      empDB.deleteItemByCondition("certi", "ADV");
      assertTrue(empDB.deleteItemByCondition("employeeNum", "15123099").isEmpty());
      assertTrue(empDB.deleteItemByCondition("employeeNum", "18115040").isEmpty());
    }   
}