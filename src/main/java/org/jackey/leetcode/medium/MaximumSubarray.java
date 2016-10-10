package main.java.org.jackey.leetcode.medium;

/**
 * Created by jackey90 on 16/10/4.
 */
public class MaximumSubarray {

    /**
     *  for example:  array = [-2,1,-3]
     *                max = 1
     *                lMax = -1
     *                rMax = -2
     *                sum = -4
     */
    private class ArrayContext {
        int max; // max sum of the sub array
        int lMax; // max sum begins with the leftmost element
        int rMax; // max sum ends with the rightmost element
        int sum; // sum of all elements

    }

    public ArrayContext getArrayContext(int[] nums, int l, int r) {
        ArrayContext ctx = new ArrayContext();
        if (l == r) {
            // only one element
            ctx.max = nums[l];
            ctx.lMax = nums[l];
            ctx.rMax = nums[l];
            ctx.sum = nums[l];
        } else {
            int m = (l + r) / 2;
            ArrayContext lCtx = getArrayContext(nums, l, m);
            ArrayContext rCtx = getArrayContext(nums, m + 1, r);

            // the max sum of sub array  would be the max of:
            // 1. max of the left sub array
            // 2. max of the right sub array
            // 3. rMax of the left sub array + lMax of the right sub array
            ctx.max = Math.max(Math.max(lCtx.max, rCtx.max), lCtx.rMax + rCtx.lMax);
            ctx.lMax = Math.max(lCtx.lMax, lCtx.sum + rCtx.lMax);
            ctx.rMax = Math.max(rCtx.rMax, rCtx.sum + lCtx.rMax);
            ctx.sum = lCtx.sum + rCtx.sum;
        }

        return ctx;
    }


    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        ArrayContext ctx = getArrayContext(nums, 0, nums.length - 1);
        return ctx.max;
    }



    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}


