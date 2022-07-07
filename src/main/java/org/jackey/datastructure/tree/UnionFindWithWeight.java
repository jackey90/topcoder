package org.jackey.datastructure.tree;


/**
 *  1    1   3   3   4
 *  a -> b   c ->d   e
 *  2    1   3   1   1
 *  union x=a y=c value=4
 *  x = a  y = c  rootx=b rooty=d
 *
 *
 */
public class UnionFindWithWeight {

    int[] parents;
    double[] weights;

    public UnionFindWithWeight(int n){
        parents = new int[n];
        weights = new double[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
            weights[i] = 1L;
        }
    }

    public void union(int x, int y, double value){
        int px = find(x);
        int py = find(y);
        if(px == py){
            return;
        }
        parents[px] = py;
        weights[px] = weights[y] * value  / weights[x];
    }

    public int find(int x){
        if(x != parents[x]){
            int parent = parents[x];
            parents[x] = find(parents[x]);
            weights[x] = weights[x] * weights[parent];
        }
        return parents[x];
    }

    public double isConnected(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py){
            return weights[x] / weights[y];
        }else{
            return -1d;
        }
    }

}
