package collab;


import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.java.collab.DataBase;
import main.java.collab.Employee;

class DeleteTest {
  
  DataBase empDB = new DataBase();
    @BeforeEach
    public void setUp() {
      empDB.addEmployee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV"));
      empDB.addEmployee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      empDB.addEmployee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV"));
    }
    
    @Test
    public void deleteTest_returnEmployee() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      Employee foundEmployee = empDB.deleteEmployee("", "employeeNum", "17112609").get(0);

      assertEquals(foundEmployee.getEmployeeNumber(), targetEmployee.getEmployeeNumber());
    }

      
    @Test
    public void deleteTest_NoReturn() {
      // "17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"
      empDB.deleteEmployee("", "employeeNum", "17112609");
      assertTrue(empDB.searchEmployee("", "employeeNum", "17112609").size()==0);
    }
}

