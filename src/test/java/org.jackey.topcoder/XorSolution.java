package org.jackey.topcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class XorSolution {

    public static void main(String[] args) {
        int[] nums = {32,18,33,42,29,20,26,36,15,46};
        System.out.println( new XorSolution().findMaximumXOR(nums));
    }

    /**

     */
    private List<TwoList> resultList = new ArrayList<>();

    public int findMaximumXOR(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i: nums){
            list.add(i);
        }

        int firstOneIndex = 31;
        boolean found = false;
        for(;firstOneIndex>=0;firstOneIndex--){
            for(int i: list){
                if(getBit(i,firstOneIndex) == 1){
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        ArrayList<Integer>[] array =  seperate(list,firstOneIndex);
        TwoList twoList = new TwoList(array[0],array[1],0);
        resultList.add(twoList);
        for(int i = firstOneIndex - 1; i >= 0; i--){
            List<TwoList> oneResult = new ArrayList<>();
            for(TwoList tl: resultList){
                oneResult.addAll(splitList(tl,i));
            }

            resultList = oneResult.stream().filter(o -> o.xOR == 1).collect(Collectors.toList());
            if(resultList.size() == 0){
                resultList = oneResult.stream().filter(o -> o.xOR == 0).collect(Collectors.toList());
            }
        }
        TwoList resultTl = resultList.get(0);
        if(resultTl.iList.size() == 0 || resultTl.jList.size() == 0){
            return 0;
        }
       return resultTl.iList.get(0) ^ resultTl.jList.get(0);
    }


    private List<TwoList> splitList(TwoList twoList, int kBit){
        List<Integer> iList = twoList.iList;
        List<Integer> jList = twoList.jList;
        ArrayList<Integer>[] array1 = seperate(iList,kBit);
        ArrayList<Integer>[] array2 = seperate(jList,kBit);
        List<TwoList> list = new ArrayList();
        if(array1[0].size() > 0 && array2[1].size() > 0){
            list.add(new TwoList(array1[0],array2[1],1));
        }
        if(array1[1].size() > 0 && array2[0].size() > 0){
            list.add(new TwoList(array1[1],array2[0],1));
        }
        if(list.size() > 0){
            return list;
        }
        if(array1[0].size() > 0 && array2[0].size() > 0){
            list.add(new TwoList(array1[0],array2[0],0));
        }
        if(array1[1].size() > 0 && array2[1].size() > 0){
            list.add(new TwoList(array1[1],array2[1],0));
        }
        if(iList.size() > 0 && jList.size() == 0){
            list.add(new TwoList(array1[0],array1[1],0));
        }
        if(iList.size() == 0 && jList.size() > 0){
            list.add(new TwoList(array2[0],array2[1],0));
        }
        return list;
    }

    private ArrayList<Integer>[] seperate(List<Integer> list,int k){
        ArrayList<Integer>[] array = new ArrayList[2];
        array[0] = new ArrayList();
        array[1] = new ArrayList();
        for(Integer i : list){
            //System.out.println(getBit(i,k));
            array[getBit(i,k)].add(i);
        }
        return array;
    }

    int getBit(int n, int k) {
        return (n >> k) & 1;
    }

}

class TwoList{
    List<Integer> iList;
    List<Integer> jList;
    int xOR;

    public TwoList(List<Integer> iList, List<Integer> jList,int xOR){
        this.iList = iList;
        this.jList = jList;
        this.xOR = xOR;
    }
}