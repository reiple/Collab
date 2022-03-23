package collab.employeeFields;

public abstract class InputField implements InterfaceInputField {

    protected String data;
    private String fieldName;

    public InputField(String inputField, String inputData) {
        fieldName = inputField;
        data = inputData;
        validateData();
        processData();
    }

    static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean isUpper(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isUpperCase(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public void setData(String input) {
        data = input;
        validateData();
        processData();
    }

    public String getData() {
        return data;
    }

    public String getFieldName() {
        return fieldName;
    }
}
