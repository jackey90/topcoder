package org.jackey.datastructure.tree;


import org.jackey.support.Assert;

/**
 * 思路：[0,n] 数组，考虑树结构，
 *         sum[0,n]
 *    sum[0,n/2]  sum[n/2 + 1]
 *    ......
 *   sum[0]   sum[1] ....  sum[n]
 *
 */
public class SegmentTree implements RangeSumQuery{

    private int[] treeArray;
    private int[] originalArray;

    public SegmentTree(int[] inputArray){
        originalArray = inputArray;
        int length = getTArrayLength(inputArray.length);
        treeArray = new int[length];
        construct(inputArray,0,inputArray.length - 1,-1,true);
    }


    private int construct(int[] inputArray, int oStart, int oEnd, int tParentIndex, boolean tLeft) {
        int index;
        int sum;
        if(tParentIndex == -1){
            index = 0;
        }else if(tLeft){
            index = leftIndex(tParentIndex);
        }else{
            index = rightIndex(tParentIndex);
        }
        if(oStart == oEnd){
            sum = inputArray[oEnd];
        }else {
            int mid = mid(oStart,oEnd);
            sum = construct(inputArray, oStart, mid, index, true) + construct(inputArray, mid + 1, oEnd, index, false);
        }
        treeArray[index] = sum;
        return sum;
    }

    private int findTreeIndex(int i, int oStart, int oEnd, int tIndex){
        if(oStart == oEnd && i == oStart){
            return tIndex;
        }
        int mid = mid(oStart,oEnd);
        if(i <= mid){
            tIndex = leftIndex(tIndex);
            return findTreeIndex(i,oStart,mid,tIndex);
        }else{
            tIndex = rightIndex(tIndex);
            return findTreeIndex(i,mid+1,oEnd,tIndex);
        }
    }


    @Override
    public void update(int i, int value){
        int treeIndex = findTreeIndex(i,0,originalArray.length - 1,0);
        int oldValue = treeArray[treeIndex];
        int diff = oldValue - value;
        treeArray[treeIndex] = value;
        while(treeIndex > 0){
            treeIndex = parentIndex(treeIndex);
            treeArray[treeIndex] = treeArray[treeIndex] - diff;
        }

    }


    @Override
    public int query(int end){
        return query(0,end);
    }

    @Override
    public int query(int start, int end){
        Assert.check(end >= start, "Error input");
        return sum(start,end,0,originalArray.length - 1,0);
    }


    private int sum(int inputStart, int inputEnd,int oStart, int oEnd,int tIndex){
        Assert.check(inputStart >= oStart, "Error input inputStart");
        Assert.check(inputEnd <= oEnd, "Error input inputEnd");
        if(inputStart == oStart && inputEnd == oEnd){
            return treeArray[tIndex];
        }
        int oMid = mid(oStart,oEnd);
        if(inputEnd <= oMid){
            return sum(inputStart,inputEnd,oStart,oMid,leftIndex(tIndex));
        }
        if(inputStart > oMid){
            return sum(inputStart,inputEnd,oMid + 1,oEnd,rightIndex(tIndex));
        }
        return sum(inputStart,oMid,oStart,oMid,leftIndex(tIndex))
                + sum(oMid+1,inputEnd,oMid+1,oEnd,rightIndex(tIndex));
    }

    private int mid(int start ,int end){
        return start + (end - start) / 2;
    }



    private int parentIndex(int current){
        return (current - 1) / 2;
    }

    private int leftIndex(int current){
        return 2 * current + 1;
    }

    private int rightIndex(int current){
        return 2 * current + 2;
    }

    private int getTArrayLength(int n){
        int heigth = (int)Math.ceil(Math.log(n)/Math.log(2));
        return 2 * (int)Math.pow(2,heigth);
    }

}
