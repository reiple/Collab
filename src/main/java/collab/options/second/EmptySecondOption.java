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

        List<Employee> list = null;
        switch(getSearchColumn()) {
            case "employeeNum":
                list = dao.getAllItems().stream()
                    .filter(item -> item.getEmployeeNumber().equals(getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "name":
                list = dao.getAllItems().stream()
                    .filter(item -> item.getName().equals(getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "cl":
                list = dao.getAllItems().stream()
                    .filter(item -> item.getCareerLevel().equals(getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "phoneNum":
                list = dao.getAllItems().stream()
                    .filter(item -> item.getPhoneNumber().equals(getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "birthday":
                list = dao.getAllItems().stream()
                    .filter(item -> item.getBirthday().equals(getSearchValue()))
                    .collect(Collectors.toList());
                break;
            case "certi":
                list = dao.getAllItems().stream()
                    .filter(item -> item.getCerti().equals(getSearchValue()))
                    .collect(Collectors.toList());
                break;
        }
        return list;
    }
}
