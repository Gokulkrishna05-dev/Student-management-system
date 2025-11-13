package com.student;

import java.util.Random;
import java.util.stream.IntStream;

public class Rand {
	
	public static String getNetId(String name) {
		String id=name;
		Random rand=new Random();
		String str="1234567890";
		for(int i=0;i<5;i++) {
			int ran=rand.nextInt(9);
			id+=str.charAt(ran);
		}
		return id;
	}
	
	public static String getPass() {
		String pass="";
		Random rand=new Random();
		String str="!@#$%&ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		for(int i=1;i<=8;i++) {
			int num=rand.nextInt(65);
			pass+=str.charAt(num);
		}
		return pass;
	}

	public static void main(String[] args) {
		System.out.println("Hello world");
        Random rand=new Random();
        
        String str="1234567890ABCDEFGHIJKLMNOPQRSTUVWZ";
        String id="Gokul";
        for(int i=0;i<=5;i++) {
        	int ran=rand.nextInt(38);
        	id+=str.charAt(ran);
        }
        System.out.println(id);
	}

}
