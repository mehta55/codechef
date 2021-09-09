package com.codechef.june_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PRICECON {

	public static class Testcase {
		List<Long> prices;
		Long ceil;

		public Testcase() {
			prices = new ArrayList<>();
		}

	}

	public static void main(String args[]) {
		List<Testcase> testcases = takeInput();
		testcases.stream().map(testcase -> testcase.prices.stream().mapToLong(price -> price - testcase.ceil)
				.filter(price -> price > 0).sum()).forEach(System.out::println);
	}

	private static List<Testcase> takeInput() {
		Scanner scn = new Scanner(System.in);
		int testcaseCount = scn.nextInt();
		List<Testcase> testcases = new ArrayList<>();
		while (testcaseCount-- > 0) {
			Testcase testcase = new Testcase();
			int priceCount = scn.nextInt();
			testcase.ceil = scn.nextLong();
			for (int i = 0; i < priceCount; i++) {
				testcase.prices.add(scn.nextLong());
			}
			testcases.add(testcase);
		}

		scn.close();
		return testcases;
	}

}
