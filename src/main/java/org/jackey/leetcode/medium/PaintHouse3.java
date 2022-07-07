package org.jackey.leetcode.medium;

import org.jackey.base.BaseCase;

public class PaintHouse3 extends BaseCase {


    public static void main(String[] args) {
        new PaintHouse3().doTest("minCost");
    }

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        int[][][] dp = new int[m + 1][target + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= target; j++){
                for(int x = 1; x <= n; x++){
                    if(i == 0 && j == 0){
                        dp[i][j][x] = 0;
                    }else if((j == 0 & i != 0) || j > i){
                        dp[i][j][x] = Integer.MAX_VALUE;
                    } else{
                        if(houses[i - 1] == 0 || houses[i-1] == x){
                            int c = cost[i -1][x - 1];
                            int min1 = dp[i - 1][j][x];
                            int min2 = findMin(dp,i-1,j-1,x,n);
                            // workd
                            dp[i][j][x] = Math.min(min1,min2);
                            if(dp[i][j][x] < Integer.MAX_VALUE){
                                dp[i][j][x] += c;
                            }
                        }else{
                            dp[i][j][x] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            min = Math.min(min,dp[m][target][i]);
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }

    private int findMin(int[][][] dp, int i, int j, int x, int n){
        int min = Integer.MAX_VALUE;
        for(int y = 1; y <= n; y++){
            if(y == x){
                continue;
            }
            min = Math.min(min,dp[i][j][y]);
        }
        return min;
    }
}
