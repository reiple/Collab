package collab.employeeFields;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeNumberField extends InputField{
    private final int maxWorkYear = 80;
    private int realEmployeeNum;
    private int currentYear;
    private int currentCentury;
    private int lastCentury;


    public EmployeeNumberField(String inputColumn, String inputData) {
        super(inputColumn, inputData);

    }

    @Override
    public void validateData() {
        currentYear = LocalDate.now().getYear();
        currentCentury = (currentYear/100)*100;
        lastCentury = currentCentury - 100;

        if (data.length() != 8 || !isDigit(data) || !isValidEmployeeYear(data)){
            throw new RuntimeException("Employee number input is not valid");
        }
    }

    @Override
    public void processData() {
        int employeeNumberYear = Integer.parseInt(data.substring(0,2));
        int employeeNumberOther = Integer.parseInt(data.substring(2));
        int realEmployeeYear = convertRealEmployeeYear(employeeNumberYear);
        realEmployeeNum = realEmployeeYear*1000000 + employeeNumberOther;
    }

    private boolean isValidEmployeeYear(String str){

        int employeeNumberYear = Integer.parseInt(str.substring(0,2));
        int realEmployeeYear = convertRealEmployeeYear(employeeNumberYear);
        return (currentYear - realEmployeeYear) < maxWorkYear;
    }

    private int convertRealEmployeeYear(int employeeNumberYearInt){
        int realEmployeeNumberYearInt;

        if (employeeNumberYearInt <= (currentYear - currentCentury) && employeeNumberYearInt >= 0){
            realEmployeeNumberYearInt = currentCentury + employeeNumberYearInt;
        } else {
            realEmployeeNumberYearInt = lastCentury + employeeNumberYearInt;
        }
        return realEmployeeNumberYearInt;
    }

    public int getRealEmployeeNum(){ return realEmployeeNum; }
}
