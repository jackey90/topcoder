package org.jackey.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class SlidingWindowMedian {


    public double[] medianSlidingWindow(int[] nums, int k) {
        MediunQueue mq = new MediunQueue(nums,k);
        double[] ret = new double[nums.length - k + 1];
        ret[0] = mq.getMedium();
        for(int i = k; i < nums.length; i++){
            mq.insert(nums[i]);
            mq.remove(nums[i-k]);
            ret[i - k + 1] = mq.getMedium();
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 3;
        new SlidingWindowMedian().medianSlidingWindow(nums,k);
    }
}


class MediunQueue{

    private PriorityQueue<Integer> big = new PriorityQueue<Integer>((o1, o2) -> o2.compareTo(o1));
    private PriorityQueue<Integer> small = new PriorityQueue<Integer>();
    private int bigLength;
    private int smallLength;
    private Map<Integer, Integer> deleteMap = new HashMap<Integer,Integer>();
    private int k;

    public MediunQueue(int[] nums, int k){
        this.k = k;
        for(int i = 0; i < k; i++){
            small.offer(nums[i]);
        }
        smallLength = k;
        bigLength = 0;
        makeBalance();
    }

    public void insert(int num){
        if(num >= small.peek()){
            small.offer(num);
            smallLength++;
        }else{
            big.offer(num);
            bigLength++;
        }
    }

    public double getMedium(){
        if(k % 2 == 1){
            return (double)small.peek();
        }else{
            return ((double)small.peek() + big.peek()) / 2;
        }
    }

    public void remove(int num){
        deleteMap.put(num,deleteMap.getOrDefault(num,0) + 1);
        if(num >= small.peek()){
            smallLength--;
            cleanTop(small);
        }else{
            bigLength--;
            cleanTop(big);
        }
        makeBalance();
    }


    /**
     */
    private void cleanTop(PriorityQueue<Integer> pq){
        if(deleteMap.isEmpty()){
            return;
        }
        while(!pq.isEmpty()){
            int value = pq.peek();
            int deleteCount = deleteMap.getOrDefault(value,0);
            if(deleteCount == 1){
                pq.poll();
                deleteMap.remove(value);
            }else if(deleteCount > 1){
                pq.poll();
                deleteMap.put(value, deleteCount - 1);
            }else{
                break;
            }
        }
    }



    private void makeBalance(){
        int l = k / 2;
        while(bigLength != l){
            if(bigLength > l){
                small.offer(big.poll());
                smallLength++;
                bigLength--;
                cleanTop(big);
            }else{
                big.offer(small.poll());
                bigLength++;
                smallLength--;
                cleanTop(small);
            }
        }
    }

}