package collab;

import java.util.List;

public abstract class AbstractFirstOption {
    abstract public String getFilteredList(List<Employee> inputList, AbstractCommand command) throws Exception;
}
