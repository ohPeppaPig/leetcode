package HashTable;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。

 示例 1:

 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2]
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        TreeSet<Integer> record = new TreeSet<Integer>();
        for(int num: nums1)
            record.add(num);

        TreeSet<Integer> resultSet = new TreeSet<Integer>();
        for(int num: nums2)
            if(record.contains(num))
                resultSet.add(num);

        int[] res = new int[resultSet.size()];
        int index = 0;
        for(Integer num: resultSet)
            res[index++] = num;

        return res;
    }
    public int[] intersection1(int[] nums1, int[] nums2) {
        //map集合不允许有相同的键 可用于除去相同的元素
        Map<Integer, Integer> resultMap = new HashMap<>();
        //list方便添加具有contains函数
        List<Integer> list1 = new ArrayList<>();
        for(int tmp:nums1) {
            list1.add(tmp);
        }
        for(int temp:nums2) {
            if(list1.contains(temp)) {
                resultMap.put(temp, temp);
            }
        }
        int[] result = new int[resultMap.size()];
        int i = 0;
        for(Integer value: resultMap.values()) {
            result[i++] = value;
        }
        return result;
    }
    // 242  202 290 205 451
}
