package DynamicProgramming;

import java.util.Arrays;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
 * 返回你可以获得的最大乘积。

 示例 1:

 输入: 2
 输出: 1
 解释: 2 = 1 + 1, 1 × 1 = 1。

 */
public class IntegerBreak {
    /**
     * 递归法
     * @param n
     * @return
     */
    private int breakInteger(int n){

        if(n == 1)
            return 1;

        int res = -1;
        for(int i = 1 ; i <= n - 1 ; i ++)
            // 当前结果值，不再分割，继续分割 三者中的最大值
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }


    /**
     * 使用记忆存储
     */
    private int[] memo;
    public int integerBreak1(int n) {

        if(n < 1)
            throw new IllegalArgumentException("n should be greater than zero");

        memo = new int[n+1];
        Arrays.fill(memo, -1);

        return breakInteger1(n);
    }
    private int breakInteger1(int n){

        if(n == 1)
            return 1;

        if(memo[n] != -1)
            return memo[n];

        int res = -1;
        for(int i = 1 ; i <= n - 1 ; i ++)
            res = max3(res, i * (n - i) , i * breakInteger1(n - i));
        memo[n] = res;
        return res;
    }
    public int integerBreak2(int n) {

        if(n < 1)
            throw new IllegalArgumentException("n should be greater than zero");

        int[] memo = new int[n+1];
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++)
            // 求解memo[i]
            for(int j = 1 ; j <= i - 1 ; j ++)
//                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
                memo[i] = Math.max(memo[i],Math.max(j*(i-j),j*memo[i-j]));

        return memo[n];
    }

}

//279 91 62 63
