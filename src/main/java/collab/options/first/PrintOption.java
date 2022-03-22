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

        // TODO: inputList가 null인 경우에 대한 처리 필요

        // 사번 기준으로 sorting
        ArrayList<Employee> sortedList = new ArrayList<>();
        sortedList.addAll(inputList.stream()
                .sorted(Comparator.comparing(Employee::getRealEmployeeNumber))
                .limit(5)
                .collect(Collectors.toList()));
        if (sortedList.size() != 0 ) return makeResultString(sortedList, command.getName());
        return command.getName() + ",NONE";
    }

    private String makeResultString(List<Employee> sortedList, String cmd){
        String result = new String();
        boolean isFirst=true;
        for (Employee employee: sortedList){
            if(!isFirst) {result+=System.lineSeparator();}
            result += cmd + "," + employee.getEmployeeNumber() + ',' + employee.getName() + ',' + employee.getCareerLevel()
                    + ',' + employee.getPhoneNumber() + ',' + employee.getBirthday() + ',' + employee.getCerti();
            isFirst = false;
        }
        return result;
    }
}
