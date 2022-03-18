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

    public void setEmployeeNumber(String str) { employeeNumber = str; }
    public void setPhoneNumber(String str) { phoneNumber = str; }
    public void setName(String str) { name = str; }
    public void setBirthday(String str) { birthday = str; }
    public void setCareerLevel(String str) { careerLevel = str; }
    public void setCerti(String str) { certi = str; }

    public void setLastName(String str) { lastName = str; }
    public void setFirstName(String str) { firstName = str; }
    public void setRealEmployeeNumber(int num) { realEmployeeNumber = num; }
    public void setMiddlePhoneNumber(String str) { middlePhoneNumber = str; }
    public void setLastPhoneNumber(String str) { lastPhoneNumber = str; }
    public void setBirthYearOnly(String str) { birthYearOnly = str; }
    public void setBirthMonthOnly(String str) { birthMonthOnly = str; }
    public void setBirthDayOnly(String str) { birthDayOnly = str; }

}


