package collab.options.first;

import collab.AbstractCommand;
import collab.AbstractFirstOption;
import collab.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintOption extends AbstractFirstOption {

    @Override
    public String getFilteredList(List<Employee> inputList, AbstractCommand command) {
        ArrayList<Employee> sortedList = new ArrayList<>();
        sortedList.addAll(inputList.stream()
            .sorted(Comparator.comparing(Employee::getRealEmployeeNumber))
            .limit(5)
            .collect(Collectors.toList()));
        if (sortedList.size() != 0) {
            return makeResultString(sortedList, command.getName());
        }
        return command.getName() + ",NONE";
    }

    private String makeResultString(List<Employee> sortedList, String cmd) {
        List<String> resultList = new ArrayList<String>();

        for (Employee employee : sortedList) {
            resultList.add(cmd + "," + employee.getEmployeeNumber() + ',' + employee.getName() + ','
                + employee.getCareerLevel()
                + ',' + employee.getPhoneNumber() + ',' + employee.getBirthday() + ','
                + employee.getCerti());
        }
        return String.join(System.lineSeparator(), resultList);
    }
}
