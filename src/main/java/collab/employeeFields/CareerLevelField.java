package collab.employeeFields;

import java.util.Arrays;
import java.util.List;

public class CareerLevelField extends InputField{
    private List<String> careerLevelWhiteBox = Arrays.asList("CL1","CL2","CL3","CL4");

    public CareerLevelField(String inputColumn, String inputData) {
        super(inputColumn, inputData);
    }

    @Override
    public void validateData() {

        if (!careerLevelWhiteBox.contains(data)){
            throw new RuntimeException("Employee career level input is not valid");
        }
    }

    @Override
    public void processData() {

    }
}