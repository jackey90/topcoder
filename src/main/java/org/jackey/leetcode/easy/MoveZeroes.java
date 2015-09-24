package org.jackey.leetcode.easy;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

import java.util.Arrays;

/**
 * Created by jackey90 on 15/9/24.
 * <p/>
 * <p/>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p/>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p/>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int i = 0, j = nums.length - 1;

        while (i < j) {
            while (nums[i] != 0) {
                i++;
            }
            while (nums[j] == 0) {
                j--;
            }

            if(i  < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        Arrays.sort(nums, 0, i );
        JOutPrint.JPrint(nums);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
    }
}
