package collab;

import collab.options.third.NoneThirdOption;

import java.util.List;

public class ModifyCommand extends AbstractCommand{
    ModifyCommand(AbstractFirstOption option1, AbstractSecondOption option2, List<String> commandArguments) {
        super(option1, option2, new NoneThirdOption(), commandArguments);
    }

    @Override
    public String executeCommand(EmployeeDAO dao) {
        return null;
    }
}
