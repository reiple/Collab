package collab;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModifyTestbyCondition {
  
  DataBase empDB = new DataBase();
    @BeforeEach
    void setUp() {
      empDB.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
      empDB.add(new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO")));
      empDB.add(new Employee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718", "ADV")));
    }
    
    @Test
    void modifyTest_sName_cName() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      List<Employee> foundEmployee = empDB.modifyItemByCondition("name", "FB NTAWR", "name", "TEST TEST");

      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.get(0).getEmployeeNumber());
      assertEquals(targetEmployee.getName(), foundEmployee.get(0).getName());
      assertTrue(empDB.searchItems("name", "FB NTAWR").isEmpty());
      assertTrue(!empDB.searchItems("name", "TEST TEST").isEmpty());
    }
    
    @Test
    void modifyTest_sName_cCl() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      List<Employee> foundEmployee = empDB.modifyItemByCondition("name", "FB NTAWR", "cl", "CL2");

      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.get(0).getEmployeeNumber());
      assertEquals(targetEmployee.getCareerLevel(), foundEmployee.get(0).getCareerLevel());
      assertTrue(empDB.searchItems("cl", "CL4").isEmpty());
      assertTrue(!empDB.searchItems("cl", "CL2").isEmpty());
    }
    
    @Test
    void modifyTest_sName_cPhoneNumber() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      List<Employee> foundEmployee = empDB.modifyItemByCondition("name", "FB NTAWR", "phoneNum", "010-5645-0000");

      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.get(0).getEmployeeNumber());
      assertEquals(targetEmployee.getPhoneNumber(), foundEmployee.get(0).getPhoneNumber());
      assertTrue(empDB.searchItems("phoneNum", "010-5645-6122").isEmpty());
      assertTrue(!empDB.searchItems("phoneNum", "010-5645-0000").isEmpty());
    }
    
    @Test
    void modifyTest_sName_cBirthday() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      List<Employee> foundEmployee = empDB.modifyItemByCondition("name", "FB NTAWR", "birthday", "19860101");

      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.get(0).getEmployeeNumber());
      assertEquals(targetEmployee.getBirthday(), foundEmployee.get(0).getBirthday());
      assertTrue(empDB.searchItems("birthday", "19860903").isEmpty());
      assertTrue(!empDB.searchItems("birthday", "19860101").isEmpty());
    }
    
    @Test
    void modifyTest_sName_cCerti() {
      Employee targetEmployee = new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19860903","PRO"));
      List<Employee> foundEmployee = empDB.modifyItemByCondition("name", "FB NTAWR", "certi", "EX");

      assertEquals(targetEmployee.getEmployeeNumber(), foundEmployee.get(0).getEmployeeNumber());
      assertEquals(targetEmployee.getCerti(), foundEmployee.get(0).getCerti());
      assertTrue(empDB.searchItems("certi", "PRO").isEmpty());
      assertTrue(!empDB.searchItems("certi", "EX").isEmpty());
    }
}

