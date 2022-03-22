package collab;

import collab.employeeFields.*;

import java.util.*;

public class Employee{
    // column명도 바로 받을수 있으면 좋을것 같습니다.
    private final String employeeNumberFieldName = "employeeNum";
    private final String nameFieldName = "name";
    private final String careerLevelFieldName = "cl";
    private final String phoneNumberFieldName = "phoneNum";
    private final String birthdayFieldName = "birthday";
    private final String certiFieldName = "certi";

    private HashMap<String, InputField> fieldHashMap = new HashMap<String, InputField>();
    public Employee(List<String> commandArguments) {
        fieldHashMap.put(employeeNumberFieldName, new EmployeeNumberField(employeeNumberFieldName, commandArguments.get(0)));
        fieldHashMap.put(nameFieldName, new NameField(nameFieldName, commandArguments.get(1)));
        fieldHashMap.put(careerLevelFieldName, new CareerLevelField(careerLevelFieldName, commandArguments.get(2)));
        fieldHashMap.put(phoneNumberFieldName, new PhoneNumberField(phoneNumberFieldName, commandArguments.get(3)));
        fieldHashMap.put(birthdayFieldName, new BirthdayField(birthdayFieldName, commandArguments.get(4)));
        fieldHashMap.put(certiFieldName, new CertiField(certiFieldName, commandArguments.get(5)));
    }

    public void setEmployeeNumber(String str) {fieldHashMap.get(employeeNumberFieldName).setData(str);}
    public void setPhoneNumber(String str) {fieldHashMap.get(phoneNumberFieldName).setData(str);}
    public void setName(String str) {fieldHashMap.get(nameFieldName).setData(str);}
    public void setBirthday(String str) {fieldHashMap.get(birthdayFieldName).setData(str);}
    public void setCareerLevel(String str) {fieldHashMap.get(careerLevelFieldName).setData(str);}
    public void setCerti(String str) {fieldHashMap.get(certiFieldName).setData(str);}

    public String getEmployeeNumber() {return fieldHashMap.get(employeeNumberFieldName).getData();}
    public String getPhoneNumber() { return fieldHashMap.get(phoneNumberFieldName).getData(); }
    public String getName() { return fieldHashMap.get(nameFieldName).getData(); }
    public String getBirthday() { return fieldHashMap.get(birthdayFieldName).getData(); }
    public String getCareerLevel() { return fieldHashMap.get(careerLevelFieldName).getData(); }
    public String getCerti() { return fieldHashMap.get(certiFieldName).getData(); }

    public String getLastName() {
        NameField field = (NameField)fieldHashMap.get(nameFieldName);
        return field.getLastName();
    }
    public String getFirstName() {
        NameField field = (NameField)fieldHashMap.get(nameFieldName);
        return field.getFirstName();
    }
    public int getRealEmployeeNumber() {
        EmployeeNumberField field = (EmployeeNumberField)fieldHashMap.get(employeeNumberFieldName);
        return field.getRealEmployeeNum();
    }
    public String getMiddlePhoneNumber() {
        PhoneNumberField field = (PhoneNumberField)fieldHashMap.get(phoneNumberFieldName);
        return field.getMiddlePhoneNumber();
    }
    public String getLastPhoneNumber() {
        PhoneNumberField field = (PhoneNumberField)fieldHashMap.get(phoneNumberFieldName);
        return field.getLastPhoneNumber();
    }
    public String getBirthYearOnly() {
        BirthdayField field = (BirthdayField)fieldHashMap.get(birthdayFieldName);
        return field.getBirthYearOnly();
    }
    public String getBirthMonthOnly() {
        BirthdayField field = (BirthdayField)fieldHashMap.get(birthdayFieldName);
        return field.getBirthMonthOnly();
    }
    public String getBirthDayOnly() {
        BirthdayField field = (BirthdayField)fieldHashMap.get(birthdayFieldName);
        return field.getBirthDayOnly();
    }

    public Object getField(String fieldName) {
        try {
            if (fieldHashMap.containsKey(fieldName)){
                return fieldHashMap.get(fieldName).getData();
            } else {
                return getClass()
                        .getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1))
                        .invoke(this);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("get wrong field string");
            //return null;
        }
    };

    public void setField(String fieldName, String input) {
        try {
            if (fieldHashMap.containsKey(fieldName)) {
                fieldHashMap.get(fieldName).setData(input);
            } else {
                getClass()
                        .getMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), String.class)
                        .invoke(this, input);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("get wrong field string");
        }
    };

    public String getStringField(String fieldName) throws Exception {
        return (String)getField(fieldName);
    };

    public int getIntField(String fieldName) throws Exception {
        return (int)getField(fieldName);
    };
}