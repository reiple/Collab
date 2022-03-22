package collab;


import collab.options.first.NoneFirstOption;
import collab.options.second.FirstNameOption;
import collab.options.second.LastNameOption;
import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SearchCommand extends AbstractCommand{
    public SearchCommand(AbstractFirstOption option1, AbstractSecondOption option2) {
        super(option1, option2, new NoneThirdOption(), Collections.emptyList());
    }

    @Override
    public String executeCommand(IDAO employeeDAO) {

//        if(getSecondOption() instanceof NoneSecondOption) {
//            return getSearchName((EmployeeDAO) employeeDAO);
//        }
        List<Employee> list = getSecondOption().getFilteredList((EmployeeDAO) employeeDAO);

        // TODO: 임시로 조치한 것
        if(list == null) {
            list = new ArrayList<>();
        }

        return getFirstOption().getFilteredList(list);
    }

    private String getSearchName(EmployeeDAO employeeDAO) {
        List<Employee> list = employeeDAO.getAllItems().stream()
            .filter(item -> item.getName().equals(getSecondOption().getSearchValue()))
            .collect(Collectors.toList());

        return getFirstOption().getFilteredList(list);
    }
}
