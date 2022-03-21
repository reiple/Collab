package collab;

import collab.options.first.NoneFirstOption;
import collab.options.first.PrintOption;
import collab.options.second.DayOfBirthdayOption;
import collab.options.second.EmptySecondOption;
import collab.options.second.LastNameOption;
import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeManagerTest {
    private List<String> commandStringList1 ;
    @BeforeEach
    public void InitStringList(){
        commandStringList1 = Arrays.asList(
                "ADD, , , ,18117906,TWU QSOLT,CL4,010-6672-7186,20030413,PRO",
                "SCH,-p,-d, ,birthday,04",
                "MOD,-p, , ,name,TWU QSOLT,cl,CL3",
                "DEL,-p,-l, ,name,QSOLT"
        );
    }

    @Test
    public void CommandParseTest() {
        EmployeeManager employeeManager = new EmployeeManager();
        List<ICommand> commandList = employeeManager.parseCommandList(commandStringList1);
        assertTrue(commandList.size() == 4);
        assertTrue(commandList.get(0) instanceof AddCommand);
        assertTrue(((AddCommand) commandList.get(0)).getFirstOption() instanceof NoneFirstOption);
        assertTrue(((AddCommand) commandList.get(0)).getSecondOption() instanceof NoneSecondOption);
        assertTrue(((AddCommand) commandList.get(0)).getThirdOption() instanceof NoneThirdOption);

        assertTrue(commandList.get(1) instanceof SearchCommand);
        assertTrue(((SearchCommand) commandList.get(1)).getFirstOption() instanceof PrintOption);
        assertTrue(((SearchCommand) commandList.get(1)).getSecondOption() instanceof DayOfBirthdayOption);
        assertTrue(((SearchCommand) commandList.get(1)).getThirdOption() instanceof NoneThirdOption);

        assertTrue(commandList.get(2) instanceof ModifyCommand);
        assertTrue(((ModifyCommand) commandList.get(2)).getFirstOption() instanceof PrintOption);
        assertTrue(((ModifyCommand) commandList.get(2)).getSecondOption() instanceof EmptySecondOption);
        assertTrue(((ModifyCommand) commandList.get(2)).getThirdOption() instanceof NoneThirdOption);

        assertTrue(commandList.get(3) instanceof DeleteCommand);
        assertTrue(((DeleteCommand) commandList.get(3)).getFirstOption() instanceof PrintOption);
        assertTrue(((DeleteCommand) commandList.get(3)).getSecondOption() instanceof LastNameOption);
        assertTrue(((DeleteCommand) commandList.get(3)).getThirdOption() instanceof NoneThirdOption);
    }
}