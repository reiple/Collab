package collab;

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
    public String executeCommand(IDAO employeeDAO) throws Exception {

        List<Employee> list = getSecondOption().getFilteredList((EmployeeDAO) employeeDAO);

        // TODO: 임시로 조치한 것
        if(list == null) {
            list = new ArrayList<>();
        }

        return getFirstOption().getFilteredList(list, this);
    }

    @Override
    public String getName() {
        return "SCH";
    }

    private List<Employee> getSearchEmployeeList(EmployeeDAO employeeDAO) {
        List<Employee> list = null;
        switch(getSecondOption().getSearchColumn()) {
            case "employeeNum":
                list = employeeDAO.getAllItems().stream()
                    .filter(item -> item.getEmployeeNumber().equals(getSecondOption().getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "name":
                list = employeeDAO.getAllItems().stream()
                    .filter(item -> item.getName().equals(getSecondOption().getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "cl":
                list = employeeDAO.getAllItems().stream()
                    .filter(item -> item.getCareerLevel().equals(getSecondOption().getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "phoneNum":
                list = employeeDAO.getAllItems().stream()
                    .filter(item -> item.getPhoneNumber().equals(getSecondOption().getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "birthday":
                list = employeeDAO.getAllItems().stream()
                    .filter(item -> item.getBirthday().equals(getSecondOption().getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "certi":
                list = employeeDAO.getAllItems().stream()
                    .filter(item -> item.getCerti().equals(getSecondOption().getSearchValue()))
                    .collect(Collectors.toList());
                break;
        }
        return list;
    }

}
