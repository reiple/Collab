package collab;

import collab.options.third.NoneThirdOption;

import java.util.ArrayList;
import java.util.List;

public class ModifyCommand extends AbstractCommand {

    public ModifyCommand(AbstractFirstOption option1, AbstractSecondOption option2,
        List<String> commandArguments) {
        super(option1, option2, new NoneThirdOption(), commandArguments);
    }

    @Override
    public String executeCommand(IDAO employeeDAO) throws Exception {

        List<Employee> list = getSecondOption().getFilteredList((EmployeeDAO) employeeDAO);
        if (list == null) {
            list = new ArrayList<>();
        }

        List<Employee> resultList = new ArrayList<>();
        list.forEach(employee ->
            resultList.add(((EmployeeDAO) employeeDAO).modifyItemById(employee.getEmployeeNumber(),
                getCommandArguments().get(0), getCommandArguments().get(1))));

        return getFirstOption().getFilteredList(resultList, this);
    }

    @Override
    public String getName() {
        return "MOD";
    }
}
