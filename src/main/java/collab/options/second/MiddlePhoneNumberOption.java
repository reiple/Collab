package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MiddlePhoneNumberOption extends AbstractSecondOption
{
    MiddlePhoneNumberOption(List<String> optionArgument){
        super(optionArgument);
    }
    @Override
    public List<Employee> getFilteredList(EmployeeDAO DAO) {
        // Example
         //return DAO.getAll().stream().filter(item -> item.get("Middle" + getSearchColumn()).equals(getSearchValue())).collect(Collectors.toList());
        return null;
    }
}
