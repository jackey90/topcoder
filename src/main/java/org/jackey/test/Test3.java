package org.jackey.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test3 {

    // merge
    //[1,3)   [1,5）   [4,9）    [10,11)
    //throw error


    //List ret last value, l,r
    //1. if l1=l，r取最大值 [1,5）
    //2  l < l1 < r , r1 > r throw error
    //3  l1 > r add l1,r1


    //[1,5]   [2,4]    [10,11]
    //[1,5] [10,11]

    //[1,5]   [1,5]    [10,11]
    //[1,5] [10,11]

    //[1,3]   [1,5]    [10,11]
    //[1,5] [10,11]


    public List<int[]> mergetRange(List<int[]> list){
        //sort
        Collections.sort(list, (o1,o2) -> {
            if(o1[0] > o2[0]){
                return 1;
            }else if(o1[0] < o2[0]){
                return -1;
            }else{
                return 0;
            }
        });
        List<int[]> ret = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            int[] one = list.get(i);
            int l1 = one[0];
            int r1 = one[1];
            if(ret.size() == 0 || ret.get(ret.size() - 1)[1] < l1){
                ret.add(new int[]{l1,r1});
            } else if(l1 == ret.get(ret.size() - 1)[0]){
                ret.get(ret.size() - 1)[1] = Math.max(ret.get(ret.size() - 1)[1] , r1);
            } else if(r1 > ret.get(ret.size() - 1)[1]){
                throw new RuntimeException("invalid");
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Test3 t = new Test3();
        List<int[]> input = new ArrayList<>();
        input.add(new int[]{2,3});
        input.add(new int[]{1,5});
        //input.add(new int[]{4,9});
        input.add(new int[]{10,11});
        List<int[]> ret = t.mergetRange(input);
        System.out.println(ret);
    }

}
