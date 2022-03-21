package collab;

import java.util.List;

public class EmployeeDAO implements IDAO<Employee> {

  @Override
  public void initDatabase() {
    // Employee Database 생성
  }

  @Override
  public void addItemFromStringTokens(List<String> itemTokens) throws Exception {

  }

  @Override
  public void addItem(Employee item) throws Exception {

  }

  @Override
  public void modifyItem(Employee item) {

  }

  @Override
  public void modifyItemById(String Id, String field, String value) {

  }

  @Override
  public Employee getItemById(String id) {
    return null;
  }

  @Override
  public List<Employee> getItemsByCondition(String field, String value) {
    return null;
  }

  @Override
  public List<Employee> getAllItems() {
    return null;
  }
}
