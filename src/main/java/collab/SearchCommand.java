package collab;

import java.util.List;

public class SearchCommand extends AbstractCommand{
    SearchCommand(AbstractFirstOption option1, AbstractSearchOption option2, AbstractThirdOption option3, List<String> commandArguments) {
        super(option1, option2, option3, commandArguments);
    }

    @Override
    public String executeCommand(EmployeeDAO dao) {
        return null;
    }
}
