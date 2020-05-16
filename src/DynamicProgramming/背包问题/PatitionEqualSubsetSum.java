package DynamicProgramming.背包问题;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 注意:
 每个数组中的元素不会超过 100
 数组的大小不会超过 200
 示例 1:

 输入: [1, 5, 11, 5]

 输出: true

 解释: 数组可以分割成 [1, 5, 5] 和 [11].

 */
public class PatitionEqualSubsetSum {
    // 在 n 个物品中选出物品，填满sum/2的背包
    /**
     * 1、不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，
     * 使得它们的和为 j，那么 dp[i][j] = true；

     2、选择 nums[i]，如果在 [0, i - 1] 这个子区间内就得找到一部分元素
     使得它们的和为 j - nums[i]。

     状态转移方程是：

     dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]

     */

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target+1];
        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for(int j = 0;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                    continue;
                }
                if(nums[i]<j){
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];


    }


    public boolean canPartition1(int[] nums) {

        int sum = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            if(nums[i] <= 0)
                throw new IllegalArgumentException("numbers in nums must be greater than zero.");
            sum += nums[i];
        }

        if(sum % 2 == 1)
            return false;

        int n = nums.length;
        int C = sum / 2;

        boolean[] memo = new boolean[C + 1];
        for(int i = 0 ; i <= C ; i ++)
            memo[i] = (nums[0] == i);

        for(int i = 1 ; i < n ; i ++)
            //避免新值的干扰
            for(int j = C; j >= nums[i] ; j --)
                memo[j] = memo[j] || memo[j - nums[i]];

        return memo[C];
    }
}

//322 377 474 139 494