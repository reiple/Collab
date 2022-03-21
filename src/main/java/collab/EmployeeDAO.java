package collab;

import java.util.List;
import main.java.collab.DataBase;
import main.java.collab.Employee;
import main.java.collab.IDAO;

public class EmployeeDAO implements IDAO<Employee> {

  private DataBase db;
  
  @Override
  public void initDatabase() {
    // Employee Database 생성
    db = new DataBase();
  }

  @Override
  public void addItemFromStringTokens(List<String> itemTokens) throws Exception {
    addItem(new Employee(itemTokens));
  }

  @Override
  public void addItem(Employee item) throws Exception {
    db.add(item);
  }
  
  @Override
  public Employee getItemById(String id) {
    return db.searchItem(id);
  }

  @Override
  public List<Employee> getItemsByCondition(String field, String value) {
    return db.searchItems(field, value);
  }

  @Override
  public Employee modifyItem(Employee item) {
    return db.modifyItem(item);
  }

  @Override
  public Employee modifyItemById(String id, String field, String value) {
    return db.modifyItemById(id, field, value);
  }
  
  @Override
  public List<Employee> modifyItemByCondition(String sField, String sValue, String cField, String cValue) {
    return db.modifyItemByCondition(sField, sValue, cField, cValue);
  }

  @Override
  public Employee deleteItem(Employee item) {
    return db.deleteItem(item);
  }

  @Override
  public Employee deleteItemById(String id) {
    return db.deleteItemById(id);
  }
  
  @Override
  public List<Employee> deleteItemByCondition(String field, String value) {
    return db.deleteItemByCondition(field, value);
  }
  
  @Override
  public List<Employee> getAllItems() {
    return db.getEmployeeAllData();
  }
}
