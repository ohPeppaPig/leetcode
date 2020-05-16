package DynamicProgramming;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

 示例:

 输入: 3
 输出: 5
 解释:
 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class 不同的二叉搜索树 {
    /**
     * 对于数字n：[1,2,3,..,n]选择一个为根节点，其左子树和右子树都是有序的，可以复用
     dp[j-1]为左子树的排列方式种树
     dp[i-j]为左子树的排列方式种树

     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i < n+1; i++) { // 从1...n的二叉搜索数数目
            for (int j = 1; j < i+1; j++) { //// 逐步选用1...n作为根节点
                dp[i] += dp[j-1]*dp[i-j]; // 左侧j-1个数，右侧i-j个数
            }
            
        }
        return dp[n];
        
    }
}
