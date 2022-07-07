package org.jackey.datastructure.tree;

public class Bit implements RangeSumQuery{

    private int[] nums;
    private int[] bit;

    public Bit(int[] input){
        this.nums = input;
        this.bit = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            updateBit(i,nums[i]);
        }
    }


    private void updateBit(int index, int diff){
        index = index + 1;
        while(index < bit.length){
            bit[index] += diff;
            index += index&(-index);
        }
    }

    private int sumRangeBit(int index){
        int sum = 0;
        if(index < 0){
            return sum;
        }
        index = index + 1;
        while(index > 0){
            sum += bit[index];
            index -= index&(-index);
        }
        return sum;
    }

    @Override
    public void update(int index, int val) {
        int diff = val - nums[index];
        updateBit(index,diff);
        nums[index] = val;
    }

    @Override
    public int query(int start, int end) {
        return query(end) - query(start - 1);
    }

    @Override
    public int query(int end) {
        int sum = 0;
        if(end < 0){
            return sum;
        }
        end = end + 1;
        while(end > 0){
            sum += bit[end];
            end -= end&(-end);
        }
        return sum;
    }
}
