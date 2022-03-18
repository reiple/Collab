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

}
