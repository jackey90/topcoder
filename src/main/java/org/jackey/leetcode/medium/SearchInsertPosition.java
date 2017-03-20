package org.jackey.leetcode.medium;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

/**
 * Created by jackey90 on 15/10/10.
 * <p/>
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p/>
 * You may assume no duplicates in the array.
 * <p/>
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return position(nums, 0, nums.length - 1, target);

    }

    private int position(int[] nums, int start, int end, int target) {
        if(start > end){
            return start;
        }

        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return position(nums, start, mid - 1, target);
        } else {
            return position(nums, mid + 1, end, target);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        JOutPrint.JPrint(new SearchInsertPosition().searchInsert(nums, 5));
        JOutPrint.JPrint(new SearchInsertPosition().searchInsert(nums, 2));
        JOutPrint.JPrint(new SearchInsertPosition().searchInsert(nums, 7));
        JOutPrint.JPrint(new SearchInsertPosition().searchInsert(nums, 0));

    }
}
