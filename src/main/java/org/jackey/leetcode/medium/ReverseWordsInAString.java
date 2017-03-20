package org.jackey.leetcode.medium;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jackey90 on 16/10/19.
 * Given an input string, reverse the string word by word.
 * <p/>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
public class ReverseWordsInAString {

    /**
     * common java way
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        s = s.trim();
        if (s.length() <= 2) {
            return s;
        }
        String[] array = s.split("[ ]+");
        String result = array[array.length - 1];
        for (int i = array.length - 2; i>= 0; i--) {
            result += " " + array[i];
        }
        return result;
    }





    public static void main(String[] args) {
        JOutPrint.JPrint(new ReverseWordsInAString().reverseWords("the sky is blue"));
        JOutPrint.JPrint(new ReverseWordsInAString().reverseWords("  "));
        JOutPrint.JPrint(new ReverseWordsInAString().reverseWords(" 1   3"));
        JOutPrint.JPrint("1    3".split("[ ]+"));
    }


}
