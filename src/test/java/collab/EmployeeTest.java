package collab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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

    private static void cmdAssertionCheck(List<String> cmd, Employee employee, String assertMsg, Executable executable){
        Throwable exceptionhCreate = Assertions.assertThrows(RuntimeException.class, () -> {new Employee(cmd);});
        Throwable exceptionSet = Assertions.assertThrows(RuntimeException.class, executable);

        assertEquals(assertMsg, exceptionhCreate.getMessage());
        assertEquals(assertMsg, exceptionSet.getMessage());
    }

    @Test
    public void employeeNumberValidationTest() {
        List<String> lengthFailCommand = Arrays.asList("9912B09999","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> stringEmployeeNumCommand = Arrays.asList("9A12B099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> rangeFailCommand = Arrays.asList("25123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> passCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        String assertMsg = "Employee number input is not valid";
        Employee employee = new Employee(passCommand);

        Assertions.assertDoesNotThrow(() -> {new Employee(passCommand);});

        cmdAssertionCheck(lengthFailCommand, employee, assertMsg, () -> {employee.setEmployeeNumber(lengthFailCommand.get(0));});
        cmdAssertionCheck(stringEmployeeNumCommand, employee, assertMsg, () -> {employee.setEmployeeNumber(stringEmployeeNumCommand.get(0));});
        cmdAssertionCheck(rangeFailCommand, employee, assertMsg, () -> {employee.setEmployeeNumber(rangeFailCommand.get(0));});
    }

    @Test
    public void employeeNameValidationTest() {
        List<String> lengthFailCommand = Arrays.asList("99123099","TTETHU HBOHBOHBO","CL4","010-4528-3059","19771208","ADV");
        List<String> koreanNameCommand = Arrays.asList("99123099","박 대영","CL4","010-4528-3059","19771208","ADV");
        List<String> lowerCaseFailCommand = Arrays.asList("99123099","ttethu HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> numberFailCommand = Arrays.asList("99123099","TT1THU HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> spaceFailCommand1 = Arrays.asList("99123099","TTTHUHBO","CL4","010-4528-3059","19771208","ADV");
        List<String> spaceFailCommand2 = Arrays.asList("99123099","TTETHU  HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> spaceFailCommand3 = Arrays.asList("99123099","TTETHU HBO HBO","CL4","010-4528-3059","19771208","ADV");
        List<String> passCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        String assertMsg = "Employee name input is not valid";
        Employee employee = new Employee(passCommand);

        Assertions.assertDoesNotThrow(() -> {new Employee(passCommand);});

        cmdAssertionCheck(lengthFailCommand, employee, assertMsg, () -> {employee.setName(lengthFailCommand.get(1));});
        cmdAssertionCheck(koreanNameCommand, employee, assertMsg, () -> {employee.setName(koreanNameCommand.get(1));});
        cmdAssertionCheck(lowerCaseFailCommand, employee, assertMsg, () -> {employee.setName(lowerCaseFailCommand.get(1));});
        cmdAssertionCheck(numberFailCommand, employee, assertMsg, () -> {employee.setName(numberFailCommand.get(1));});
        cmdAssertionCheck(spaceFailCommand1, employee, assertMsg, () -> {employee.setName(spaceFailCommand1.get(1));});
        cmdAssertionCheck(spaceFailCommand2, employee, assertMsg, () -> {employee.setName(spaceFailCommand2.get(1));});
        cmdAssertionCheck(spaceFailCommand3, employee, assertMsg, () -> {employee.setName(spaceFailCommand3.get(1));});

    }

    @Test
    public void employeeCareerLevelValidationTest() {
        List<String> lengthFailCommand = Arrays.asList("99123099","TTETHU HBO","CL44","010-4528-3059","19771208","ADV");
        List<String> lowerFailCommand = Arrays.asList("99123099","TTETHU HBO","cl4","010-4528-3059","19771208","ADV");
        List<String> whiteBoxCommand = Arrays.asList("99123099","TTETHU HBO","CL5","010-4528-3059","19771208","ADV");
        List<String> passCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        String assertMsg = "Employee career level input is not valid";
        Employee employee = new Employee(passCommand);

        Assertions.assertDoesNotThrow(() -> {new Employee(passCommand);});

        cmdAssertionCheck(lengthFailCommand, employee, assertMsg, () -> {employee.setCareerLevel(lengthFailCommand.get(2));});
        cmdAssertionCheck(lowerFailCommand, employee, assertMsg, () -> {employee.setCareerLevel(lowerFailCommand.get(2));});
        cmdAssertionCheck(whiteBoxCommand, employee, assertMsg, () -> {employee.setCareerLevel(whiteBoxCommand.get(2));});
    }

    @Test
    public void employeePhoneNumberValidationTest() {
        List<String> lengthFailCommand = Arrays.asList("99123099","TTETHU HBO","cl4","010-45289-3059","19771208","ADV");
        List<String> numberFailCommand = Arrays.asList("99123099","TTETHU HBO","cl4","019-45289-3059","19771208","ADV");
        List<String> digitFailCommand = Arrays.asList("99123099","TTETHU HBO","cl4","010-4ase-3059","19771208","ADV");
        List<String> splitFailCommand1 = Arrays.asList("99123099","TTETHU HBO","cl4","010+45289-3059","19771208","ADV");
        List<String> splitFailCommand2 = Arrays.asList("99123099","TTETHU HBO","cl4","010--45289-3059","19771208","ADV");
        List<String> splitFailCommand3 = Arrays.asList("99123099","TTETHU HBO","cl4","010--3059-45289","19771208","ADV");
        List<String> passCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        String assertMsg = "Employee phone number input is not valid";
        Employee employee = new Employee(passCommand);

        Assertions.assertDoesNotThrow(() -> {new Employee(passCommand);});

        cmdAssertionCheck(lengthFailCommand, employee, assertMsg, () -> {employee.setPhoneNumber(lengthFailCommand.get(3));});
        cmdAssertionCheck(numberFailCommand, employee, assertMsg, () -> {employee.setPhoneNumber(numberFailCommand.get(3));});
        cmdAssertionCheck(digitFailCommand, employee, assertMsg, () -> {employee.setPhoneNumber(digitFailCommand.get(3));});
        cmdAssertionCheck(splitFailCommand1, employee, assertMsg, () -> {employee.setPhoneNumber(splitFailCommand1.get(3));});
        cmdAssertionCheck(splitFailCommand2, employee, assertMsg, () -> {employee.setPhoneNumber(splitFailCommand2.get(3));});
        cmdAssertionCheck(splitFailCommand3, employee, assertMsg, () -> {employee.setPhoneNumber(splitFailCommand3.get(3));});
    }

    @Test
    public void employeeBirthDayValidationTest() {
        List<String> lengthFailCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","197712080","ADV");
        List<String> monthFailCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771308","ADV");
        List<String> dayFailCommand1 = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19770230","ADV");
        List<String> dayFailCommand2 = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19770431","ADV");
        List<String> yearFailCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","20231208","ADV");
        List<String> digitFailCommand3 = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","197a1208","ADV");
        List<String> passCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        String assertMsg = "Employee birth day input is not valid";
        Employee employee = new Employee(passCommand);

        Assertions.assertDoesNotThrow(() -> {new Employee(passCommand);});

        cmdAssertionCheck(lengthFailCommand, employee, assertMsg, () -> {employee.setBirthday(lengthFailCommand.get(4));});
        cmdAssertionCheck(monthFailCommand, employee, assertMsg, () -> {employee.setBirthday(monthFailCommand.get(4));});
        cmdAssertionCheck(dayFailCommand1, employee, assertMsg, () -> {employee.setBirthday(dayFailCommand1.get(4));});
        cmdAssertionCheck(dayFailCommand2, employee, assertMsg, () -> {employee.setBirthday(dayFailCommand2.get(4));});
        cmdAssertionCheck(yearFailCommand, employee, assertMsg, () -> {employee.setBirthday(yearFailCommand.get(4));});
        cmdAssertionCheck(digitFailCommand3, employee, assertMsg, () -> {employee.setBirthday(digitFailCommand3.get(4));});
    }

    @Test
    public void employeeCertiValidationTest() {
        List<String> lengthFailCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADVV");
        List<String> lowerFailCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","adv");
        List<String> whiteBoxCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","EXPERT");
        List<String> passCommand = Arrays.asList("99123099","TTETHU HBO","CL4","010-4528-3059","19771208","ADV");
        String assertMsg = "Employee certi input is not valid";
        Employee employee = new Employee(passCommand);

        Assertions.assertDoesNotThrow(() -> {new Employee(passCommand);});

        cmdAssertionCheck(lengthFailCommand, employee, assertMsg, () -> {employee.setCerti(lengthFailCommand.get(5));});
        cmdAssertionCheck(lowerFailCommand, employee, assertMsg, () -> {employee.setCerti(lowerFailCommand.get(5));});
        cmdAssertionCheck(whiteBoxCommand, employee, assertMsg, () -> {employee.setCerti(whiteBoxCommand.get(5));});
    }



}
