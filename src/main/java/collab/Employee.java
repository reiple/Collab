package collab;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Employee{
    private String employeeNumber;
    private String phoneNumber;
    private String name;
    private String birthday;
    private String careerLevel;
    private String certi;

    private String lastName;
    private String firstName;
    private int realEmployeeNumber;
    private String middlePhoneNumber;
    private String lastPhoneNumber;
    private String birthYearOnly;
    private String birthMonthOnly;
    private String birthDayOnly;

    private int currentYear = LocalDate.now().getYear();
    private int currentCentury = (currentYear/100)*100;
    private int lastCentury = currentCentury - 100;
    private int maxWorkYear = 80;

    public Employee(List<String> commandArguments) {
        employeeNumber = commandArguments.get(0);
        name = commandArguments.get(1);
        careerLevel = commandArguments.get(2);
        phoneNumber = commandArguments.get(3);
        birthday = commandArguments.get(4);
        certi = commandArguments.get(5);
        validateInput();
        dataProcessing();
    }

    private void dataProcessing(){
        processEmployeeNumber();
        processName();
        processPhoneNumber();
        processBirthday();
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

    private void processEmployeeNumber(){
        int employeeNumberYear = Integer.parseInt(employeeNumber.substring(0,2));
        int employeeNumberOther = Integer.parseInt(employeeNumber.substring(2));
        int realEmployeeYear = convertRealEmployeeYear(employeeNumberYear);
        realEmployeeNumber= realEmployeeYear*1000000 + employeeNumberOther;
    }

    private void processName(){
        firstName = name.split(" ")[0];
        lastName = name.split(" ")[1];
    }

    private void processPhoneNumber(){
        middlePhoneNumber = phoneNumber.split("-")[1];
        lastPhoneNumber = phoneNumber.split("-")[2];
    }

    private void processBirthday(){
        birthYearOnly = birthday.substring(0,4);
        birthMonthOnly = birthday.substring(4,6);
        birthDayOnly = birthday.substring(6);
    }

    public void setEmployeeNumber(String str) {
        employeeNumber = str;
        validateEmployeeNumber();
        processEmployeeNumber();
    }

    public void setPhoneNumber(String str) {
        phoneNumber = str;
        validatePhoneNumber();
        processPhoneNumber();
    }

    public void setName(String str) {
        name = str;
        validateName();
        processName();
    }

    public void setBirthday(String str) {
        birthday = str;
        validateBirthday();
        processBirthday();
    }

    public void setCareerLevel(String str) {
        careerLevel = str;
        validateCareerLevel();
    }

    public void setCerti(String str) {
        certi = str;
        validateCerti();
    }

    private void validateInput(){
        validateEmployeeNumber();
        validatePhoneNumber();
        validateName();
        validateBirthday();
        validateCareerLevel();
        validateCerti();
    }

    static boolean isDigit(String str){
        for (int i=0; i <str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    static boolean isUpper(String str){
        for (int i=0; i <str.length(); i++){
            if(!Character.isUpperCase(str.charAt(i))){
                return false;
            }
        }
        return true;
    }


    boolean isValidEmployeeYear(String str){
        int employeeNumberYear = Integer.parseInt(str.substring(0,2));
        int realEmployeeYear = convertRealEmployeeYear(employeeNumberYear);
        return (currentYear - realEmployeeYear) < maxWorkYear;
    }

    private void validateEmployeeNumber(){
        if (employeeNumber.length() != 8 || !isDigit(employeeNumber) || !isValidEmployeeYear(employeeNumber)){
            throw new RuntimeException("Employee number input is not valid");
        }
    }

    private void validatePhoneNumber(){
        if (phoneNumber.split("-").length != 3){
            throw new RuntimeException("Employee phone number input is not valid");
        }

        if (!phoneNumber.split("-")[0].equals("010")){
            throw new RuntimeException("Employee phone number input is not valid");
        }

        for (int i=1; i<3; i++){
            if(phoneNumber.split("-")[i].length() !=4 || !isDigit(phoneNumber.split("-")[i])){
                throw new RuntimeException("Employee phone number input is not valid");
            }
        }
    }

    private void validateName(){
        if (name.length() > 15 || name.split(" ").length != 2){
            throw new RuntimeException("Employee name input is not valid");
        }

        for (int i=0; i<2; i++){
            if (!isUpper(name.split(" ")[i])){
                throw new RuntimeException("Employee name input is not valid");
            }
        }
    }

    private void validateBirthday(){

    }

    private void validateCareerLevel(){
        List<String> careerLevelWhiteBox = Arrays.asList("CL1","CL2","CL3","CL4");
        if (!careerLevelWhiteBox.contains(careerLevel)){
            throw new RuntimeException("Employee career level input is not valid");
        }
    }

    private void validateCerti(){

    }

    public String getEmployeeNumber() { return employeeNumber; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getName() { return name; }
    public String getBirthday() { return birthday; }
    public String getCareerLevel() { return careerLevel; }
    public String getCerti() { return certi; }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public int getRealEmployeeNumber() { return realEmployeeNumber; }
    public String getMiddlePhoneNumber() { return middlePhoneNumber; }
    public String getLastPhoneNumber() { return lastPhoneNumber; }
    public String getBirthYearOnly() { return birthYearOnly; }
    public String getBirthMonthOnly() { return birthMonthOnly; }
    public String getBirthDayOnly() { return birthDayOnly; }

}