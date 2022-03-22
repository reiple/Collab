package collab;

import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DeleteCommand extends AbstractCommand{
    public DeleteCommand(AbstractFirstOption option1, AbstractSecondOption option2) {
        super(option1, option2, new NoneThirdOption(), Collections.emptyList());
    }

    @Override
    public String executeCommand(IDAO dao) {

        List<Employee> list = null;
        if(getSecondOption() instanceof NoneSecondOption) {
            switch(getSecondOption().getSearchColumn()) {
                case "employeeNum":
                    list = dao.getAllItems().stream()
                        .filter(item -> item.getEmployeeNumber().equals(getSecondOption().getSearchValue()))
                        .collect(Collectors.toList());
                    break;
                case "name":
                    list = dao.getAllItems().stream()
                        .filter(item -> item.getName().equals(getSecondOption().getSearchValue()))
                        .collect(Collectors.toList());
                    break;
                case "cl":
                    list = dao.getAllItems().stream()
                        .filter(item -> item.getCareerLevel().equals(getSecondOption().getSearchValue()))
                        .collect(Collectors.toList());
                    break;
                case "phoneNum":
                    list = dao.getAllItems().stream()
                        .filter(item -> item.getPhoneNumber().equals(getSecondOption().getSearchValue()))
                        .collect(Collectors.toList());
                    break;
                case "birthday":
                    list = dao.getAllItems().stream()
                        .filter(item -> item.getBirthday().equals(getSecondOption().getSearchValue()))
                        .collect(Collectors.toList());
                    break;
                case "certi":
                    list = dao.getAllItems().stream()
                        .filter(item -> item.getCerti().equals(getSecondOption().getSearchValue()))
                        .collect(Collectors.toList());
                    break;
            }
        } else {
            list = getSecondOption().getFilteredList(dao);
        }

        //TODO: dao의 delete를 호출

        return getFirstOption().getFilteredList(list);
    }
}
