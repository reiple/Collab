package collab.options.first;

import collab.AbstractFirstOption;
import collab.Employee;

import java.util.List;

public class NoneFirstOption  extends AbstractFirstOption {
    @Override
    public String getFilteredList(List<Employee> inputList) {
        return String.valueOf(inputList.size());
    }
}
