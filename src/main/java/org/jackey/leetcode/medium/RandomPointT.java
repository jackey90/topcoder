package org.jackey.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RandomPointT {

    public static void main(String[] args) {
        int[][] input = {{82918473,-57180867,82918476,-57180863},
                {83793579,18088559,83793580,18088560},
                {66574245,26243152,66574246,26243153},
                {72983930,11921716,72983934,11921720}};
        RandomPoint r = new RandomPoint(input);
        int i = 0;
        Map<String,Integer> cntMap = new TreeMap();
        while(i++ < 10000){
            int[] one = r.pick();
            if(!r.inRects(one)){
                System.out.println(one);
            }
            String key = one[0] + "-" + one[1];
            cntMap.put(key,cntMap.getOrDefault(key,0) + 1);
        }
        System.out.println(cntMap);
    }

}
