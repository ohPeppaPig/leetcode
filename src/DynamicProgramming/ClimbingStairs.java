package DynamicProgramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbingStairs {
    public int climbStairs(int n) {

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2 ; i <= n ; i ++)
            memo[i] = memo[i - 1] + memo[i - 2];
        return memo[n];
    }

    /**
     *  时间复杂度: O(n)
        空间复杂度: O(1)
     * @param n
     * @return
     */
    public int climbStairs1(int n) {

        if(n <= 0)
            throw new IllegalArgumentException("n must be greater than zero");
        if(n == 1)
            return 1;

        int prev = 1, cur = 1;
        for(int i = 3 ; i <= n + 1; i ++){
            int f = cur + prev;
            prev = cur;
            cur = f;
        }
        return cur;
    }

    // 120 64
}
