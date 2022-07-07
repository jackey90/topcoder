package org.jackey.algorithms.dp;


import org.jackey.base.BaseCase;

public class ChangeCoin2 extends BaseCase {


    public static void main(String[] args) {
        new ChangeCoin2().doTest("change");
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }


}
