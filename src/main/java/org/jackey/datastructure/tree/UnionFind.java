package org.jackey.datastructure.tree;

public class UnionFind {

    private int[] parents;
    private int[] ranks;

    public UnionFind(int n){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }

    public int find(int x){
        if(parents[x] != x){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(ranks[px] > ranks[py]){
            parents[py] = px;
        }else if(ranks[px] < ranks[py]){
            parents[px] = py;
        }else{
            parents[py] = px;
            ranks[px]++;
        }
    }


}
