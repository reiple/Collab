package collab.options.first;

import collab.AbstractFirstOption;
import collab.Employee;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintOptionTest {

    @Test
    void EmployeeSortingTest() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult = "88114052," + "NQ LVARW," + "CL4," + "010-4528-3059," + "19911021," +"PRO" + '\n';
        expectedResult += "88115052," + "VSID TVO," + "CL1," + "010-3669-1077," + "20120718," + "PRO" + '\n';
        expectedResult += "99129568," + "SRERLALH HMEF," + "CL2," + "010-3091-9521," + "19640910," + "PRO" + '\n';
        expectedResult += "02117175," + "SBILHUT LDEXRI," + "CL4," + "010-2814-1699," + "19950704," + "ADV" + '\n';
        expectedResult += "03113260," + "HH LTUPF," + "CL2," + "010-5798-5383," + "19791018," + "PRO" + '\n';

        employees.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
        employees.add(new Employee(Arrays.asList("17112609","FB NTAWR","CL4","010-5645-6122","19861203","PRO")));
        employees.add(new Employee(Arrays.asList("18115040","TTETHU HBO","CL3","010-4581-2050","20080718","ADV")));
        employees.add(new Employee(Arrays.asList("88114052","NQ LVARW","CL4","010-4528-3059","19911021","PRO")));
        employees.add(new Employee(Arrays.asList("99129568","SRERLALH HMEF","CL2","010-3091-9521","19640910","PRO")));
        employees.add(new Employee(Arrays.asList("88115052","VSID TVO","CL1","010-3669-1077","20120718","PRO")));
        employees.add(new Employee(Arrays.asList("18117906","TWU QSOLT","CL4","010-6672-7186","20030413","PRO")));
        employees.add(new Employee(Arrays.asList("08123556","WN XV","CL1","010-7986-5047","20100614","PRO")));
        employees.add(new Employee(Arrays.asList("02117175","SBILHUT LDEXRI","CL4","010-2814-1699","19950704","ADV")));
        employees.add(new Employee(Arrays.asList("03113260","HH LTUPF","CL2","010-5798-5383","19791018","PRO")));

        assertEquals(printOption.getFilteredList(employees), expectedResult);
    }

    @Test
    void OneEmployeeSortingTest() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult = "15123099," + "VXIHXOTH JHOP," + "CL3," + "010-3112-2609," + "19771211," +"ADV" + '\n';
        employees.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));

        assertEquals(printOption.getFilteredList(employees), expectedResult);
    }

    @Test
    void ThreeEmployeeSortingTest() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult = "15123099," + "VXIHXOTH JHOP," + "CL3," + "010-3112-2609," + "19771211," +"ADV" + '\n';
        expectedResult += "18111236," + "VSID TVO," + "CL1," + "010-3669-1077," + "20120718," +"PRO" + '\n';
        expectedResult += "18117906," + "TWU QSOLT," + "CL4," + "010-6672-7186," + "20030413," +"PRO" + '\n';
        employees.add(new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV")));
        employees.add(new Employee(Arrays.asList("18111236","VSID TVO","CL1","010-3669-1077","20120718","PRO")));
        employees.add(new Employee(Arrays.asList("18117906","TWU QSOLT","CL4","010-6672-7186","20030413","PRO")));

        assertEquals(printOption.getFilteredList(employees), expectedResult);
    }


    @Test
    void EmptyEmployeeListTest() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult = null;

        assertEquals(printOption.getFilteredList(employees), expectedResult);
    }
}

