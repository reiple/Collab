package collab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    @Test
    public void employeeCreateTest() {
        List<String> commandArguments =new ArrayList<String>();
        commandArguments.add("15123099");
        commandArguments.add("VXIHXOTH JHOP");
        commandArguments.add("CL3");
        commandArguments.add("010-3112-2609");
        commandArguments.add("19771211");
        commandArguments.add("ADV");
        Employee employee = new Employee(commandArguments);

        String employeeNumber = employee.getEmployeeNumber();
        String name = employee.getName();
        String careerLevel = employee.getCareerLevel();
        String phoneNumber = employee.getPhoneNumber();
        String birthday = employee.getBirthday();
        String certi = employee.getCerti();

        assertEquals(employeeNumber, "15123099");
        assertEquals(name, "VXIHXOTH JHOP");
        assertEquals(careerLevel, "CL3");
        assertEquals(phoneNumber, "010-3112-2609");
        assertEquals(birthday, "19771211");
        assertEquals(certi, "ADV");
    }

    @Test
    public void employeeProcessingTest2000() {
        List<String> commandArguments =new ArrayList<String>();
        commandArguments.add("15123099");
        commandArguments.add("VXIHXOTH JHOP");
        commandArguments.add("CL3");
        commandArguments.add("010-3112-0609");
        commandArguments.add("19770911");
        commandArguments.add("ADV");
        Employee employee = new Employee(commandArguments);

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        int realEmployeeNumber = employee.getRealEmployeeNumber();
        String middlePhoneNumber = employee.getMiddlePhoneNumber();
        String lastPhoneNumber = employee.getLastPhoneNumber();
        String birthYearOnly = employee.getBirthYearOnly();
        String birthMonthOnly = employee.getBirthMonthOnly();
        String birthDayOnly = employee.getBirthDayOnly();

        assertEquals(firstName, "VXIHXOTH");
        assertEquals(lastName, "JHOP");
        assertEquals(realEmployeeNumber, 2015123099);
        assertEquals(middlePhoneNumber, "3112");
        assertEquals(lastPhoneNumber, "0609");
        assertEquals(birthYearOnly, "1977");
        assertEquals(birthMonthOnly, "09");
        assertEquals(birthDayOnly, "11");
    }

    @Test
    public void employeeProcessingTest1900() {
        List<String> commandArguments =new ArrayList<String>();
        commandArguments.add("99123099");
        commandArguments.add("TTETHU HBO");
        commandArguments.add("CL4");
        commandArguments.add("010-4528-3059");
        commandArguments.add("19771208");
        commandArguments.add("ADV");
        Employee employee = new Employee(commandArguments);

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        int realEmployeeNumber = employee.getRealEmployeeNumber();
        String middlePhoneNumber = employee.getMiddlePhoneNumber();
        String lastPhoneNumber = employee.getLastPhoneNumber();
        String birthYearOnly = employee.getBirthYearOnly();
        String birthMonthOnly = employee.getBirthMonthOnly();
        String birthDayOnly = employee.getBirthDayOnly();


        assertEquals(firstName, "TTETHU");
        assertEquals(lastName, "HBO");
        assertEquals(realEmployeeNumber, 1999123099);
        assertEquals(middlePhoneNumber, "4528");
        assertEquals(lastPhoneNumber, "3059");
        assertEquals(birthYearOnly, "1977");
        assertEquals(birthMonthOnly, "12");
        assertEquals(birthDayOnly, "08");
    }

}
