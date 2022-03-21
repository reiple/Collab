package DataBase;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputTest {
  DataBase empDB = new DataBase();
  
  ArrayList<Employee> foundEmployeeList;
  int testCnt=500;
  
  @BeforeEach
  public void setUp() {
    InputList inputData = new InputList();
    
    for(int i=0; i<106000; i++) {
      empDB.addEmployee(Arrays.asList(inputData.employeeNum.get(i), inputData.name.get(i), inputData.cl.get(i), 
          inputData.phoneNum.get(i), inputData.birthday.get(i), inputData.certi.get(i)));     
    }
  }
 
  @Test
  void test() {
    test_EmployeeNum();
    test_Name();
    test_Cl();
    test_PhoneNum();
    test_Birthday();
    test_Certi();

  }
  
  // 1. employeeNum 조회
  void test_EmployeeNum() {
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("", "employeeNum", "69100000");
      assertEquals(foundEmployeeList.size(),1);
    }
  }
  
  // 2. name 조회
  void test_Name() {
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("", "name", "AAA AAA");
      assertEquals(foundEmployeeList.size(),53);
    }
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("-f", "name", "AAA");
      assertEquals(foundEmployeeList.size(),53);
    }
    
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("-l", "name", "AAA");
      assertEquals(foundEmployeeList.size(),53);
    }
  }
  
  // 3. cl 조회
  void test_Cl() {
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("", "cl", "CL4");
      assertEquals(foundEmployeeList.size(),35333);
    }
  }
  
  // 4. phoneNum 조회
  void test_PhoneNum() {
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("", "phoneNum", "010-1000-1000");
      assertEquals(foundEmployeeList.size(),1);
    }
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("-m", "phoneNum", "1000");
      assertEquals(foundEmployeeList.size(),2000);
    }
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("-l", "phoneNum", "1000");
      assertEquals(foundEmployeeList.size(),53);
    }
  }
  
  // 5. birthday 조회
  void test_Birthday() {
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("", "birthday", "20001228");
      assertEquals(foundEmployeeList.size(),6); // 106000/336/50
    }
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("-y", "birthday", "2000");
      assertEquals(foundEmployeeList.size(),2016); //(106000/336/50=)6*336
    }
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("-m", "birthday", "12");
      assertEquals(foundEmployeeList.size(),8820); // (106000/336=)315*28
    }
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("-d", "birthday", "28"); // 315*12 + 5(=160/28)
      assertEquals(foundEmployeeList.size(),3785);
    }
  }

  // 6. certi 조회
  void test_Certi() {
    for(int i=0; i< testCnt; i++) {
      foundEmployeeList = empDB.searchEmployee("", "certi", "EX");
      assertEquals(foundEmployeeList.size(),35333);
    }
  }
}

class InputList {
  public static ArrayList<String> employeeNum = new ArrayList<String>();
  public static ArrayList<String> name = new ArrayList<String>();
  public static ArrayList<String> cl = new ArrayList<String>();
  public static ArrayList<String> phoneNum = new ArrayList<String>();
  public static ArrayList<String> birthday = new ArrayList<String>();
  public static ArrayList<String> certi = new ArrayList<String>();
  
  InputList() {
    makeEmployeeNum();
    makeName();
    makeCl();
    makePhoneNum();
    makeBirthday();
    makeCerti();
  }

  
  public void makeEmployeeNum() {
    String yy;
    int intyy;
    
    // 69~122이면, 53 x 2000 = 106,000
    for(int a=69; a<122; a++) {
      yy="";
      intyy = a%100;
      if(intyy < 10) {yy+="0";}
      yy += Integer.toString(intyy);
      
      for(int i=100000; i<102000; i++) {
        employeeNum.add(yy + Integer.toString(i));
      }
    }
  }
  
  public void makeName() {
    for(int a=69; a<122; a++) {
      for(char i=65; i<70; i++) { // 5
        for(char j=65; j<85; j++) { // 20
          for(char k=65; k<85; k++) { // 20
            name.add(i+""+j+""+k+" "+i+""+j+""+k);
          }
        }
      }
    }
  }
  
  public void makePhoneNum() {
    // 106000개가 필요함.
    for(int i=1000; i<1053; i++) { // 53
      for(int j=1000; j<3000; j++) { //2000개 
        phoneNum.add("010-"+Integer.toString(i)+"-"+Integer.toString(j));
      }
    }
  }
  
  public void makeCl() {
    String addData="";
    for(int i=0; i<106000; i++) {
      if(i%3 == 0) addData = "CL2";
      if(i%3 == 1) addData = "CL3";
      if(i%3 == 2) addData = "CL4";
      cl.add(addData);
    }
  }
  
  public void makeCerti() {
    String addData="";    
    for(int i=0; i<106000; i++) {
      if(i%3 == 0) addData = "ADV";
      if(i%3 == 1) addData = "PRO";
      if(i%3 == 2) addData = "EX";
      certi.add(addData);
    }
  }
  
  public void makeBirthday() {
    int idx=1;
    
    int yyyy, mm, dd;
    String sYYYY,sMM,sDD;

    while(true) {
      yyyy=1951;
      
      while(true) {
        sYYYY = Integer.toString(yyyy);
        mm=1;
        
        while(true) {
          sMM="";
          if(mm<10) sMM = "0";
          sMM += Integer.toString(mm);
          
          dd=1;
          while(true) {
            sDD="";
            if(dd<10) sDD="0";
            sDD += Integer.toString(dd);

            birthday.add(sYYYY+sMM+sDD);
            if(idx++==106000) return;
            if(dd++==28) break;
          }
          
          if(mm++==12) break;
        }
        
        if(yyyy++==2000) break;
      }
    }
  }
}
