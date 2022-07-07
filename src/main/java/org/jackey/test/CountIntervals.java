package org.jackey.test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class CountIntervals {

    PriorityQueue<int[]> queue;
    List<int[]> allList;
    private int cache = -1;
    public CountIntervals() {
        queue = new PriorityQueue<int[]>((o1,o2)->{
            if(o1[0] == o2[0]){
                if(o1[1] == o2[1]){
                    return 0;
                }else{
                    return o1[1] < o2[1] ? 1 : -1;
                }
            }else{
                return o1[0] < o2[0] ? -1 : 1;
            }
        });
        allList = new ArrayList();
    }

    public void add(int left, int right) {
        int[] one = new int[]{left, right, right - left + 1};
        allList.add(one);
        cache = -1;
    }

    public int count() {
        if(cache > 0){
            return cache;
        }
        List<int[]> temp = new ArrayList();
        for(int[] a: allList){
            queue.offer(a);
        }
        int cnt = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int l = cur[0];
            int r = cur[1];
            while(!queue.isEmpty() && queue.peek()[1] <= r){
                queue.poll();
            }
//            int[] one = queue.poll();
//            l = one[0];
            while(!queue.isEmpty() && queue.peek()[0] <= r){
                r = Math.max(queue.poll()[1],r);
            };
            int tempCnt = r - l + 1;
            int[] newOne = new int[]{l,r,tempCnt};
            temp.add(newOne);
            cnt += tempCnt;
        }
        allList = temp;
        cache = cnt;
        return cache;
    }

}
