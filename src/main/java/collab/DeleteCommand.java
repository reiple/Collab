package collab;

import java.util.List;

public class DeleteCommand extends AbstractCommand{
    DeleteCommand(AbstractFirstOption option1, AbstractSecondOption option2, AbstractThirdOption option3, List<String> commandArguments) {
        super(option1, option2, option3, commandArguments);
    }

    @Override
    public String executeCommand(EmployeeDAO dao) {
        return null;
    }
}
