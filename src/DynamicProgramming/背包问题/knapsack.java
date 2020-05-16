package DynamicProgramming.背包问题;


public class knapsack {
    /**
     *
     * @param w ：重量
     * @param v ：价值
     * @param C ：背包容量
     * @return
     */
    public int knapsack01(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;
        // 这处的C+1可以类比链表中的虚拟头节点
        // 这样在判断首位是也可以带入后面的转移方程
        // 不然需要额外的进行判断首位
        int[][] memo = new int[n][C + 1];
        // 初始化第一行
        for(int j = 0 ; j <= C ; j ++)
            // 第一行只有一个物品，是否可以放下
            memo[0][j] = (j >= w[0] ? v[0] : 0 );

        for(int i = 1 ; i < n ; i ++)
            for(int j = 0 ; j <= C ; j ++){
                memo[i][j] = memo[i-1][j];
                if(j >= w[i])
                    // 取舍到底放不放这个w[i]
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
            }

        return memo[n - 1][C];
    }
    // 压缩优化解法
    public int knapsack02(int[] w, int[] v, int C){

        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        if(C < 0)
            throw new IllegalArgumentException("C must be greater or equal to zero.");

        int n = w.length;
        if(n == 0 || C == 0)
            return 0;

        int[] memo = new int[C+1];

        for(int j = 0 ; j <= C ; j ++)
            memo[j] = (j >= w[0] ? v[0] : 0);

        for(int i = 1 ; i < n ; i ++)
            // 这里需要从后往前遍历，防止元素被覆盖
            // 因为此时的状态仅与上一次的状态有关
            // 从前往后遍历造成本次修改也会影响后序
            for(int j = C ; j >= w[i] ; j --)
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);

        return memo[C];
    }
    // 完全背包问题
    // 多重背包问题
}
