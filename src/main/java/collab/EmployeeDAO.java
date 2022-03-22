package collab;

import java.util.List;

public class EmployeeDAO implements IDAO<Employee> {

  private DataBase dbo = new DataBase();
  
  @Override
  public void initDatabase() {
    dbo = new DataBase();
  }

  @Override
  public void addItemFromStringTokens(List<String> itemTokens) throws Exception {
    addItem(new Employee(itemTokens));
  }

  @Override
  public void addItem(Employee item) throws Exception {
    dbo.add(item);
  }
  
  @Override
  public Employee getItemById(String id) {
    return dbo.searchItem(id);
  }

  @Override
  public List<Employee> getItemsByCondition(String field, String value) {
    return dbo.searchItems(field, value);
  }

  @Override
  public Employee modifyItem(Employee item) {
    return dbo.modifyItem(item);
  }

  @Override
  public Employee modifyItemById(String id, String field, String value) {
    return dbo.modifyItemById(id, field, value);
  }
  
  @Override
  public List<Employee> modifyItemByCondition(String sField, String sValue, String cField, String cValue) {
    return dbo.modifyItemByCondition(sField, sValue, cField, cValue);
  }

  @Override
  public Employee deleteItem(Employee item) {
    return dbo.deleteItem(item);
  }

  @Override
  public Employee deleteItemById(String id) {
    return dbo.deleteItemById(id);
  }
  
  @Override
  public List<Employee> deleteItemByCondition(String field, String value) {
    return dbo.deleteItemByCondition(field, value);
  }
  
  @Override
  public List<Employee> getAllItems() {
    return dbo.getEmployeeAllData();
  }
}
