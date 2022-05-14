package com.profiles.util;

public class StringUtil {
	
	private StringUtil() {
		super();
	}
	
	public static String takeOutWhiteSpaceInFrontAndBack(String in) {
		return removeWhiteSpaceBack(removeWhiteSpaceFront(in));
	}
	
	public static String removeWhiteSpaceFront(String in) {
		String rs="";
		boolean start= false;
		for(int i=0; i<in.length(); i++) {
			if(!start && isAValidCharacter(in.charAt(i))) start=true;
			if(start) rs+=in.charAt(i);
		}
		return rs;
	}
	
	public static String removeWhiteSpaceBack(String in) {
		String rs="";
		boolean start= false;
		for(int i=in.length()-1; i>=0; i--) {
			if(!start && isAValidCharacter(in.charAt(i))) start=true;
			if(start) rs+=in.charAt(i);
		}
		return reverse(rs);
	}
	
	public static String reverse(String in) {
		String rs="";
		for(int i=in.length()-1; i>=0; i--) {
			rs+=in.charAt(i);
		}
		return rs;
	}
	
	public static boolean isAValidCharacter(char c) {
		String key ="abcdefghijklmnopqrstuvwxyz0123456789.-+=!@";
		return key.contains((c+"").toLowerCase());
	}

}
