package DataBase;

import java.util.ArrayList;
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
class EmployeeNumComparable implements Comparable<Employee> {
	private String EmployeeNum;
	public EmployeeNumComparable(String EmployeeNum) {
		this.EmployeeNum = EmployeeNum;
	}
 @Override
 	public boolean compareTo(Employee o) {
	 	return o.getEmployeeNum().equals(EmployeeNum);
 	}
}

//이름에 대한 조건 검색
class nameComparable implements Comparable<Employee> {
	private String name;
	public nameComparable(String name) {
		this.name = name;
	}
@Override
	public boolean compareTo(Employee o) {
	 	return o.getName().equals(name);
	}
}

//cl에 대한 조건 검색
class clComparable implements Comparable<Employee> {
	private String cl;
	public clComparable(String cl) {
		this.cl = cl;
	}
@Override
	public boolean compareTo(Employee o) {
	 	return o.getName().equals(cl);
	}
}

//이름에 대한 조건 검색
class phoneComparable implements Comparable<Employee> {
	private String phoneNum;
	public phoneComparable(String phoneNum) {
		this.phoneNum = phoneNum;
	}
@Override
	public boolean compareTo(Employee o) {
	 	return o.getName().equals(phoneNum);
	}
}

class AndComparable implements Comparable<Employee> {
	Comparable<Employee> first;
	Comparable<Employee> second;

	AndComparable(Comparable<Employee> first) {
		this.first = first;
	}

	AndComparable(Comparable<Employee> first, Comparable<Employee> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean compareTo(Employee o) {
		return first.compareTo(o) && second.compareTo(o);
	}
};
*/

public class DataBase {
	ArrayList<Employee> empList = new ArrayList<>();
	public void addEmployee(Employee employee) {
	  empList.add(employee);		
	}
	
	public ArrayList<Employee> searchEmployee(String searchOption, String searchColumn, String searchData) {	
		ArrayList<Employee> result = new ArrayList<>();
		int cnt=0;
		// better filter로 filter함.
		boolean isFound;
		for(Employee employee : empList) {
		  
			isFound=false;
			switch(searchColumn) {
				case "employeeNum":
					if(employee.getEmployeeNumber().equals(searchData)) {
						isFound=true;
						break;
					}
					break;
				case "name":
					if(searchOption.equals("-f") && employee.getFirstName().equals(searchData)) {
						isFound=true;
						break;
					}
					else if(searchOption.equals("-l") && employee.getLastName().equals(searchData)) {
						isFound=true;
						break;
					}
					else if(searchOption.equals("") && employee.getName().equals(searchData)) {
						isFound=true;
						break;
					}
					break;
				case "cl":
					if(employee.getCareerLevel().equals(searchData)) {
						isFound=true;
						break;
					}
				case "phoneNum":				  
					if(searchOption.equals("-m") && employee.getMiddlePhoneNumber().equals(searchData)) {
						isFound=true;
						break;
					}
			        else if(searchOption.equals("-l") && employee.getLastPhoneNumber().equals(searchData)) {
						isFound=true;
						break;
					}
			        else if(searchOption.equals("") && employee.getPhoneNumber().equals(searchData)) {
						isFound=true;
						break;
					}
					break;
				case "birthday":
					if(searchOption.equals("-y") && employee.getBirthYearOnly().equals(searchData)) {
						isFound=true;
						break;
					}
					else if(searchOption.equals("-m") && employee.getBirthMonthOnly().equals(searchData)) {
						isFound=true;
						break;
					}
					else if(searchOption.equals("-d") && employee.getBirthDayOnly().equals(searchData)) {
						isFound=true;
						break;
					}
					else if(searchOption.equals("") && employee.getBirthday().equals(searchData)) {
						isFound=true;
						break;    
					}
					break;
				case "certi":
					if(employee.getCerti().equals(searchData)) {
						isFound=true;
						break;
					}
					break;
			}
			if(isFound) result.add(employee);
		}
		return result;
	}
	
	public ArrayList<Employee> updateEmployee(String option, String searchColumn, String searchData, String changeColumn, String changeData) {
		ArrayList<Employee> targetEmployee = searchEmployee(option, searchColumn, searchData);
		ArrayList<Employee> returnEmployee = new ArrayList<Employee>();

		for(Employee employee : targetEmployee) {
		  returnEmployee.add(new Employee(employee.getEmployeeNumber(),employee.getName(), employee.getCareerLevel(), employee.getPhoneNumber(), employee.getBirthday(), employee.getCerti()));
			switch(changeColumn) {
				case "eployeeNum":
				  employee.setEmployeeNumber(changeData); break;
				case "name":
				  employee.setName(changeData); break;
				case "cl":
				  employee.setCareerLevel(changeData); break;
				case "phoneNum":
				  employee.setPhoneNumber(changeData); break;
				case "birthday":
				  employee.setBirthday(changeData); break;
				case "certi":
				  employee.setCerti(changeData); break;
			}
		}
		return returnEmployee;
	}
	
	public ArrayList<Employee> deleteEmployee(String searchOption, String searchColumn, String searchData) {
		ArrayList<Employee> targetEmployee = searchEmployee(searchOption, searchColumn, searchData);
		ArrayList<Employee> returnEmployee = new ArrayList<Employee>();
		for(Employee employee : targetEmployee) {
		  returnEmployee.add(new Employee(employee.getEmployeeNumber(),employee.getName(), employee.getCareerLevel(), employee.getPhoneNumber(), employee.getBirthday(), employee.getCerti()));
		  empList.remove(employee);
		}
		
		return returnEmployee;
	}
}
