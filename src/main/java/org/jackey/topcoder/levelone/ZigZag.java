package org.jackey.topcoder.levelone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jinhuang
 * Date: 5/8/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 * Problem Statement    A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a zig-zag sequence.
 * For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
 * Definition    Class:ZigZagMethod:longestZigZagParameters:int[]Returns:intMethod signature:int longestZigZag(int[] sequence)(be sure your method is public)     Constraints-sequence contains between 1 and 50 elements, inclusive.-Each element of sequence is between 1 and 1000, inclusive. Examples0)
 * { 1, 7, 4, 9, 2, 5 }
 * <p/>
 * Returns: 6
 * <p/>
 * The entire sequence is a zig-zag sequence.1)
 * { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }
 * <p/>
 * Returns: 7
 * <p/>
 * There are several subsequences that achieve this length. One is 1,17,10,13,10,16,8.2)
 * { 44 }
 * <p/>
 * Returns: 1
 * <p/>
 * 3)
 * { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
 * <p/>
 * Returns: 2
 * <p/>
 * 4)
 * { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }
 * <p/>
 * Returns: 8
 * <p/>
 * 5)
 * { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
 * 600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
 * 67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
 * 477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
 * 249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }
 * <p/>
 * Returns: 36
 */
public class ZigZag {
    public int longestZigZag(int[] sequence) {
        if (sequence != null && sequence.length != 0) {
            if (sequence.length == 1) {
                return 1;
            } else {
                int[] up = new int[sequence.length];
                int[] down = new int[sequence.length];

                up[0] = 1;
                down[0] = 1;
                int ret = 0;
                for (int i = 1; i < sequence.length; i++) {
                    int max_up = 0;
                    int max_down = 0;
                    for (int j = 0; j < i; j++) {
                        if (sequence[j] > sequence[i]) {
                            if (down[j] > max_down)
                                max_down = down[j];
                        } else if (sequence[j] < sequence[i]) {
                            if (up[j] > max_up) {
                                max_up = up[j];
                            }
                        }

                        up[i] = max_down + 1;
                        down[i] = max_up + 1;

                        ret = (ret = ret > up[i] ? ret : up[i]) > down[i] ? ret : down[i];

                    }
                }
                return ret;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] sequence = {374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244};
        System.out.println(new ZigZag().longestZigZag(sequence));
    }


}
