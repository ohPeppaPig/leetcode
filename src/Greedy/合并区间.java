package Greedy;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

 示例 1:

 输入: [[1,3],[2,6],[8,10],[15,18]]
 输出: [[1,6],[8,10],[15,18]]
 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

 */
public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][0];
        }
        // 按起点进行排序
        Arrays.sort(intervals,(v1,v2)->v1[0]-v2[0]);
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            // 如果前一个重点大于后一个起点，可以合并
            if(res[i][1]>intervals[j][0]){
                res[i][1] = Math.max(res[i][1],intervals[j][1]);
            }else {
                // 放入结果
                res[++i] = intervals[j];
            }

        }
        return Arrays.copyOf(res,i+1);

    }




}
