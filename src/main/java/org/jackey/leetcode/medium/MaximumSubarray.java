package org.jackey.leetcode.medium;

/**
 * Created by jackey90 on 16/10/4.
 */
public class MaximumSubarray {

    /**
     * O(n) without divide and conquer
     */
    public int maxSubArrayOnWithOutDivide1(int[] nums) {
        int max = nums[0];
        int iMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            iMax = Math.max(iMax + nums[i], nums[i]);
            max = Math.max(iMax, max);
        }
        return max;
    }

    /**
     * O(n) without divide and conquer
     */
    public int maxSubArrayOnWithOutDivide2(int[] nums) {
        int max = nums[0];
        int iMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            iMax += nums[i];
            max = Math.max(iMax, max);
            if(iMax < 0){
                iMax = 0;
            }
        }
        return max;
    }

    /**
     *  using divide and conquer but with O(nLogn)
     * @return
     */
    public int maxSubArrayOnlognUseDivide(int[] A,int left, int right){
        if(left == right){return A[left];}
        int mid = left + (right - left) / 2;
        int leftSum = maxSubArrayOnlognUseDivide(A, left, mid);// left part
        int rightSum = maxSubArrayOnlognUseDivide(A,mid+1,right);//right part
        int crossSum = crossSubarray(A,left,right);// cross part
        if(leftSum >= rightSum && leftSum >= crossSum){// left part is max
            return leftSum;
        }
        if(rightSum >= leftSum && rightSum >= crossSum){// right part is max
            return rightSum;
        }
        return crossSum; // cross part is max
    }


    public int crossSubarray(int[] A,int left,int right){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for(int i = mid; i >= left ; i--){
            sum = sum + A[i];
            if(leftSum < sum){
                leftSum = sum;
            }
        }
        sum = 0;
        for(int j = mid + 1; j <= right; j++){
            sum = sum + A[j];
            if(rightSum < sum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    //************  O(n)  divide and conquer
    /**
     * for example:  array = [-2,1,-3]
     * max = 1
     * lMax = -1
     * rMax = -2
     * sum = -4
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
        int[] nums = {-1,  -2,-3};
        System.out.println(new MaximumSubarray().maxSubArrayOnWithOutDivide1(nums));
        System.out.println(new MaximumSubarray().maxSubArrayOnWithOutDivide2(nums));
    }
}


