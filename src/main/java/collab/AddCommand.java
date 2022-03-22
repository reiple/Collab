package collab;

import collab.options.first.NoneFirstOption;
import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;

import java.util.List;

public class AddCommand extends AbstractCommand{
    public AddCommand(List<String> commandArguments) {
        super(new NoneFirstOption(), new NoneSecondOption(), new NoneThirdOption(), commandArguments);
    }

    @Override
    public String executeCommand(IDAO dao) throws Exception {
        dao.addItem(new Employee(getCommandArguments()));
        return "NONE";
    }
}
