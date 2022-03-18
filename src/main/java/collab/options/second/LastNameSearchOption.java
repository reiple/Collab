package collab.options.second;

import collab.Employee;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastNameSearchOption {

  private List<String> conditionList;
  private ArrayList<Employee> dao;

  public LastNameSearchOption(String... conditionList) {
    this.conditionList = Arrays.asList(conditionList);
  }

  public ArrayList<Employee> getFilterList() {
    ArrayList<Employee> list = new ArrayList<>();
    for(int index = 0; index < dao.size(); index++) {
      String lastName = dao.get(index).getLastName();
      if(lastName.compareTo(conditionList.get(1)) == 0) {
        list.add(dao.get(index));
      }
    }

    return list;
  }

  public void setDao(ArrayList<Employee> list) {
    this.dao = list;
  }
}
