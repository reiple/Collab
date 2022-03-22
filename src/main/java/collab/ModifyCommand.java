package collab;

import collab.options.second.NoneSecondOption;
import collab.options.third.NoneThirdOption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyCommand extends AbstractCommand{
    public ModifyCommand(AbstractFirstOption option1, AbstractSecondOption option2, List<String> commandArguments) {
        super(option1, option2, new NoneThirdOption(), commandArguments);
    }

    @Override
    public String executeCommand(IDAO employeeDAO) {

        if(getSecondOption() instanceof NoneSecondOption) {
            return getValues(employeeDAO);
        }

        List<Employee> list = new ArrayList<>();
        list = getSecondOption().getFilteredList(employeeDAO);
        String result = getFirstOption().getFilteredList(list);

        List<String> commandArguments = getCommandArguments();
        list.stream()
            .forEach(employee ->
                employeeDAO.modifyItemById(employee.getEmployeeNumber(), commandArguments.get(2), commandArguments.get(3)));

        return getFirstOption().getFilteredList(list);
    }

    private String getValues(EmployeeDAO employeeDAO) {
        List<Employee> list = employeeDAO.getAllItems().stream()
            .filter(item -> item.getPhoneNumber().equals(getCommandArguments().get(1)))
            .collect(Collectors.toList());

        return getFirstOption().getFilteredList(list);
    }
}
