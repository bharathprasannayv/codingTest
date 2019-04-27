package com.pickyourtrail.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question3 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String inputString = sc.next();
			sc.close();
			String balancedStringRegex = "(?=^(([ac]*[bd]){2})*[ac]*$)(([bd]*[ac]){2})*[bd]*";
			Pattern p = Pattern.compile(balancedStringRegex);
			Matcher m = p.matcher(inputString);
			System.out.println(m.matches());
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
}
