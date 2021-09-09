package com.codechef.june_2020;

import java.util.Scanner;

public class XYSTR {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testcases = scn.nextInt();
		while(testcases-- > 0) {
			String str = scn.next();
			System.out.println(solve(str));
		}

	}

	private static int solve(String str) {
		return solve(str, 0);
	}

	private static int solve(String str, int index) {
		if(index >= str.length() - 1) {
			return 0;
		}
		if(str.charAt(index) == 'x' && str.charAt(index + 1) == 'y') {
			return 1 + solve(str, index + 2);
		} 
		if(str.charAt(index) == 'y' && str.charAt(index + 1) == 'x') {
			return 1 + solve(str, index + 2);
		}
		
		return solve(str, index + 1);
	}

}
