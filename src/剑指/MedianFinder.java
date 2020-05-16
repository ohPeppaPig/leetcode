package 剑指;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    Queue<Integer> max;
    Queue<Integer> min;
    int count;

    public MedianFinder() {
        //默认最小堆
        max = new PriorityQueue<>((v1, v2) -> v2 - v1);
        min = new PriorityQueue<>();
        count = 0;
    }

    public void addNum(int num) {
        //先放最大堆，左边的
        if (count % 2 == 0) {
            max.offer(num);
            int maxNum = max.poll();
            min.offer(maxNum);
        } else {
            min.offer(num);
            int minNum = min.poll();
            max.offer(minNum);
        }
    }

    public double findMedian() {
        if (count % 2 == 1) {
            return new Double(min.peek());
        } else {
            return new Double((min.peek() + max.peek())) / 2;
        }
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = grid[0][i];
//        }
//        for (int i = 1; i < m; i++) {
//            dp[0] = dp[0]+grid[i][0];
//            for (int j = 1; j <n; j++) {
//                dp[j] = Math.max(dp[j],dp[j-1])+grid[i][j];
//            }
//        }
//        return dp[n-1];
        //定为n+1是为了防止数组在取0时越位
//        int[] dp = new int[n+1];
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                dp[j] = Math.max(dp[j],dp[j-1])+grid[i-1][j-1];
//            }
//        }
//        return dp[n+1];

    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int l = 0,r = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            while(set.contains(c)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(c);
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            if(dp[i] == dp[p2]*2) p2++;
            if(dp[i] == dp[p3]*3) p3++;
            if(dp[i] == dp[p5]*5) p5++;
        }
        return dp[n-1];
    }

}
