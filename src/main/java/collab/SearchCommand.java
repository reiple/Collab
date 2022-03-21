package collab;


import collab.options.first.NoneFirstOption;
import collab.options.second.FirstNameOption;
import collab.options.second.LastNameOption;
import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCommand extends AbstractCommand{
    public SearchCommand(AbstractFirstOption option1, AbstractSecondOption option2) {
        super(option1, option2, new NoneThirdOption(), Collections.emptyList());
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
