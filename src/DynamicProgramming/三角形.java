package DynamicProgramming;

import java.util.List;

public class 三角形 {
//    public int minimumTotal(List<List<Integer>> triangle) {
//        // 特判
//        if (triangle == null || triangle.size() == 0) {
//            return 0;
//        }
//        // 加1可以不用初始化最后一行
//        // 根据题意，行列值相同
//        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
//
//        for (int i = triangle.size() - 1; i >= 0; i--) {
//            List<Integer> rows = triangle.get(i);
//            for (int j = 0; j < rows.size(); j++) {
//                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + rows.get(j);
//            }
//        }
//        return dp[0][0];
//    }


    public int minimumTotal2(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp中记录了求第i行时，第i+1的最小路径和
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
            }
        }
        return dp[0];
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        if(triangle == null||triangle.size() == 0){
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        // 初始化
        for (int i = 0; i < triangle.size(); i++) {
            dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+rows.get(j);
            }

        }
        return dp[0][0];

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null||triangle.size() == 0){
            return 0;
        }
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                dp[j] = Math.min(dp[j],dp[j+1])+rows.get(j);
            }
        }
        return dp[0];
    }

}
