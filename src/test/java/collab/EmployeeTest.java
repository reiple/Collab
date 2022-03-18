package collab;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeTest {
    Employee employee = new Employee();

    @BeforeEach
    void SetUp() {
        //"15123099","VXIHXOTH JHOP","CL3","010-3112-2609","19771211","ADV"
        employee.setEmployeeNumber("15123099");
        employee.setName("VXIHXOTH JHOP");
        employee.setCareerLevel("CL3");
        employee.setPhoneNumber("010-3112-2609");
        employee.setBirthday("19771211");
        employee.setCerti("ADV");

        employee.setFirstName("VXIHXOTH");
        employee.setLastName("JHOP");
        employee.setRealEmployeeNumber(201523099);
        employee.setMiddlePhoneNumber("3112");
        employee.setLastPhoneNumber("0609");
        employee.setBirthYearOnly("1977");
        employee.setBirthMonthOnly("09");
        employee.setBirthDayOnly("11");

    }

    @Test
    public void getEmployeeTest() {
        String employeeNumber = employee.getEmployeeNumber();
        String name = employee.getName();
        String careerLevel = employee.getCareerLevel();
        String phoneNumber = employee.getPhoneNumber();
        String birthday = employee.getBirthday();
        String certi = employee.getCerti();

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        int realEmployeeNumber = employee.getRealEmployeeNumber();
        String middlePhoneNumber = employee.getMiddlePhoneNumber();
        String lastPhoneNumber = employee.getLastPhoneNumber();
        String birthYearOnly = employee.getBirthYearOnly();
        String birthMonthOnly = employee.getBirthMonthOnly();
        String birthDayOnly = employee.getBirthDayOnly();

        assertEquals(employeeNumber, "15123099");
        assertEquals(name, "VXIHXOTH JHOP");
        assertEquals(careerLevel, "CL3");
        assertEquals(phoneNumber, "010-3112-2609");
        assertEquals(birthday, "19771211");
        assertEquals(certi, "ADV");

        assertEquals(firstName, "VXIHXOTH");
        assertEquals(lastName, "JHOP");
        assertEquals(realEmployeeNumber, 201523099);
        assertEquals(middlePhoneNumber, "3112");
        assertEquals(lastPhoneNumber, "0609");
        assertEquals(birthYearOnly, "1977");
        assertEquals(birthMonthOnly, "09");
        assertEquals(birthDayOnly, "11");
    }
}
