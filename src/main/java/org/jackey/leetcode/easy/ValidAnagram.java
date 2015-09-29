package main.java.org.jackey.leetcode.easy;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

/**
 * Created by jackey90 on 15/9/29.
 * <p/>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p/>
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p/>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */


public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int len = s.length();

        if(len != t.length()){
            return false;
        }

        for(int i = 0; i < len; i++){
            if(s.charAt(i) != t.charAt(len - 1 - i)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        JOutPrint.JPrint(new ValidAnagram().isAnagram("asdffgh","hgfdsa"));
    }
}
