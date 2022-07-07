package org.jackey.test;

import org.jackey.base.BaseCase;

import java.util.Arrays;

public class Weekly1 extends BaseCase {

    public static void main(String[] args) {
        Weekly1 w = new Weekly1();
        w.doTest("largestVariance");
    }

    public int largestVariance(String s) {
        int n = s.length();
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = getValue(s,i,j);
                ret = Math.max(ret, temp);
            }
        }
        return ret;
    }

    private int getValue(String s, int l, int r){
        int maxCnt = 1;
        int minCnt = 1;
        int[] map = new int[26];
        int ret = 0;
        for(int i = l; i <= r; i++){
            char c = s.charAt(i);
            int index = (int)(c - 'a');
            map[index]++;
        }
        for(int i = 0; i < 26; i++){
            if(map[i] == 0){
                continue;
            }
            if(map[i] > maxCnt){
                maxCnt = map[i] ;
            }
            if(map[i] < minCnt){
                minCnt = map[i] ;
            }
        }
        return maxCnt - minCnt;
    }

}
