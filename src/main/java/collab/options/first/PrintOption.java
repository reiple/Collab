package collab.options.first;

import collab.AbstractFirstOption;
import collab.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintOption extends AbstractFirstOption {
    @Override
    public String getFilteredList(List<Employee> inputList) {
        // 사번 기준으로 sorting
        ArrayList<Employee> sortedList = new ArrayList<>();
        sortedList.addAll(inputList.stream()
                .sorted(Comparator.comparing(Employee::getRealEmployeeNumber))
                .limit(5)
                .collect(Collectors.toList()));
        if (sortedList.size() != 0 ) return makeResultString(sortedList);
        return null;
    }

    private String makeResultString(List<Employee> sortedList){
        String result = new String();
        for (Employee employee: sortedList){
            result += employee.getEmployeeNumber() + ',' + employee.getName() + ',' + employee.getCareerLevel()
                    + ',' + employee.getPhoneNumber() + ',' + employee.getBirthday() + ',' + employee.getCerti() + '\n';
        }
        return result;
    }
}
