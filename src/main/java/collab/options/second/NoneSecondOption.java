package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.Collections;
import java.util.List;

public class NoneSecondOption extends AbstractSecondOption {

    public NoneSecondOption() {
        super(Collections.emptyList());
    }

    public NoneSecondOption(List<String> commandArguments) {
        super(commandArguments);
    }

    @Override
    public List<Employee> getFilteredList(EmployeeDAO DAO) {
        return null;
    }
}
