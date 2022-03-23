package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;
import java.util.stream.Collectors;

public class MiddlePhoneNumberOption extends AbstractSecondOption {

    public MiddlePhoneNumberOption(List<String> optionArgument) {
        super(optionArgument);
    }

    @Override
    public List<Employee> getFilteredList(EmployeeDAO dao) {

        return dao.getAllItems().stream()
            .filter(item -> item.getMiddlePhoneNumber().equals(optionArgument.get(VAL)))
            .collect(Collectors.toList());
    }
}
