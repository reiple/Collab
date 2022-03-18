package DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
abstract class Specification<T> {abstract boolean is_satisfied(T item);}
abstract class Filter<T> {abstract List<T> filter(List<T> items, Comparable<T> comparable);}
interface Comparable<T> {public boolean compareTo(T o);}

class BetterFitler<T> extends Filter<T> {
	@Override
	public List<T> filter(List<T> items, Comparable<T> comparable) {
		return items.stream().filter(item -> comparable.compareTo(item)).collect(Collectors.toList());
	}
}

//사번에 대한 조건 검색
class employeeNumComparable implements Comparable<EMPLOYEE> {
	private String employeeNum;
	public employeeNumComparable(String employeeNum) {
		this.employeeNum = employeeNum;
	}
 @Override
 	public boolean compareTo(EMPLOYEE o) {
	 	return o.getEmployeeNum().equals(employeeNum);
 	}
}

//이름에 대한 조건 검색
class nameComparable implements Comparable<EMPLOYEE> {
	private String name;
	public nameComparable(String name) {
		this.name = name;
	}
@Override
	public boolean compareTo(EMPLOYEE o) {
	 	return o.getName().equals(name);
	}
}

//cl에 대한 조건 검색
class clComparable implements Comparable<EMPLOYEE> {
	private String cl;
	public clComparable(String cl) {
		this.cl = cl;
	}
@Override
	public boolean compareTo(EMPLOYEE o) {
	 	return o.getName().equals(cl);
	}
}

//이름에 대한 조건 검색
class phoneComparable implements Comparable<EMPLOYEE> {
	private String phoneNum;
	public phoneComparable(String phoneNum) {
		this.phoneNum = phoneNum;
	}
@Override
	public boolean compareTo(EMPLOYEE o) {
	 	return o.getName().equals(phoneNum);
	}
}

class AndComparable implements Comparable<EMPLOYEE> {
	Comparable<EMPLOYEE> first;
	Comparable<EMPLOYEE> second;

	AndComparable(Comparable<EMPLOYEE> first) {
		this.first = first;
	}

	AndComparable(Comparable<EMPLOYEE> first, Comparable<EMPLOYEE> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean compareTo(EMPLOYEE o) {
		return first.compareTo(o) && second.compareTo(o);
	}
};
*/

public class DataBase {
	ArrayList<EMPLOYEE> emp = new ArrayList<EMPLOYEE>();
	public void addData(String employeeNum, String name, String cl, String phoneNum, String birthDay, String certi) {
		emp.add(new EMPLOYEE(employeeNum, name, cl, phoneNum, birthDay, certi));		
	}
	
	public ArrayList<EMPLOYEE> getData(String searchOption, String searchColumn, String searchData) {	
		ArrayList<EMPLOYEE> result = new ArrayList<EMPLOYEE>();
		// better filter로 filter함.
		boolean isFound;
		for(EMPLOYEE employee : emp) {
			isFound=false;
			switch(searchColumn) {
				case "employeeNum":
					if(employee.getEmployeeNum().equals(searchData)) {
						isFound=true;
					}
				case "name":
					if(searchOption.equals("-f")) {
						if(employee.getName().equals(searchData)) {
							isFound=true;
						}
					}
					if(searchOption.equals("-l")) {
						if(employee.getName().equals(searchData)) {
							isFound=true;
						}
					}
					if(!searchOption.equals("-f") && !searchOption.equals("-l")) {
						if(employee.getName().equals(searchData)) {
							isFound=true;
						}
					}
				case "cl":
					if(employee.getCl().equals(searchData)) {
						isFound=true;
					}
					
				case "phoneNum":
					if(searchOption.equals("-m")) {
						if(employee.getMidPhoneNum().equals(searchData)) {
							isFound=true;
						}
					}
					if(searchOption.equals("-l")) {
						if(employee.getLastPhoneNum().equals(searchData)) {
							isFound=true;
						}
					}
					if(!searchOption.equals("-m")&&!searchOption.equals("-l")) {
						if(employee.getPhoneNum().equals(searchData)) {
							isFound=true;
						}
					}
				case "birthDay":
					if(searchOption.equals("-y")) {
						if(employee.getBirthDayYYYY().equals(searchData)) {
							isFound=true;
						}
					}
					if(searchOption.equals("-m")) {
						if(employee.getBirthDayMM().equals(searchData)) {
							isFound=true;
						}
					}
					if(searchOption.equals("-d")) {
						if(employee.getBirthDayDD().equals(searchData)) {
							isFound=true;
						}
					}
					if(!searchOption.equals("-y") && !searchOption.equals("-m") && !searchOption.equals("-d")) {
						if(employee.getBirthDay().equals(searchData)) {
							isFound=true;
						}
					}
				case "certi":
					if(employee.getCerti().equals(searchData)) {
						isFound=true;
					}
			}
			if(isFound) result.add(employee);
		}
		return result;
	}
	public ArrayList<EMPLOYEE> modData(String option, String searchColumn, String searchData, String changeColumn, String changeData) {
		ArrayList<EMPLOYEE> result = new ArrayList<EMPLOYEE>();
		
		ArrayList<EMPLOYEE> targetEmployee = getData(option, searchColumn, searchData);
		for(EMPLOYEE employee : targetEmployee) {
			switch(changeColumn) {
				case "employeeNum":
					employee.updateEmployeeNum(changeData);
				case "name":
					employee.updateName(changeData);
				case "cl":
					employee.updateCl(changeData);
				case "phoneNum":
					employee.updatePhoneNum(changeData);
				case "birthDay":
					employee.updateBirthDay(changeData);
				case "certi":
					employee.updateCerti(changeData);
			}
		}
		
		return result;
	}
	
	public ArrayList<EMPLOYEE> delData(String searchOption, String searchColumn, String searchData, String changeColumn, String changeData) {
		ArrayList<EMPLOYEE> result = new ArrayList<EMPLOYEE>();
		
		ArrayList<EMPLOYEE> targetEmployee = getData(searchOption, searchColumn, searchData);
		for(EMPLOYEE employee : targetEmployee) {
			emp.remove(employee);
		}
		
		return targetEmployee;
	}
}
