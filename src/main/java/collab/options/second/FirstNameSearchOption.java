package collab.options.second;

import collab.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstNameSearchOption {

  private List<String> conditionList;
  private ArrayList<Employee> dao;

  public FirstNameSearchOption(String... conditions) {
    conditionList = Arrays.asList(conditions);
  }

  public void setDao(ArrayList<Employee> dao) {
    this.dao = dao;
  }

  public ArrayList<Employee> getFilterList() {

    // TODO: Mock으로 lambda 어떻게 해야 할지 몰라서 for문으로 변경했습니다. 나중에 lamba로 고칠 것
//    return (ArrayList<Employee>) dao.stream()
//        .filter(name -> name.getFirstName().compareTo(conditionList.get(1)) == 0)
//        .collect(Collectors.toList());

    ArrayList<Employee> list = new ArrayList<>();
    for(int index = 0; index < dao.size(); index++) {
      String firstName = dao.get(index).getFirstName();
      if(firstName.compareTo(conditionList.get(1)) == 0) {
        list.add(dao.get(index));
      }
    }

    return list;
  }

}
