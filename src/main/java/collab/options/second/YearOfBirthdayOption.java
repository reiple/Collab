package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;

public class YearOfBirthdayOption extends AbstractSecondOption
{
    public YearOfBirthdayOption(List<String> optionArgument){
        super(optionArgument);
    }
    @Override
    public List<Employee> getFilteredList(EmployeeDAO DAO) {
        return null;
    }
}
