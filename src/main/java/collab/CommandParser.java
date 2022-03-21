package collab;

import java.util.List;

public class CommandParser {
    public List<ICommand>  parseToCommandList(List<String> cmdStrList){
        for (String cmdStrLine : cmdStrList){
            String[] tokenList = cmdStrLine.split(",");
            //getCommandFromToken(getFirstOptionFromToken(tokenList), getSecondOptionFromToken(tokenList), getThirdOptionFromToken(tokenList), tokenList);
        }
        return null;
    }
    public ICommand  parseToCommand(String cmdStr){
        String[] tokenList = cmdStr.split(",");
        checkValidation(tokenList);
        //return getCommandFromToken(getFirstOptionFromToken(tokenList), getSecondOptionFromToken(tokenList), getThirdOptionFromToken(tokenList), tokenList);
        return new AddCommand(null, null, null, null);
    }
    private void checkValidation(String[] tokenList){

    }
    private AbstractFirstOption getFirstOptionFromToken(String[] tokenList){
        return null;
    }

    private AbstractSecondOption getSecondOptionFromToken(String[] tokenList){
        return null;
    }

    private AbstractThirdOption getThirdOptionFromToken(String[] tokenList){
        return null;
    }

    ICommand getCommandFromToken(AbstractFirstOption FirstOption, AbstractSecondOption SecondOption, AbstractThirdOption ThirdOption, String[] tokenList){
        return null;
    }
}
