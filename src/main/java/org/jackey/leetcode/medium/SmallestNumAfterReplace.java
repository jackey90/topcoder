package main.java.org.jackey.leetcode.medium;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by jackey90 on 16/10/10.
 * You are given an integer X. You must choose two adjacent digits and replace them with the larger of these two digits.
 * <p/>
 * For example, from the integer X = 233614, you can obtain:
 * 33614 (by replacing 23 with 3);
 * 23614 (by replacing 33 with 3 or 36 with 6);
 * 23364 (by replacing 61 with 6 or 14 with 4);
 * <p/>
 * <p/>
 * 2314614    314614 234614 234614  231614     231464    231464
 * <p/>
 * You want to find the smallest number that can be obtained from X by replacing two adjacent digits with the larger of the two. In the above example, the smallest such number is 23364.
 */

/**
 *  solution:
 *
 */
public class SmallestNumAfterReplace {
    public int solution(int x) {
        char[] charArray = (x + "").toCharArray();
        // return the max digit if length == 2
        if(charArray.length == 2){
            return Math.max(Integer.valueOf(charArray[0]), Integer.valueOf(charArray[1]))  - Integer.valueOf('0')  ;
        }

        //find first the decreasing(or equal) digit and the next digit should also be decreasing(or equal)
        int removeIndex = 0;
        for (int i = 1; i < charArray.length ; i++) {
            if (charArray[i] <= charArray[i - 1] && i + 1 < charArray.length && charArray[i + 1] <= charArray[i]) {
                removeIndex = i;
                break;
            }
        }

        //otherwise remove the second last
        if(removeIndex == 0) {
            removeIndex = charArray.length - 2;
        }
        charArray = ArrayUtils.remove(charArray, removeIndex);
        return Integer.valueOf(String.valueOf(charArray));
    }

    public static void main(String[] args) {
        System.out.println(new SmallestNumAfterReplace().solution(233614));   //   23364
        System.out.println(new SmallestNumAfterReplace().solution(13));         // 3
         System.out.println(new SmallestNumAfterReplace().solution(31));          // 3
        System.out.println(new SmallestNumAfterReplace().solution(1234321));      // 123421
        System.out.println(new SmallestNumAfterReplace().solution(4321234));      //421234
         System.out.println(new SmallestNumAfterReplace().solution(177763));       //    17763

    }
}
