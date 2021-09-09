package com.codechef.june_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EOEO {
	
	private static int[][] dp;
	private static int maxTs = 0;

	public static void main(String args[]) {
		solution1();   	// NZEC
		solution2();	// TLE
		solution3();	// AC
	}

	private static void solution3() {
		List<Long> inputs = takeInputs();
		List<Long> outputs = inputs.parallelStream().map(EOEO::solve3).collect(Collectors.toList());
		outputs.forEach(System.out::println);
		
	}
	
	private static Long solve3(Long ts) {
		if(ts % 2 == 1) {
			return (ts - 1)/2;
		} else {
			while(ts % 2 == 0) {
				ts = ts/2;
			}
			return ts == 1 ? 0 : (ts - 1)/2;
		}
	}

	private static void solution2() {
		List<Long> inputs = takeInputs();
		List<Integer> outputs = inputs.parallelStream().map(EOEO::solve2).collect(Collectors.toList());
		outputs.forEach(System.out::println);
	}

	private static int solve2(Long ts) {
		int ans = 0;
		for (long js = 1; js < ts; js++) {
			ans += solve2(ts, js);
		}
		return ans;
	}

	private static int solve2(Long ts, Long js) {
		boolean isTsEven = ts % 2 == 0;
		boolean isJsEven = js % 2 == 0;
		
		if((isTsEven && isJsEven)) {
			return solve2(ts/2, js/2);
		} else if(isJsEven) {
			return 1;
		}
		return 0;
	}

	private static void solution1() {
		List<Integer> inputs = takeInputsAndCalcMax();
		solve();
		List<Integer> outputs = inputs.stream().map(ts -> dp[ts][ts]).collect(Collectors.toList());
		outputs.forEach(System.out::println);
	}

	private static void solve() {
		dp = new int[maxTs+1][maxTs+1];
		
		for(int ts = 1; ts <= maxTs; ts++) {
			for(int js = 2; js <= maxTs; js++) {
				boolean isTsEven = ts % 2 == 0, isJsEven = js % 2 == 0;
				
				if(isTsEven && isJsEven) {
					dp[ts][js] = dp[ts][js-1] + (dp[ts/2][js/2] - dp[ts/2][js/2 -1]);
				} else if(isJsEven) {
					dp[ts][js] = dp[ts][js-1] + 1;
				} else 
					dp[ts][js] = dp[ts][js-1];
			}
		}
	}

	private static List<Integer> takeInputsAndCalcMax() {
		Scanner scn = new Scanner(System.in);
		int testCaseCount = scn.nextInt();
		List<Integer> inputs = new ArrayList<>();

		
		for (int i = 0; i < testCaseCount; i++) {
			int ts = scn.nextInt();
			if(ts > maxTs)
				maxTs = ts;
			inputs.add(ts);
		}

		scn.close();
		return inputs;
	}

	private static List<Long> takeInputs() {
		Scanner scn = new Scanner(System.in);
		int testCaseCount = scn.nextInt();
		List<Long> inputs = new ArrayList<>();
		
		
		for (int i = 0; i < testCaseCount; i++) {
			inputs.add(scn.nextLong());
		}
		
		scn.close();
		return inputs;
	}

}
