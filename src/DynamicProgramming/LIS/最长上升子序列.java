package DynamicProgramming.LIS;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。

 示例:

 输入: [10,9,2,5,3,7,101,18]
 输出: 4
 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 说明:

 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 你算法的时间复杂度应该为 O(n2) 。
 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class 最长上升子序列 {
    public int lengthOfLIS1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        // 保存截止到该数字的递增数量
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    // 状态转移方程
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

        }
        int res = 1;
        // 寻找整个数组中的
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;

    }


    // top2
    public static void helper(int[] nums) {
        int left = 0, right = 1;
        int maxLen = 0, prevMaxLen = 0;
        int maxStart = 0, maxEnd = 0;
        int secondStart = 0, secondEnd = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right - 1] < nums[right]) {
                right++;
            }
            if (right - left > maxLen) {
                //更新第二大,第一大变成第二大
                prevMaxLen = maxLen;
                secondStart = maxStart;
                secondEnd = maxEnd;
                //更新第一大
                maxLen = right - left;
                maxStart = left;
                maxEnd = right - 1;
            } else if (right - left > prevMaxLen) {
                //更新第二大，对应着第二长度数组在第一长度数组后面的情况
                prevMaxLen = right - left;
                secondStart = left;
                secondEnd = right - 1;
            }
            // right复制给left重新起航
            left = right;
            right++;
        }
    }
    //376
}
