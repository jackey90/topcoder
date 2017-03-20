package org.jackey.leetcode.medium;

import org.jackey.kingbox.jtool.inAndOut.JOutPrint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackey90 on 15/10/12.
 *  using backtracking!!!(https://leetcode.com/discuss/31250/backtracking-solution-java)
 *
 *
 * <p/>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p/>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p/>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if( k > 0 && n >= 1){
            combine(result,new ArrayList<Integer>(),1,n,k);
        }


        return result;



    }


    private void combine(List<List<Integer>> list, List<Integer> subList,int start, int n, int k){

        if(k == 0){
            list.add(new ArrayList<Integer>(subList));
            return;
        }
        for(int i = start; i <= n; i++){
            subList.add(i);
            combine(list, subList, i + 1, n, k - 1);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        JOutPrint.JPrint(new Combinations().combine(4,2));
    }

}
