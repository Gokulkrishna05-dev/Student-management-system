package com.student;
import java.util.*;

public class Student{
  public int Sno;
  private String First_name;
  private String Last_name;
  private int regno;
  private String gmail;
  private String Department;
  private String Specialization;
  private Date DOB;
  private String Address;
  private String NetId;
  private String Password;
  public Student(String name,String Lname, int regno,String gmail, String department, String specialization, Date dOB, String address,String Netid,String Password) {
	this.First_name = name;
	this.Last_name=Lname;
	this.regno = regno;
	this.gmail=gmail;
	Department = department;
	Specialization = specialization;
	DOB = dOB;
	Address = address;
	this.NetId=Netid;
	this.Password=Password;
  }
  
  public Student(String Fname,String Lname, int regno, String gmail, String department, String specialization, Date dOB,
		String address) {
	this.First_name = Fname;
	this.Last_name = Lname;
	this.regno = regno;
	this.gmail = gmail;
	Department = department;
	Specialization = specialization;
	DOB = dOB;
	Address = address;
}

  public Student() {
	// TODO Auto-generated constructor stub
}
  public String getFirstName() {
	return First_name;
  }
  public String getLastName() {
		return Last_name;
	  }
  public int getRegno() {
	return regno;
  }
  public String getDepartment() {
	return Department;
  }
  public String getSpecialization() {
	return Specialization;
  }
  public Date getDOB() {
	return DOB;
  }
  public String getAddress() {
	return Address;
  }
  public String getGmail() {
		return gmail;
	  }
  public String getNetid() {
		return NetId;
	  }
  public String getPassword() {
		return Password;
	  }
  public  void snum(int num) {
	  this.Sno=num;
  }
  public int getSno() {
	  return Sno;
  }
}



