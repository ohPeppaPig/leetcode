package DynamicProgramming;

import javax.swing.border.EtchedBorder;
import java.util.Arrays;

public class 换零钱 {

    /**
     * 给定不同面额的硬币 coins 和一个总金额 amount。
     * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 给定不同面额的硬币和一个总金额。
     * 写出函数来计算可以凑成总金额的硬币组合数。
     * 假设每一种面额的硬币有无限个。
     */
    public final int coinChangeII(int[] coins,int amount){
        int[] dp = new int[coins.length+1];
        dp[0] = 1;
        for (int coin:
             coins) {
            for (int i = 1; i < amount; i++) {
                if(i>coin){
                    dp[i] = dp[i] + dp[i-1];
                }

            }
        }
        return dp[amount];
    }

}
