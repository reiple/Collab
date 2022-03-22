package collab;
import java.util.List;

public interface IDAO<T> {
  void initDatabase();
  void addItemFromStringTokens(List<String> itemTokens) throws Exception;
  void addItem(T item) throws Exception;
  T modifyItem(T item);
  // 우선 single field 수정만 고려.
  T modifyItemById(String Id, String field, String value);
  List<T> modifyItemByCondition(String sField, String sValue, String cField, String cValue);
  T deleteItem(T item);
  T deleteItemById(String Id);
  T getItemById(String id);
  List<T> deleteItemByCondition(String field, String value);
  // 우선 single field condition 만 고려
  List<T> getItemsByCondition(String field, String value);
  List<T> getAllItems();
}

