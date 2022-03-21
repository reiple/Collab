package collab;

import collab.options.first.NoneFirstOption;
import collab.options.second.FirstNameOption;
import collab.options.second.LastNameOption;
import collab.options.second.NoneSecondOption;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCommand extends AbstractCommand{
    SearchCommand(AbstractFirstOption option1, AbstractSecondOption option2, AbstractThirdOption option3, List<String> commandArguments) {
        super(option1, option2, option3, commandArguments);
    }

    @Override
    public String executeCommand(EmployeeDAO employeeDAO) {

        if(getSecondOption() instanceof NoneSecondOption) {
            return getSearchName(employeeDAO);
        }


        List<Employee> list = getSecondOption().getFilteredList(employeeDAO);
        System.out.println("SECOND: " + list.size());

        return getFirstOption().getFilteredList(list);
    }

    private String getSearchName(EmployeeDAO employeeDAO) {
        List<Employee> list = employeeDAO.getAll().stream()
            .filter(item -> item.getName().equals(getCommandArguments().get(1)))
            .collect(Collectors.toList());

        return getFirstOption().getFilteredList(list);
    }
}
