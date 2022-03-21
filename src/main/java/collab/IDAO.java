package collab;
import java.util.List;

public interface IDAO<T> {
    void initDatabase();
    void addItemFromStringTokens(List<String> itemTokens) throws Exception;
    void addItem(T item) throws Exception;
    void modifyItem(T item);
    // 우선 single field 수정만 고려.
    void modifyItemById(String Id, String field, String value);
    T getItemById(String id);
    // 우선 single field condition 만 고려
    List<T> getItemsByCondition(String field, String value);
    List<T> getAllItems();
}
