package org.jackey.topcoder.levelone;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 7/22/14
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement for BadNeighbors
 * <p/>
 * <p/>
 * Problem Statement
 * <p/>
 * The old song declares "Go ahead and hate your neighbor", and the residents of Onetinville have taken those words to heart. Every resident hates his next-door neighbors on both sides. Nobody is willing to live farther away from the town's well than his neighbors, so the town has been arranged in a big circle around the well. Unfortunately, the town's well is in disrepair and needs to be restored. You have been hired to collect donations for the Save Our Well fund.
 * <p/>
 * Each of the town's residents is willing to donate a certain amount, as specified in the int[] donations, which is listed in clockwise order around the well. However, nobody is willing to contribute to a fund to which his neighbor has also contributed. Next-door neighbors are always listed consecutively in donations, except that the first and last entries in donations are also for next-door neighbors. You must calculate and return the maximum amount of donations that can be collected.
 * <p/>
 * <p/>
 * Definition
 * <p/>
 * Class:	BadNeighbors
 * Method:	maxDonations
 * Parameters:	int[]
 * Returns:	int
 * Method signature:	int maxDonations(int[] donations)
 * (be sure your method is public)
 * <p/>
 * <p/>
 * Constraints
 * -	donations contains between 2 and 40 elements, inclusive.
 * -	Each element in donations is between 1 and 1000, inclusive.
 * <p/>
 * Examples
 * 0)
 * <p/>
 * { 10, 3, 2, 5, 7, 8 }
 * Returns: 19
 * The maximum donation is 19, achieved by 10+2+7. It would be better to take 10+5+8 except that the 10 and 8 donations are from neighbors.
 * 1)
 * <p/>
 * { 11, 15 }
 * Returns: 15
 * 2)
 * <p/>
 * { 7, 7, 7, 7, 7, 7, 7 }
 * Returns: 21
 * 3)
 * <p/>
 * { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 }
 * Returns: 16
 * 4)
 * <p/>
 * { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
 * 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
 * 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 }
 * Returns: 2926
 */
public class BadNeighbors {
    public int maxDonations(int[] donations) {
        int len = donations.length;
        if (len == 0) return 0;
        if (len == 1) return donations[0];
        if (len == 2) return Math.max(donations[0], donations[1]);

        int[][] matrix = new int[len][2];
        // len >= 3
        // [i][0] means max from 0..i-1
        // [i][1] means max from 1..i
        matrix[1][0] = donations[0];
        matrix[1][1] = donations[1];
        matrix[2][0] = Math.max(donations[0], donations[1]);
        matrix[2][1] = Math.max(donations[1], donations[2]);

        for (int i = 3; i < donations.length; i++) {
            matrix[i][0] = Math.max(matrix[i - 1][0], matrix[i - 2][0] + donations[i - 1]);
            matrix[i][1] = Math.max(matrix[i - 1][1], matrix[i - 2][1] + donations[i]);
        }
        return Math.max(matrix[len - 1][0], matrix[len - 1][1]);
    }

    public static void main(String[] args) {
        int[] donations ={ 10, 3, 2, 5, 7, 8 };
        System.out.println(new BadNeighbors().maxDonations(donations));
    }


}
