package collab.options.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyNameSearchOption {

  private List<String> conditionList;
  private ArrayList<String> dao;

  public FamilyNameSearchOption(String... conditions) {
    conditionList = Arrays.asList(conditions);
  }

  public void setDao(ArrayList<String> dao) {
    this.dao = dao;
  }

  public List<String> getFilterList() {

    // TODO: Mock으로 lambda 어떻게 해야 할지 몰라서 for문으로 변경했습니다. 나중에 lamba로 고칠 것
//    return dao.stream().filter(
//        name -> (name.split(" ")[1].compareTo(conditionList.get(1))) == 0)
//        .collect(Collectors.toList());
    List<String> list = new ArrayList<>();
    for(int index = 0; index < dao.size(); index++) {
      String familyName = dao.get(index).split(" ")[1];
      if(familyName.compareTo(conditionList.get(1)) == 0) {
        list.add(dao.get(index));
      }
    }
    return list;
  }

}
