package collab;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import options.Columns;

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
      Employee foundEmployee = empDB.modifyItemByCondition(Columns.COLUMN_EMPLOYEE_NUM, "17112609", Columns.COLUMN_NAME, "TEST TEST").get(0);

      assertEquals(foundEmployee.getEmployeeNumber(), targetEmployee.getEmployeeNumber());
      assertEquals(foundEmployee.getName(), targetEmployee.getName());
    }
    
    @Test
    public void modifyTest_Name() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition(Columns.COLUMN_EMPLOYEE_NUM, "17112609", Columns.COLUMN_NAME, "TEST TEST");

      assertNull(empDB.searchItems(Columns.COLUMN_NAME,"FB NTAWR"));
      assertTrue(empDB.searchItems(Columns.COLUMN_NAME,"TEST TEST").get(0).getEmployeeNumber() == "17112609");
    }
    
    @Test
    public void modifyTest_Cl() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
        empDB.modifyItemByCondition(Columns.COLUMN_EMPLOYEE_NUM, "17112609", Columns.COLUMN_CARRER_LEVEL, "CL1");

        assertNull(empDB.searchItems(Columns.COLUMN_CARRER_LEVEL,"CL4"));
        assertTrue(empDB.searchItems(Columns.COLUMN_CARRER_LEVEL,"CL1").get(0).getEmployeeNumber() == "17112609");
      
    }
    
    @Test
    public void modifyTest_PhoneNum() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition(Columns.COLUMN_EMPLOYEE_NUM, "17112609", Columns.COLUMN_PHONE_NUMBER, "010-0000-0000");

      assertNull(empDB.searchItems(Columns.COLUMN_PHONE_NUMBER,"010-5645-6122"));
      assertTrue(empDB.searchItems(Columns.COLUMN_PHONE_NUMBER,"010-0000-0000").get(0).getEmployeeNumber() == "17112609");
    }
    
    @Test
    public void modifyTest_Birthday() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition(Columns.COLUMN_EMPLOYEE_NUM, "17112609", Columns.COLUMN_BIRTHDAY, "19001101");

      assertNull(empDB.searchItems(Columns.COLUMN_BIRTHDAY,"19860903"));
      assertTrue(empDB.searchItems(Columns.COLUMN_BIRTHDAY,"19001101").get(0).getEmployeeNumber() == "17112609");
    }    
    
    @Test
    public void modifyTest_certi() {
      //"17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.modifyItemByCondition(Columns.COLUMN_EMPLOYEE_NUM, "17112609", Columns.COLUMN_CERTIFICATE, "EX");
      
      assertNull(empDB.searchItems(Columns.COLUMN_CERTIFICATE,"PRO"));
      assertTrue(empDB.searchItems(Columns.COLUMN_CERTIFICATE,"EX").get(0).getEmployeeNumber() == "17112609");
    }
}


