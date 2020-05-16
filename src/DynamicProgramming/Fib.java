package DynamicProgramming;

import java.util.Arrays;

public class Fib {

    /**
     * 自上而下，记忆化搜索
     * @param n
     * @return
     */
    public int fib(int n){

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n, memo);
    }

    private int fib(int n, int[] memo){

        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        if(memo[n] == -1)
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);

        return memo[n];
    }

    /**
     * 自下而上，动态规划
     * @param n
     * @return
     */
    public int fib1(int n){

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];

        return memo[n];
    }
}
