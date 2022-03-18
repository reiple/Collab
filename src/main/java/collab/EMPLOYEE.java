package DataBase;

public class EMPLOYEE {
	private String employeeNum;
	private String name;
	private String cl;
	private String phoneNum;
	private String birthDay;
	private String certi;
	
	EMPLOYEE(String employeeNum, String name, String cl, String phoneNum, String birthDay, String certi) {
		this.employeeNum=employeeNum;
		this.name=name;
		this.cl=cl;
		this.phoneNum=phoneNum;
		this.birthDay=birthDay;
		this.certi=certi;
	}
	public String getEmployeeNum() {
		return employeeNum;
	}
	public String getName() {
		return name;
	}
	public String getFirstName() {
		return name.substring(0,name.indexOf(" "));
	}
	public String getLastName() {
		return name.substring(name.indexOf(" ")+1);
	}
	public String getCl() {
		return cl;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getMidPhoneNum() {
		return phoneNum.substring(4).substring(0,phoneNum.substring(4).indexOf("-"));
	}
	public String getLastPhoneNum() {
		return phoneNum.substring(4).substring(phoneNum.substring(4).indexOf("-")+1);
	}
	public String getBirthDay() {
		return birthDay;
	}
	public String getBirthDayYYYY() {
		return birthDay.substring(0,4);
	}
	public String getBirthDayMM() {
		return birthDay.substring(4,6);
	}
	public String getBirthDayDD() {
		return birthDay.substring(6,8);
	}
	public String getCerti() {
		return certi;
	}
	void updateEmployeeNum(String changeData) { 
		this.employeeNum=changeData; 
	}
	void updateName(String changeData) {
		this.name=changeData;
	}
	void updateCl(String changeData) {
		this.cl=changeData;
	}
	void updatePhoneNum(String changeData) {
		this.phoneNum=changeData;
	}
	void updateBirthDay(String changeData) { 
		this.birthDay=changeData;
	}
	void updateCerti(String changeData) {
		this.certi=changeData;
	}
}
