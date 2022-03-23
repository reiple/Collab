package collab.employeeFields;

public class NameField extends InputField {

    private String firstName;
    private String lastName;

    public NameField(String inputColumn, String inputData) {
        super(inputColumn, inputData);
    }

    @Override
    public void validateData() {
        if (data.length() > 15 || data.split(" ").length != 2) {
            throw new RuntimeException("Employee name input is not valid");
        }

        for (int i = 0; i < 2; i++) {
            if (!isUpper(data.split(" ")[i])) {
                throw new RuntimeException("Employee name input is not valid");
            }
        }
    }

    @Override
    public void processData() {
        firstName = data.split(" ")[0];
        lastName = data.split(" ")[1];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}