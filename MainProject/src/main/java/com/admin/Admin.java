package com.admin;

public class Admin {
   private String name;
   private String netId;
   private String Pass;
 
   public Admin(String name, String netId, String pass) {
	super();
	this.name = name;
	this.netId = netId;
	Pass = pass;
   }

   public String getName() {
	return name;
   }

   public String getNetId() {
	return netId;
   }

   public String getPass() {
	return Pass;
   }
   
   
}
