package collab;

import collab.options.third.NoneThirdOption;

import java.util.Collections;
import java.util.List;

public class DeleteCommand extends AbstractCommand{
    public DeleteCommand(AbstractFirstOption option1, AbstractSecondOption option2) {
        super(option1, option2, new NoneThirdOption(), Collections.emptyList());
    }

    @Override
    public String executeCommand(IDAO dao) {
        return null;
    }
}
