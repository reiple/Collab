package collab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTest {
    @Test
    public void employeeCreateTest() {
        Employee employee = new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV"));

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
        Employee employee = new Employee(Arrays.asList("15123099","VXIHXOTH JHOP","CL3","010-3112-0609","19770911","ADV"));

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
        Employee employee = new Employee(Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV"));

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

    @Test
    public void employeeModifyTest() {
        Employee employee = new Employee(Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV"));

        employee.setEmployeeNumber("15123099");
        String employeeNumber = employee.getEmployeeNumber();
        int realEmployeeNumber = employee.getRealEmployeeNumber();

        assertEquals(employeeNumber, "15123099");
        assertEquals(realEmployeeNumber, 2015123099);

        employee.setName("VXIHXOTH JHOP");
        String name = employee.getName();
        String firstName = employee.getFirstName();
        String lastname = employee.getLastName();

        assertEquals(name, "VXIHXOTH JHOP");
        assertEquals(firstName, "VXIHXOTH");
        assertEquals(lastname, "JHOP");

        employee.setCareerLevel("CL2");
        String careerLevel = employee.getCareerLevel();

        assertEquals(careerLevel, "CL2");

        employee.setPhoneNumber("010-1234-0039");
        String phoneNumber = employee.getPhoneNumber();
        String middlePhoneNumber = employee.getMiddlePhoneNumber();
        String lastPhoneNumber = employee.getLastPhoneNumber();

        assertEquals(phoneNumber, "010-1234-0039");
        assertEquals(middlePhoneNumber, "1234");
        assertEquals(lastPhoneNumber, "0039");

        employee.setBirthday("20070805");
        String birthday = employee.getBirthday();
        String birthYearOnly = employee.getBirthYearOnly();
        String birthMonthOnly = employee.getBirthMonthOnly();
        String birthDayOnly = employee.getBirthDayOnly();

        assertEquals(birthday, "20070805");
        assertEquals(birthYearOnly, "2007");
        assertEquals(birthMonthOnly, "08");
        assertEquals(birthDayOnly, "05");

        employee.setCerti("PRO");

        String certi = employee.getCerti();
        assertEquals(certi, "PRO");
    }


    @Test
    public void employeeNumberValidationTest() {
        List<String> lengthFailCommand = Arrays.asList("9912B09999","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> stringEmployeeNumCommand = Arrays.asList("9A12B099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> rangeFailCommand = Arrays.asList("25123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> passCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        Employee employee = new Employee(passCommand);

        Assertions.assertDoesNotThrow(() -> {new Employee(passCommand);});

        Throwable exceptionLengthCreate = Assertions.assertThrows(RuntimeException.class, () -> {new Employee(lengthFailCommand);});
        Throwable exceptionLengthSet = Assertions.assertThrows(RuntimeException.class, () -> {employee.setEmployeeNumber("9912B09999");});
        Throwable exceptionDigitCreate = Assertions.assertThrows(RuntimeException.class, () -> {new Employee(stringEmployeeNumCommand);});
        Throwable exceptionDigitSet = Assertions.assertThrows(RuntimeException.class, () -> {employee.setEmployeeNumber("9A12B099");});
        Throwable exceptionRangeCreate = Assertions.assertThrows(RuntimeException.class, () -> {new Employee(rangeFailCommand);});
        Throwable exceptionRangeSet = Assertions.assertThrows(RuntimeException.class, () -> {employee.setEmployeeNumber("25123099");});

        assertEquals("Employee number input is not valid", exceptionLengthCreate.getMessage());
        assertEquals("Employee number input is not valid", exceptionLengthSet.getMessage());
        assertEquals("Employee number input is not valid", exceptionDigitCreate.getMessage());
        assertEquals("Employee number input is not valid", exceptionDigitSet.getMessage());
        assertEquals("Employee number input is not valid", exceptionRangeCreate.getMessage());
        assertEquals("Employee number input is not valid", exceptionRangeSet.getMessage());

    }

}
