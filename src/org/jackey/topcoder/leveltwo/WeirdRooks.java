package org.jackey.topcoder.leveltwo;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 4/30/14
 * Time: 12:27 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement
 * On a weird chess board, each row can have a different number of columns. Element k of cols will give the number of columns in row k. Each row is flush left, so the right side can look quite ragged. In a valid assignment of n rooks to the weird chess board, no two rooks can share a row or column. In such an assignment, an unoccupied square is considered special if there is no rook to its right in the same row and no rook below in the same column (element 0 of cols describes the highest row). You are going to return a String containing a single-space delimited list of pairs. The pair (quotes for clarity) "r,f" should appear in the final string if and only if there is a valid assignment with r rooks such that f squares are special. The pairs should be sorted in nondecreasing order by r values. If a tie occurs, the lower f value should come first. The returned value should contain no repeated pairs. See the examples for further clarifications.
 * <p/>
 * Definition
 * <p/>
 * Class:	WeirdRooks
 * Method:	describe
 * Parameters:	int[]
 * Returns:	String
 * Method signature:	String describe(int[] cols)
 * (be sure your method is public)
 * <p/>
 * <p/>
 * Constraints
 * -	cols will contain between 1 and 8 elements inclusive.
 * -	Each element of cols will be between between 1 and 10 inclusive.
 * -	cols will be sorted in non-descending order.
 * <p/>
 * Examples
 * 0)
 * <p/>
 * {3,3,3}
 * Returns: "0,9 1,4 1,5 1,6 1,7 1,8 2,1 2,2 2,3 2,4 2,5 2,6 3,0 3,1 3,2 3,3"
 * If no rooks are placed on the board, all 9 squares are special. The following diagram depicts the scenario where 3 rooks are placed, and no squares are special.
 * <p/>
 * R..
 * .R.
 * ..R
 * 1)
 * <p/>
 * {1,2,3}
 * Returns: "0,6 1,3 1,4 1,5 2,1 2,2 2,3 3,0"
 * The case with 2 rooks and 3 special squares is depicted below.
 * R
 * .R
 * ...
 * 2)
 * <p/>
 * {1}
 * Returns: "0,1 1,0"
 * 3)
 * <p/>
 * {2,9}
 * Returns: "0,11 1,2 1,3 1,4 1,5 1,6 1,7 1,8 1,9 1,10 2,0 2,1 2,2 2,3 2,4 2,5 2,6 2,7 2,8"
 */
public class WeirdRooks {

}
