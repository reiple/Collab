package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;

public class LastPhoneNumberOption extends AbstractSecondOption
{
    LastPhoneNumberOption(List<String> optionArgument){
        super(optionArgument);
    }
    @Override
    public List<Employee> getFilteredList(EmployeeDAO DAO) {
        // Example
         //return DAO.getAll().stream().filter(item -> item.get("Last" + getSearchColumn()).equals(getSearchValue())).collect(Collectors.toList());
        return null;
    }
}
