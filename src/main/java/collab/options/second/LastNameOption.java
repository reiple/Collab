package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;
import java.util.stream.Collectors;

public class LastNameOption extends AbstractSecondOption {

    public LastNameOption(List<String> optionArgument) {
        super(optionArgument);
    }

    @Override
    public List<Employee> getFilteredList(EmployeeDAO employeeDAO) {

        return employeeDAO.getAllItems().stream()
            .filter(item -> item.getLastName().equals(getSearchValue()))
            .collect(Collectors.toList());
    }
}
