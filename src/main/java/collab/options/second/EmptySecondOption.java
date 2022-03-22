package collab.options.second;

import collab.AbstractSecondOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.List;
import java.util.stream.Collectors;

public class EmptySecondOption extends AbstractSecondOption {
    public EmptySecondOption(List<String> optionArgument){
        super(optionArgument);
    }
    @Override
    public List<Employee> getFilteredList(EmployeeDAO dao) {
        // throws Exception 처리 이후 적용
//        return dao.getAllItems().stream()
//                .filter(item -> item.getStringField(getSearchColumn()).equals(getSearchValue()))
//                .collect(Collectors.toList());
        return null;
    }
}
