package com.travel.portal.user.utility;
/**
 * This class generates 
 * a random password of 8 characters
 * @author bhavneetkaur
 *
 */
public class GeneratePassword {
	
	public String generate() {
		String allowedCharacters="ABCDEFGHIJKLMOPQRSTUVWXYZ"+
								 "abcdefghijklmopqrstuvwxyz"+
								 "0123456789"+"!@#$&";
		StringBuffer password=new StringBuffer();
		int index=0;
		for(int i=0;i<8;i++) {
			System.out.println(i);
			index=(int)(Math.random()*60);
			System.out.println(index);
			password.append(allowedCharacters.charAt(index));
			System.out.println(password);
		}
		return password.toString();
	}

}
