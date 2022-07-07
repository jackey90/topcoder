package org.jackey.leetcode.medium;


import java.util.*;

class LongestSubStringKRepeat {

    public static void main(String[] args) {
        String s = "aabaacbaccc";
        int k = 3;
        new LongestSubStringKRepeat().longestSubstring(s,k);
    }

    public int longestSubstring(String s, int k) {
        char[] charArray = s.toCharArray();
        return longestSubstring(charArray,0,charArray.length-1,k);
    }

    private int longestSubstring(char[] charArray, int start, int end, int k){
        if(end - start + 1 < k){
            return 0;
        }
        Map<Character,RangeAndCount> map = new HashMap();
        for(int i = start; i <= end; i++){
            char c = charArray[i];
            RangeAndCount rac = map.get(c);
            if(rac == null){
                rac = new RangeAndCount(c,i);
                map.put(c,rac);
            }
            rac.putIn(i);
        }

        int all = map.size();
        List<RangeAndCount> smaller = new ArrayList();
        for(RangeAndCount rangeCount:map.values()){
            if(rangeCount.count < k){
                smaller.add(rangeCount);
            }
        }
        if(smaller.size() == 0){
            return end - start + 1;
        }else if(map.size() == smaller.size()){
            return 0;
        }

        Collections.sort(smaller);
        int left = start;
        int max = 0;
        int l;
        int r;
        for(RangeAndCount rac: smaller){
            if(left < rac.l){
                l = left;
                r = rac.l - 1;
                max = Math.max(longestSubstring(charArray,l,r,k),max);
                left = rac.r + 1;
            } else {
                left = rac.r + 1;
            }
            if(left > end){
                break;
            }
        }
        if(left <= end){
            r = end;
            max = Math.max(longestSubstring(charArray,left,r,k),max);
        }
        return max;
    }


    private Counter<Character> count(char[] charArray, int start, int end){
        Counter<Character> counter = new Counter();
        for(int i = start; i <= end; i++){
            counter.addTo(charArray[i]);
        }
        return counter;
    }

}

class RangeAndCount<T> implements Comparable<RangeAndCount<T>>{
    int l;
    int r;
    int count;
    T t;

    public RangeAndCount(T t, int l){
        this.t = t;
        this.l = l;
        r = l;
        this.count = 0;
    }

    public void putIn(int r){
        if(r > this.r){
            this.r = r;
        }
        count++;
    }

    @Override
    public int compareTo(RangeAndCount other){
        return this.l < other.l ? -1 : 1;
    }
}

class Counter<T> extends HashMap<T,Integer>{

    public void addTo(T t){
        this.put(t, this.getOrDefault(t, 0) + 1);
    }

    public void rmFrom(T t){
        Integer count  = this.get(t);
        if(count == 1){
            this.remove(t);
        }else{
            this.put(t, count - 1);
        }
    }

}



