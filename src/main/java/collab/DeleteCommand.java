package collab;

import collab.options.third.NoneThirdOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteCommand extends AbstractCommand {

    public DeleteCommand(AbstractFirstOption option1, AbstractSecondOption option2) {
        super(option1, option2, new NoneThirdOption(), Collections.emptyList());
    }

    @Override
    public String executeCommand(IDAO dao) throws Exception {

        List<Employee> list = null;
        list = getSecondOption().getFilteredList((EmployeeDAO) dao);
        if (list == null) {
            list = new ArrayList<>();
        }

        list.stream().forEach(employee -> ((EmployeeDAO) dao).deleteItemById(employee.getEmployeeNumber()));

        return getFirstOption().getFilteredList(list);

    }
}
