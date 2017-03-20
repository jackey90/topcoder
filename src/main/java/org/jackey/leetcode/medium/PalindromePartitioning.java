package org.jackey.leetcode.medium;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackey90 on 15/11/3.
 * <p/>
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p/>
 * Return all possible palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return
 * <p/>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        parition(s, 0, 1, s.length(), new ArrayList<String>(), result);
        return result;
    }

    private boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }
        int leng = str.length();
        int mid = (leng - 1) / 2;

        for (; mid >= 0; mid--) {
            if (str.charAt(mid) != str.charAt(leng - 1 - mid)) {
                return false;
            }
        }
        return true;
    }

    private void parition(String s, int start, int k, int end, List<String> subList, List<List<String>> list) {
        if (k >= end) {
            if (isPalindrome(subList.get(subList.size() - 1))) {
                list.add(new ArrayList<String>(subList));
            }
            return;
        }

        while(k < end) {
            String s1 = s.substring(start, k);
            if (isPalindrome(s1)) {
                subList.add(s1);
                parition(s, k, k + 1, end  ,subList, list);
            } else {
                parition(s, start, k + 1,end, subList, list);
            }
        }
    }


    public static void main(String[] args) {
        //JOutPrint.JPrint(new PalindromePartitioning().isPalindrome("ab"));
        JOutPrint.JPrint(new PalindromePartitioning().partition("abbaa"));
    }
}
