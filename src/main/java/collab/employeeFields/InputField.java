package collab.employeeFields;

public abstract class InputField extends Field<String>{
    public InputField(String inputColumn, String inputData) {
        super(inputColumn, inputData);
    }

    public abstract void validateData();
    public abstract void processData();
}
