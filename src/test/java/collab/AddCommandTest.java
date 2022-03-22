package collab;

import collab.options.first.NoneFirstOption;
import collab.options.second.NoneSecondOption;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class AddCommandTest {

    @Test
    void testAddCommandSuccess() throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.initDatabase();

        ICommand command = new AddCommand(
                Arrays.asList("18050301", "KYUMOK KIM", "CL2", "010-9777-6055", "19980906", "PRO"));
        String result = command.executeCommand(employeeDAO);
        assertEquals("NONE", result);
    }

    @Test
    void testAddCommandException() throws Exception {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.initDatabase();

        ICommand command = new AddCommand(
                Arrays.asList("18050301", "KYUMOK KIM", "CL7", "010-9777-6055", "19980906", "PRO"));
        Assertions.assertThrows(RuntimeException.class, () -> {command.executeCommand(employeeDAO);});
    }
}

