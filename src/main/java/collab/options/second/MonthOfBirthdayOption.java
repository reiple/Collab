package collab.options.second;

import collab.AbstractSearchOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;

public class MonthOfBirthdayOption extends AbstractSearchOption
{
    MonthOfBirthdayOption(List<String> optionArgument){
        super(optionArgument);
    }
    @Override
    public List<Employee> getFilteredList(EmployeeDAO DAO) {
        return null;
    }
}
