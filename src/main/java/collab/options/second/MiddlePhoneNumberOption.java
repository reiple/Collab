package collab.options.second;

import collab.AbstractSearchOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;

public class MiddlePhoneNumberOption extends AbstractSearchOption
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
