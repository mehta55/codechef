package com.codechef.june_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CHFICRM {

	public static void main(String args[]) {
		List<List<Integer>> testcases = takeInput();
		List<String> results = testcases.parallelStream().map(CHFICRM::solve).collect(Collectors.toList());
		results.forEach(System.out::println);
	}
	
	private static String solve(List<Integer> coins) {
		int counterBal = 0;
		int[] coinCountMap = new int[16];
		
		for (Integer coin : coins) {
			int retBal = coin - 5;
			
			if(retBal > counterBal) {
				return "NO";
			} 
			
			for (int i = coinCountMap.length - 1; i >= 5 && retBal != 0 ; i -= 5) {
				coinCountMap[i] -= retBal/i;
				retBal = retBal % i;
			}
			
			if(retBal != 0) {
				return "NO";
			}
			
			coinCountMap[coin]++;
			counterBal += 5;
		}
		
		return "YES";
	}

	private static List<List<Integer>> takeInput() {
		Scanner scn = new Scanner(System.in);
		List<List<Integer>> testcases = new ArrayList<>();
		int testcaseCount = scn.nextInt();
		while(testcaseCount-- > 0) {
			int n = scn.nextInt();
			List<Integer> testcase = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				testcase.add(scn.nextInt());
			}
			testcases.add(testcase);
		}
		return testcases;
	}
}
