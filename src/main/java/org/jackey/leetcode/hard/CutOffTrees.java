package org.jackey.leetcode.hard;

import org.jackey.base.BaseCase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class CutOffTrees extends BaseCase {

    public static void main(String[] args) {
        new CutOffTrees().doTest("cutOffTree");
    }

    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int cutOffTree(List<List<Integer>> forest) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if(a[2] == b[2]){
                return a[3] - b[3];
            }else{
                return a[2] > b[2] ? 1 : -1;
            }
        });
        Deque<int[]> queue = new ArrayDeque<int[]>();
        int m = forest.size();
        int n = forest.get(0).size();
        int allCnt = 0;
        for(int i = 0; i < forest.size(); i++){
            for(int j = 0; j < forest.get(i).size(); j++){
                if(i == 0 && j == 0){
                    continue;
                }
                if(forest.get(i).get(j) >= 1){
                    allCnt++;
                }
            }
        }
        int step = 0;
        int firstValue = forest.get(0).get(0);
        int[] first = new int[]{0, 0, firstValue,step};
        queue.offerLast(first);
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++){
                int[] p = queue.pollFirst();
                pq.offer(p);
                int x = p[0];
                int y = p[1];
                for(int[] dir: directions){
                    int x1 = x + dir[0];
                    int y1 = y + dir[1];
                    if(x1 >= m || x1 < 0 || y1 >= n || y1 < 0 || vis[x1][y1] || forest.get(x1).get(y1) == 0){
                        continue;
                    }
                    vis[x1][y1] = true;
                    queue.offerLast(new int[]{x1,y1,forest.get(x1).get(y1),step});
                }
            }
        }
        if(pq.size() != allCnt + 1){
            return -1;
        }
        int ret = 0;
        int[] f1 = {0,0,0,0};
        //System.out.println(pq);
        while(!pq.isEmpty()){
            int[] f2 = pq.poll();
            ret += Math.abs(f1[3] - f2[3]);
            f1 = f2;
        }
        return ret;
    }

}
