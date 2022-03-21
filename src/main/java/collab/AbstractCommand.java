package collab;

import java.util.List;

public abstract class AbstractCommand implements ICommand{
    private AbstractFirstOption option1;
    private AbstractSecondOption option2;
    private AbstractThirdOption option3;
    private List<String> commandArguments;


    public AbstractCommand(AbstractFirstOption option1, AbstractSecondOption option2, AbstractThirdOption option3, List<String> commandArguments){
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.commandArguments = commandArguments;
    }

    public AbstractFirstOption getFirstOption(){
        return this.option1;
    }

    public AbstractSecondOption getSecondOption(){
        return this.option2;
    }

    public AbstractThirdOption getThirdOption(){
        return this.option3;
    }

    public List<String> getCommandArguments(){
        return this.commandArguments;
    }

    @Override
    public abstract String executeCommand(EmployeeDAO dao);

}
