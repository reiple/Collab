package collab.employeeFields;

public class PhoneNumberField extends InputField {

    private String middlePhoneNumber;
    private String lastPhoneNumber;

    public PhoneNumberField(String inputColumn, String inputData) {
        super(inputColumn, inputData);
    }

    @Override
    public void validateData() {
        if (data.split("-").length != 3) {
            throw new RuntimeException("Employee phone number input is not valid");
        }

        if (!data.split("-")[0].equals("010")) {
            throw new RuntimeException("Employee phone number input is not valid");
        }

        for (int i = 1; i < 3; i++) {
            if (data.split("-")[i].length() != 4 || !isDigit(data.split("-")[i])) {
                throw new RuntimeException("Employee phone number input is not valid");
            }
        }
    }

    @Override
    public void processData() {
        middlePhoneNumber = data.split("-")[1];
        lastPhoneNumber = data.split("-")[2];
    }

    public String getMiddlePhoneNumber() {
        return middlePhoneNumber;
    }

    public String getLastPhoneNumber() {
        return lastPhoneNumber;
    }
}
