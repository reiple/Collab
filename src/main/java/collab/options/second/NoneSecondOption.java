package collab.options.second;

import collab.AbstractSearchOption;
import collab.Employee;
import collab.EmployeeDAO;

import java.util.Collections;
import java.util.List;

public class NoneSecondOption  extends AbstractSearchOption {
    NoneSecondOption(){
        super(Collections.emptyList());
    }

    @Override
    public List<Employee> getFilteredList(EmployeeDAO DAO) {
        return null;
    }
}
