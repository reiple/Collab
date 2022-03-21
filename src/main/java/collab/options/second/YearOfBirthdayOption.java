package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;
import java.util.stream.Collectors;

public class YearOfBirthdayOption extends AbstractSecondOption
{
    YearOfBirthdayOption(List<String> optionArgument){
        super(optionArgument);
    }
    @Override
    public List<Employee> getFilteredList(EmployeeDAO employeeDAO) {

        return employeeDAO.getAll().stream()
            .filter(item -> item.getBirthYearOnly().equals(getSearchValue()))
            .collect(Collectors.toList());

    }

}
