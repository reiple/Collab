package collab.employeeFields;

import java.util.Arrays;
import java.util.List;

public class CertiField extends InputField {

    public CertiField(String inputColumn, String inputData) {
        super(inputColumn, inputData);
    }

    @Override
    public void validateData() {
        List<String> certiWhiteBox = Arrays.asList("ADV", "PRO", "EX");
        if (!certiWhiteBox.contains(data)) {
            throw new RuntimeException("Employee certi input is not valid");
        }
    }

    @Override
    public void processData() {

    }
}