package collab;
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

    public Employee(List<String> commandArguments) {
        employeeNumber = commandArguments.get(0);
        name = commandArguments.get(1);
        careerLevel = commandArguments.get(2);
        phoneNumber = commandArguments.get(3);
        birthday = commandArguments.get(4);
        certi = commandArguments.get(5);
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
        int currentYear = 2022;
        int currentCentury = 2000;
        int lastCentury = 1900;

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
        processEmployeeNumber();
    }

    public void setPhoneNumber(String str) {
        phoneNumber = str;
        processPhoneNumber();
    }

    public void setName(String str) {
        name = str;
        processName();
    }

    public void setBirthday(String str) {
        birthday = str;
        processBirthday();
    }

    public void setCareerLevel(String str) { careerLevel = str; }
    public void setCerti(String str) { certi = str; }

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


