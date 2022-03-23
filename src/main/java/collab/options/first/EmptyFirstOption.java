package collab.options.first;

import collab.AbstractCommand;
import collab.AbstractFirstOption;
import collab.Employee;

import java.util.List;

public class EmptyFirstOption extends AbstractFirstOption {

    @Override
    public String getFilteredList(List<Employee> inputList, AbstractCommand command) {
        if (inputList.size() > 0) {
            return command.getName() + "," + inputList.size();
        }
        return command.getName() + ",NONE";
    }
}
