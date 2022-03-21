package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;
import java.util.stream.Collectors;

public class MiddlePhoneNumberOption extends AbstractSecondOption
{
    MiddlePhoneNumberOption(List<String> optionArgument){
        super(optionArgument);
    }
    @Override
    public List<Employee> getFilteredList(EmployeeDAO dao) {

        return dao.getAll().stream()
            .filter(item -> item.getMiddlePhoneNumber().equals(optionArgument.get(VAL)))
            .collect(Collectors.toList());
    }
}
