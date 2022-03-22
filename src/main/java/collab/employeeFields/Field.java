package collab.employeeFields;

public class Field <T> {
    private T data;
    private String fieldName;

    public Field(String inputColumn, T inputData){
        fieldName = inputColumn;
        data = inputData;
    }

    T getData() {
        return data;
    }

    void setData(T inputData){
        data = inputData;
    }
}
