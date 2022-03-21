package collab;

import collab.options.first.EmptyFirstOption;
import collab.options.first.NoneFirstOption;
import collab.options.first.PrintOption;
import collab.options.second.EmptySecondOption;
import collab.options.second.LastNameOption;
import collab.options.second.MiddlePhoneNumberOption;
import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommandParserTest {
    @Test
    public void commandFailTest() {
        String failString = "WRONG, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
        CommandParser commandParser = new CommandParser();

        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(failString);
        });
        assertEquals("ERROR::Command is invalid...", exception.getMessage());
    }

    @Test
    public void addCommandPassTest() throws Exception {
        String addPassString = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
        CommandParser commandParser = new CommandParser();
        ICommand cmd = commandParser.parseToCommand(addPassString);
        assertTrue(cmd instanceof AddCommand);
        assertTrue(((AddCommand) cmd).getFirstOption() instanceof NoneFirstOption);
        assertTrue(((AddCommand) cmd).getSecondOption() instanceof NoneSecondOption);
        assertTrue(((AddCommand) cmd).getThirdOption() instanceof NoneThirdOption);
        List<String> args = ((AddCommand) cmd).getCommandArguments();
        for (int i = 0 ; i < args.size() ; i ++){
            assertEquals(args.get(i), addPassString.split(",")[i+4]);
        }
    }

    @Test
    public void addCommandFailTest1() {
        String addFailString = "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(addFailString);
        });
        assertEquals("ERROR::Command format is wrong...", exception.getMessage());
    }

    @Test
    public void addCommandFailTest2() {
        String addFailString = "ADD,-p, , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(addFailString);
        });
        assertEquals("ERROR::Command option is wrong...", exception.getMessage());
    }

    @Test
    public void addCommandFailTest3() {
        String addFailString = "ADD, ,-m, ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(addFailString);
        });
        assertEquals("ERROR::Command option is wrong...", exception.getMessage());
    }

    @Test
    public void deleteCommandPassTest1() throws Exception {
        String deletePassString = "DEL, , , ,name,KYUMOK KIM";
        CommandParser commandParser = new CommandParser();
        ICommand cmd = commandParser.parseToCommand(deletePassString);
        assertTrue(cmd instanceof DeleteCommand);
        assertTrue(((DeleteCommand) cmd).getFirstOption() instanceof EmptyFirstOption);
        assertTrue(((DeleteCommand) cmd).getSecondOption() instanceof EmptySecondOption);
        assertTrue(((DeleteCommand) cmd).getThirdOption() instanceof NoneThirdOption);
        assertEquals(((DeleteCommand) cmd).getSecondOption().getSearchColumn(), "name");
        assertEquals(((DeleteCommand) cmd).getSecondOption().getSearchValue(), "KYUMOK KIM");
    }

    @Test
    public void deleteCommandPassTest2() throws Exception {
        String deletePassString = "DEL, ,-l, ,name,KYUMOK KIM";
        CommandParser commandParser = new CommandParser();
        ICommand cmd = commandParser.parseToCommand(deletePassString);
        assertTrue(cmd instanceof DeleteCommand);
        assertTrue(((DeleteCommand) cmd).getFirstOption() instanceof EmptyFirstOption);
        assertTrue(((DeleteCommand) cmd).getSecondOption() instanceof LastNameOption);
        assertTrue(((DeleteCommand) cmd).getThirdOption() instanceof NoneThirdOption);
        assertEquals(((DeleteCommand) cmd).getSecondOption().getSearchColumn(), "name");
        assertEquals(((DeleteCommand) cmd).getSecondOption().getSearchValue(), "KYUMOK KIM");
    }

    @Test
    public void deleteCommandFailTest1() {
        String deleteFailString = "DEL, , , ,name";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(deleteFailString);
        });
        assertEquals("ERROR::Command format is wrong...", exception.getMessage());
    }

    @Test
    public void deleteCommandFailTest2() {
        String deleteFailString = "DEL, ,-a, ,name,KYUMOK KIM";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(deleteFailString);
        });
        assertEquals("ERROR::Command option is wrong...", exception.getMessage());
    }

    @Test
    public void searchCommandPassTest1() throws Exception {
        String searchPassString = "SCH, , , ,name,KYUMOK KIM";
        CommandParser commandParser = new CommandParser();
        ICommand cmd = commandParser.parseToCommand(searchPassString);
        assertTrue(cmd instanceof SearchCommand);
        assertTrue(((SearchCommand) cmd).getFirstOption() instanceof EmptyFirstOption);
        assertTrue(((SearchCommand) cmd).getSecondOption() instanceof EmptySecondOption);
        assertTrue(((SearchCommand) cmd).getThirdOption() instanceof NoneThirdOption);
        assertEquals(((SearchCommand) cmd).getSecondOption().getSearchColumn(), "name");
        assertEquals(((SearchCommand) cmd).getSecondOption().getSearchValue(), "KYUMOK KIM");
    }

    @Test
    public void searchCommandPassTest2() throws Exception {
        String searchPassString = "SCH, ,-l, ,name,KYUMOK KIM";
        CommandParser commandParser = new CommandParser();
        ICommand cmd = commandParser.parseToCommand(searchPassString);
        assertTrue(cmd instanceof SearchCommand);
        assertTrue(((SearchCommand) cmd).getFirstOption() instanceof EmptyFirstOption);
        assertTrue(((SearchCommand) cmd).getSecondOption() instanceof LastNameOption);
        assertTrue(((SearchCommand) cmd).getThirdOption() instanceof NoneThirdOption);
        assertEquals(((SearchCommand) cmd).getSecondOption().getSearchColumn(), "name");
        assertEquals(((SearchCommand) cmd).getSecondOption().getSearchValue(), "KYUMOK KIM");
    }

    @Test
    public void serachCommandFailTest1() {
        String searchFailString = "SCH, , , ,name";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(searchFailString);
        });
        assertEquals("ERROR::Command format is wrong...", exception.getMessage());
    }

    @Test
    public void serachCommandFailTest2() {
        String searchFailString = "SCH, ,-a, ,name,KYUMOK KIM";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(searchFailString);
        });
        assertEquals("ERROR::Command option is wrong...", exception.getMessage());
    }

    @Test
    public void modifyCommandPassTest() throws Exception {
        String modifyPassString = "MOD, , , ,cl,CL3,phoneNum,010-9777-6055";
        CommandParser commandParser = new CommandParser();
        ICommand cmd = commandParser.parseToCommand(modifyPassString);
        assertTrue(cmd instanceof ModifyCommand);
        assertTrue(((ModifyCommand) cmd).getFirstOption() instanceof EmptyFirstOption);
        assertTrue(((ModifyCommand) cmd).getSecondOption() instanceof EmptySecondOption);
        assertTrue(((ModifyCommand) cmd).getThirdOption() instanceof NoneThirdOption);
        assertEquals(((ModifyCommand) cmd).getSecondOption().getSearchColumn(), "cl");
        assertEquals(((ModifyCommand) cmd).getSecondOption().getSearchValue(), "CL3");

        List<String> args = ((ModifyCommand) cmd).getCommandArguments();
        for (int i = 0 ; i < args.size() ; i ++){
            assertEquals(args.get(i), modifyPassString.split(",")[i+6]);
        }
    }

    @Test
    public void modifyCommandPassTest2() throws Exception {
        String modifyPassString = "MOD,-p,-m, ,phoneNum,9777,phoneNum,010-9777-6055";
        CommandParser commandParser = new CommandParser();
        ICommand cmd = commandParser.parseToCommand(modifyPassString);
        assertTrue(cmd instanceof ModifyCommand);
        assertTrue(((ModifyCommand) cmd).getFirstOption() instanceof PrintOption);
        assertTrue(((ModifyCommand) cmd).getSecondOption() instanceof MiddlePhoneNumberOption);
        assertTrue(((ModifyCommand) cmd).getThirdOption() instanceof NoneThirdOption);
        assertEquals(((ModifyCommand) cmd).getSecondOption().getSearchColumn(), "phoneNum");
        assertEquals(((ModifyCommand) cmd).getSecondOption().getSearchValue(), "9777");

        List<String> args = ((ModifyCommand) cmd).getCommandArguments();
        for (int i = 0 ; i < args.size() ; i ++){
            assertEquals(args.get(i), modifyPassString.split(",")[i+6]);
        }
    }

    @Test
    public void modifyCommandFailTest1() {
        String modifyFailString =  "MOD, , , ,cl,CL3,phoneNum";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(modifyFailString);
        });
        assertEquals("ERROR::Command format is wrong...", exception.getMessage());
    }

    @Test
    public void modifyCommandFailTest2() {
        String modifyFailString = "MOD,-a, , ,phoneNum,9777,phoneNum,010-9777-6055";
        CommandParser commandParser = new CommandParser();
        Throwable exception = assertThrows(Exception.class, () -> {
            ICommand cmd = commandParser.parseToCommand(modifyFailString);
        });
        assertEquals("ERROR::Command option is wrong...", exception.getMessage());
    }
}

