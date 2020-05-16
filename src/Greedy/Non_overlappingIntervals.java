package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

 注意:

 可以认为区间的终点总是大于它的起点。
 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 示例 1:

 输入: [ [1,2], [2,3], [3,4], [1,3] ]

 输出: 1

 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */

//贪心选择性质：每次选择不影响其他的
public class Non_overlappingIntervals {
    /**
     *  按照区间的结尾排序，每次选择结尾最早的，且和前一个区间不重叠的区间
     */
//    public int eraseOverlapIntervals(int[][] intervals) {
//        if (intervals.length == 0) {
//            return 0;
//        }
//        Arrays.sort(intervals,new Comparator<int [] >(){
//            @Override
//            public int compare(int [] a1, int [] a2) {
//                return a1[1] - a2[1];   //升序排列
//            }
//        });
//        //最多能组成的不重叠区间个数
//        int count = 1;
//        int end = intervals[0][1];
//        for (int i = 0; i < intervals.length; i++) {
//            // 区间不重叠
//            if (intervals[i][0] < end) {
//                continue;
//            }
//            // 更新end
//            end = intervals[i][1];
//            count++;
//        }
//        return intervals.length - count;
//    }
    // 279

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals,(v1,v2)->(v1[1]-v2[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int[] temp :
                intervals) {
            if (temp[0] < end) {
                continue;
            }
            end = temp[1];
            count++;
        }
        return intervals.length-count;
    }
}
