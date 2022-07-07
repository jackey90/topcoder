package org.jackey.topcoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{95, 45, 87, 65, 21, 64, 19, 24, 38, 71, 6, 68, 45, 90, 49, 72, 73, 87, 51, 61, 53, 39, 27, 99, 35, 27, 35, 91, 43, 11, 30, 56, 76, 61, 52, 54, 54, 64, 18, 47, 57, 95};
        int k = 57;
        long x = new Test1().minimalKSum(arr1, k);
        System.out.println(x);
        args[0].substring(0,0);
    }

    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);

        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        int ret = 0;
        for (int i = 1; ; i++) {
            if (set.contains(i)) {
                continue;
            }
            ret += i;
            k--;
            if (k == 0) {
                break;
            }
        }
        return ret;

    }

}
