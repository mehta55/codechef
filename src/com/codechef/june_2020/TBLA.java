package com.codechef.june_2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.codechef.model.Cell;

public class TBLA {
	
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter number of rows:");
		int row = scn.nextInt();
		System.out.println("enter number of columns:");
		int col = scn.nextInt();
		
		Map<Integer, Cell> map = new HashMap<>();
		for(int i = 1; i <= row; i++) {
			System.out.println("enter numbers in row: " + i);
			for(int j = 1; j <= col; j++) {
				int value = scn.nextInt();
				if(value != 0)
					map.put(value, new Cell(value, i, j));
			}
		}
		
		System.out.println("starting game..");
		
		while(!map.isEmpty()) {
			System.out.println("Enter number: ");
			int num = scn.nextInt();
			if(map.containsKey(num)) {
				System.out.println(map.remove(num));
				
			} else {
				System.out.println("false");
			}
			System.out.println();
		}
		
		System.out.println("full house");
	}

}
