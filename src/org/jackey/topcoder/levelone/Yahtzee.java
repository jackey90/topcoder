package org.jackey.topcoder.levelone;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author Jackey
 * @email jackey90.hj@gmail.com
 * 
 *        Problem Statement
 * 
 *        This task is about the scoring in the first phase of the die-game
 *        Yahtzee, where five dice are used. The score is determined by the
 *        values on the upward die faces after a roll. The player gets to choose
 *        a value, and all dice that show the chosen value are considered
 *        active. The score is simply the sum of values on active dice. Say, for
 *        instance, that a player ends up with the die faces showing 2, 2, 3, 5
 *        and 4. Choosing the value two makes the dice showing 2 active and
 *        yields a score of 2 + 2 = 4, while choosing 5 makes the one die
 *        showing 5 active, yielding a score of 5. Your method will take as
 *        input an int[] toss, where each element represents the upward face of
 *        a die, and return the maximum possible score with these values.
 * 
 *        Definition Class:Yahtzee
 * 
 *        Method:maxPoints
 * 
 *        Parameters:int[]
 * 
 *        Returns:intMethod
 * 
 *        signature:int maxPoints(int[] toss)(be sure your method is public)
 * 
 *        Constraints-toss will contain exactly 5 elements.-Each element of toss
 *        will be between 1 and 6, inclusive.
 * 
 *        Examples
 * 
 *        0) { 2, 2, 3, 5, 4 }
 * 
 *        Returns: 5
 * 
 *        The example from the text.
 * 
 *        1) { 6, 4, 1, 1, 3 }
 * 
 *        Returns: 6
 * 
 *        Selecting 1 as active yields 1 + 1 = 2, selecting 3 yields 3,
 *        selecting 4 yields 4 and selecting 6 yields 6, which is the maximum
 *        number of points.
 * 
 *        2) { 5, 3, 5, 3, 3 }
 * 
 *        Returns: 10
 */
public class Yahtzee {
	public int maxPoints(int[] toss) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < toss.length; i++) {
			int t = toss[i];
			if (map.get(t) != null) {
				map.put(t, map.get(t) + t);
			} else {
				map.put(t, t);
			}
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
			}
		}
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		int[] YahtzeeData;
		
		Random r = new Random();
		int n = 10000000;
		
		YahtzeeData = new int[n];
		for(int i = 0; i < n; i++){
			YahtzeeData[i] = r.nextInt(n);
		}
		
		int[] toss = {1,1,1,1,2,2,2,2,3,3,3,3,3,1,4};
		new Yahtzee().maxPoints(YahtzeeData);
	}

}
