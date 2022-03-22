package collab.options.first;

import collab.AbstractFirstOption;
import collab.Employee;
import collab.SearchCommand;
import collab.options.second.EmptySecondOption;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class PrintOptionTest {

    @Test
    void EmployeeSortingTest() throws Exception {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult =
            "SCH,88114052," + "NQ LVARW," + "CL4," + "010-4528-3059," + "19911021," + "PRO"
                + System.lineSeparator();
        expectedResult +=
            "SCH,88115052," + "VSID TVO," + "CL1," + "010-3669-1077," + "20120718," + "PRO"
                + System.lineSeparator();
        expectedResult +=
            "SCH,99129568," + "SRERLALH HMEF," + "CL2," + "010-3091-9521," + "19640910," + "PRO"
                + System.lineSeparator();
        expectedResult +=
            "SCH,02117175," + "SBILHUT LDEXRI," + "CL4," + "010-2814-1699," + "19950704," + "ADV"
                + System.lineSeparator();
        expectedResult +=
            "SCH,03113260," + "HH LTUPF," + "CL2," + "010-5798-5383," + "19791018," + "PRO";

        employees.add(new Employee(
            Arrays.asList("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV")));
        employees.add(new Employee(
            Arrays.asList("17112609", "FB NTAWR", "CL4", "010-5645-6122", "19861203", "PRO")));
        employees.add(new Employee(
            Arrays.asList("18115040", "TTETHU HBO", "CL3", "010-4581-2050", "20080718", "ADV")));
        employees.add(new Employee(
            Arrays.asList("88114052", "NQ LVARW", "CL4", "010-4528-3059", "19911021", "PRO")));
        employees.add(new Employee(
            Arrays.asList("99129568", "SRERLALH HMEF", "CL2", "010-3091-9521", "19640910", "PRO")));
        employees.add(new Employee(
            Arrays.asList("88115052", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO")));
        employees.add(new Employee(
            Arrays.asList("18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO")));
        employees.add(new Employee(
            Arrays.asList("08123556", "WN XV", "CL1", "010-7986-5047", "20100614", "PRO")));
        employees.add(new Employee(
            Arrays.asList("02117175", "SBILHUT LDEXRI", "CL4", "010-2814-1699", "19950704",
                "ADV")));
        employees.add(new Employee(
            Arrays.asList("03113260", "HH LTUPF", "CL2", "010-5798-5383", "19791018", "PRO")));

        assertEquals(expectedResult,
            printOption.getFilteredList(employees, new SearchCommand(printOption,
                new EmptySecondOption(Arrays.asList("name", "TEST TEST")))));
    }

    @Test
    void OneEmployeeSortingTest() throws Exception {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult =
            "SCH,15123099," + "VXIHXOTH JHOP," + "CL3," + "010-3112-2609," + "19771211," + "ADV";
        employees.add(new Employee(
            Arrays.asList("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV")));

        assertEquals(expectedResult,
            printOption.getFilteredList(employees, new SearchCommand(printOption,
                new EmptySecondOption(Arrays.asList("name", "TEST TEST")))));
    }

    @Test
    void ThreeEmployeeSortingTest() throws Exception {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult =
            "SCH,15123099," + "VXIHXOTH JHOP," + "CL3," + "010-3112-2609," + "19771211," + "ADV"
                + System.lineSeparator();
        expectedResult +=
            "SCH,18111236," + "VSID TVO," + "CL1," + "010-3669-1077," + "20120718," + "PRO"
                + System.lineSeparator();
        expectedResult +=
            "SCH,18117906," + "TWU QSOLT," + "CL4," + "010-6672-7186," + "20030413," + "PRO";
        employees.add(new Employee(
            Arrays.asList("15123099", "VXIHXOTH JHOP", "CL3", "010-3112-2609", "19771211", "ADV")));
        employees.add(new Employee(
            Arrays.asList("18111236", "VSID TVO", "CL1", "010-3669-1077", "20120718", "PRO")));
        employees.add(new Employee(
            Arrays.asList("18117906", "TWU QSOLT", "CL4", "010-6672-7186", "20030413", "PRO")));

        assertEquals(expectedResult,
            printOption.getFilteredList(employees, new SearchCommand(printOption,
                new EmptySecondOption(Arrays.asList("name", "TEST TEST")))));
    }


    @Test
    void EmptyEmployeeListTest() throws Exception {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AbstractFirstOption printOption = new PrintOption();
        String expectedResult = "SCH,NONE";

        assertEquals(expectedResult, printOption.getFilteredList(employees,
            new SearchCommand(printOption,
                new EmptySecondOption(Arrays.asList("name", "TEST TEST")))));
    }

}

