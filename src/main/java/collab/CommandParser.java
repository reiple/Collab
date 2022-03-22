package collab;

import collab.options.first.EmptyFirstOption;
import collab.options.first.NoneFirstOption;
import collab.options.first.PrintOption;
import collab.options.second.*;
import collab.options.third.NoneThirdOption;

import java.util.*;

public class CommandParser {

    protected static final String ADD_COMMAND = "ADD";
    protected static final String SEARCH_COMMAND = "SCH";
    protected static final String MODIFY_COMMAND = "MOD";
    protected static final String DELETE_COMMAND = "DEL";
    protected static final List<String> WHITE_COMMAND_LIST = Arrays.asList(ADD_COMMAND, SEARCH_COMMAND, MODIFY_COMMAND, DELETE_COMMAND);
    protected static final List<String> FIRST_OPTION_WHITE_LIST = Arrays.asList(" ", "-p");
    protected static final Map<String, List<String>> SECOND_OPTION_WHITE_MAP = new HashMap<String, List<String>>(){{
        put("-f", Arrays.asList("name"));
        put("-l", Arrays.asList("name", "phoneNum"));
        put("-m", Arrays.asList("phoneNum", "birthday"));
        put("-y", Arrays.asList("birthday"));
        put("-d", Arrays.asList("birthday"));
    }};

    protected static final int ADD_CMD_LENGTH = 10;
    protected static final int SCH_CMD_LENGTH = 6;
    protected static final int MOD_CMD_LENGTH = 8;
    protected static final int DEL_CMD_LENGTH = 6;

    protected static final String ERR_MSG_CMD_INVALID = "ERROR::Command is invalid...";
    protected static final String ERR_MSG_FORMAT_WRONG = "ERROR::Command format is wrong...";
    protected static final String ERR_MSG_OPTION_WRONG = "ERROR::Command option is wrong...";



    public List<ICommand>  parseToCommandList(List<String> cmdStrList) throws Exception{
        List<ICommand> commandList = new ArrayList<ICommand>();
        for (String cmdStrLine : cmdStrList){
            commandList.add(parseToCommand(cmdStrLine));
        }
        return commandList;
    }
    public ICommand  parseToCommand(String cmdStr) throws Exception {
        String[] tokenList = cmdStr.split(",");
        checkValidation(tokenList);
        return getCommandFromToken(getFirstOptionFromToken(tokenList), getSecondOptionFromToken(tokenList), getThirdOptionFromToken(tokenList), tokenList);
    }
    private void checkValidation(String[] tokenList) throws Exception {
        if (tokenList.length < 1) throw new Exception(ERR_MSG_FORMAT_WRONG);
        if (!WHITE_COMMAND_LIST.contains(tokenList[0])) throw new Exception(ERR_MSG_CMD_INVALID);
        if (!FIRST_OPTION_WHITE_LIST.contains(tokenList[1])) throw new Exception(ERR_MSG_OPTION_WRONG);
        if (!tokenList[2].equals(" ")) checkSecondOptionValidation(tokenList);
        if (tokenList[0].equals(ADD_COMMAND)) checkAddCommandValidation(tokenList);
        if (tokenList[0].equals(SEARCH_COMMAND)) checkSearchCommandValidation(tokenList);
        if (tokenList[0].equals(MODIFY_COMMAND)) checkModifyCommandValidation(tokenList);
        if (tokenList[0].equals(DELETE_COMMAND)) checkDeleteCommandValidation(tokenList);
    }

    private void checkSecondOptionValidation(String[] tokenList) throws Exception{
        String secondOption = tokenList[2];
        String FirstArgument = tokenList[4];
        if (!SECOND_OPTION_WHITE_MAP.containsKey(secondOption)) throw new Exception(ERR_MSG_OPTION_WRONG);
        if(!SECOND_OPTION_WHITE_MAP.get(secondOption).contains(FirstArgument)) throw new Exception(ERR_MSG_OPTION_WRONG);
    }

    private void checkAddCommandValidation(String[] tokenList) throws Exception{
        if (tokenList.length != ADD_CMD_LENGTH) throw new Exception(ERR_MSG_FORMAT_WRONG);
        if (!tokenList[1].equals((" "))) throw new Exception(ERR_MSG_OPTION_WRONG);
        if (!tokenList[2].equals((" "))) throw new Exception(ERR_MSG_OPTION_WRONG);
    }

    private void checkSearchCommandValidation(String[] tokenList) throws Exception{
        if (tokenList.length != SCH_CMD_LENGTH) throw new Exception(ERR_MSG_FORMAT_WRONG);
    }

    private void checkModifyCommandValidation(String[] tokenList) throws Exception{
        if (tokenList.length != MOD_CMD_LENGTH) throw new Exception(ERR_MSG_FORMAT_WRONG);
    }

    private void checkDeleteCommandValidation(String[] tokenList) throws Exception{
        if (tokenList.length != DEL_CMD_LENGTH) throw new Exception(ERR_MSG_FORMAT_WRONG);
    }

    private AbstractFirstOption getFirstOptionFromToken(String[] tokenList){
        String firstOption = tokenList[1];
        if (firstOption.equals("-p")) return new PrintOption();
        return new EmptyFirstOption();
    }

    private AbstractSecondOption getSecondOptionFromToken(String[] tokenList){
        String secondOption = tokenList[2];
        String firstArgument = tokenList[4];
        String secondArgument = tokenList[5];
        List<String> optionArguments = Arrays.asList(firstArgument, secondArgument);
        if (secondOption.equals("-f")) return new FirstNameOption(optionArguments);
        if (secondOption.equals("-l")) return (firstArgument.equals("name") ?  new LastNameOption(optionArguments) : new LastPhoneNumberOption(optionArguments));
        if (secondOption.equals("-m")) return (firstArgument.equals("phoneNum") ?  new MiddlePhoneNumberOption(optionArguments) : new MonthOfBirthdayOption(optionArguments));
        if (secondOption.equals("-y")) return new YearOfBirthdayOption(optionArguments);
        if (secondOption.equals("-d")) return new DayOfBirthdayOption(optionArguments);
        return new EmptySecondOption(optionArguments);
    }

    private AbstractThirdOption getThirdOptionFromToken(String[] tokenList){
        return new NoneThirdOption();
    }

    ICommand getCommandFromToken(AbstractFirstOption FirstOption, AbstractSecondOption SecondOption, AbstractThirdOption ThirdOption, String[] tokenList) throws Exception {
        String command = tokenList[0];
        if (command.equals(ADD_COMMAND)) return new AddCommand(Arrays.asList(Arrays.copyOfRange(tokenList, 4, ADD_CMD_LENGTH)));
        if (command.equals(SEARCH_COMMAND)) return new SearchCommand(FirstOption, SecondOption);
        if (command.equals(MODIFY_COMMAND)) return new ModifyCommand(FirstOption, SecondOption, Arrays.asList(Arrays.copyOfRange(tokenList, 6, MOD_CMD_LENGTH-1)));
        if (command.equals(DELETE_COMMAND)) return new DeleteCommand(FirstOption, SecondOption);
        throw new Exception(ERR_MSG_CMD_INVALID);
    }
}
