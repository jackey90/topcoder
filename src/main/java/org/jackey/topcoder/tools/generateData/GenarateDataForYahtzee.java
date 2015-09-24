package org.jackey.topcoder.tools.generateData;

import java.util.Random;

public class GenarateDataForYahtzee {
	static int[] YahtzeeData;
	
	public static void main(String[] args) {
		Random r = new Random();
		int n = 1000000;
		
		YahtzeeData = new int[n];
		for(int i = 0; i < n; i++){
			YahtzeeData[i] = r.nextInt(n);
		}
	}
}
