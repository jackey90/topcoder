package org.jackey.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        new MinimumWindowSubstring().minWindow(s,t);
    }

    /**
     DACOBECCAODECBANC
     ABCC   A-1 B-1 C-2

     Map<Character,Integer> countMap;  int cLength size of map(count > 1)

     ------------------------------
     countMap={A-1 B-1 C-2}  cLength = 0
     l
     r
     DACOBECCAODECBANC



     */
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        //1 init
        Map<Character,Integer> countMap = countMap(t);
        int cLength = countMap.size();
        int l = 0;
        int r = -1;
        int minL = 0;
        int minR = s.length();
        char[] sArray = s.toCharArray();
        while(l < sArray.length && r < sArray.length){
            if(cLength == 0){
                if(r - l < minR - minL){
                    minR = r;
                    minL = l;
                }
                char lc = sArray[l];
                Integer rcCount = countMap.get(lc);
                if(rcCount != null){
                    countMap.put(lc,rcCount+1);
                    if(rcCount == 0){
                        cLength++;
                    }
                }
                l++;
                continue;
            }else if(r == sArray.length - 1){
                break;
            }

            char rc = sArray[r + 1];
            Integer rcCount = countMap.get(rc);
            if(rcCount != null ){
                countMap.put(rc,rcCount - 1);
                if(rcCount == 1){
                    cLength--;
                }
            }
            r++;
        }
        if(minR == s.length()){
            return "";
        }
        return s.substring(minL, minR + 1);
    }

    private Map<Character,Integer> countMap(String t){
        Map<Character,Integer> countMap = new HashMap();
        for(char c: t.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0) + 1);
        }
        return countMap;
    }

}