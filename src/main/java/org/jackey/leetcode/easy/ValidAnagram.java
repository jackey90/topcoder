package org.jackey.leetcode.easy;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

import java.util.HashMap;
import java.util.Map;

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

    private Map<Character,Integer> map = new HashMap<Character,Integer>();

    public boolean isAnagram(String s, String t) {
        int len = s.length();

        if(len != t.length()){
            return false;
        }

        for(int i = 0; i < len; i++){
            char tmpS = s.charAt(i);
            char tmpT = t.charAt(i);
            if(map.containsKey(tmpS)){
                map.put(tmpS,map.get(tmpS) + 1);
            }else{
                map.put(tmpS,1);
            }

            if(map.containsKey(tmpT)){
                map.put(tmpT,map.get(tmpT) - 1);
            }else{
                map.put(tmpT,-1);
            }
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            if(entry.getValue() != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        JOutPrint.JPrint(new ValidAnagram().isAnagram("abc","bac"));
    }
}
