package org.jackey.leetcode.medium;


/**
 * Created by jackey90 on 16/9/26.
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() <= 0 ){
            return 0;
        }

        int max = 0;
        int start = 0;

        int[] map = new int[256];
        for(int i = 0; i < map.length; i++){
            map[i] = -1;
        }
        for(int i = 0 ; i < s.length(); i++){

            char a = s.charAt(i);
            int lastIndex = map[a];
            if(lastIndex >= start){
                start = lastIndex + 1;
            }
            map[a] = i;

            max = Math.max(i - start + 1, max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
