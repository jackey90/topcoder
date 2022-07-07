package org.jackey.leetcode.medium;

import org.jackey.base.BaseCase;

import java.util.concurrent.ThreadLocalRandom;

class RandomPoint {


    private int[][] rects;
    private long[] starts;
    long all;
    public RandomPoint(int[][] rects) {
        this.rects = rects;
        int n = rects.length;
        long lastEnd = -1;
        this.starts = new long[n];
        for(int i = 0; i < n; i++){
            int[] p = rects[i];
            starts[i] = lastEnd + 1;
            lastEnd += (p[2] - p[0] + 1) * (p[3] - p[1] + 1);
        }
        all = lastEnd;
    }

    public int[] pick() {
        long loc = ThreadLocalRandom.current().nextLong(all + 1);
        int index = findIndex(loc);
        int[] p = rects[index];
        int[] ret =  findPos(loc - starts[index], p);
        return ret;
    }

    private int[] findPos(long diff, int[] p){
        // System.out.println(diff  + " " + p[0] + " " + p[1] + " " +p[2] + " " +p[3]);
        long yDiff = diff / (p[2] - p[0] + 1);
        long xDiff = diff % (p[2] - p[0] + 1);
        return new int[]{(int)(p[0] + xDiff), (int)(p[1] + yDiff)};
    }

    private int findIndex(long loc){
        int start = 0;
        int end = starts.length - 1;
        while(start <= starts.length - 1 && end >= 0 && start <= end){
            int mid = start + (end - start)/2;
            if(starts[mid] > loc){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

    public boolean inRects(int[] p){
        for(int[] rec: rects){
            if(inOneRec(p,rec)){
                return true;
            }
        }
        return false;
    }

    private boolean inOneRec(int[] p, int[] rec){
        return p[0] >= rec[0] && p[0] <= rec[2] && p[1] >= rec[1] && p[1] <= rec[3];
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */