package HashTable;

import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 */
public class TwoSum {
    /**
     * 从头至尾遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                int[] res = {i, record.get(complement)};
                return res;
            }

            record.put(nums[i], i);
        }

        throw new IllegalStateException("the input has no solution");
    }

    // 15 18 16

    /**
     * 将值，下标放入hashmap
     * 对于2a，遍历时判断其不为i
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            record.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {

            Integer index = record.get(target - nums[i]);
            if (index != null && index != i) {
                int[] res = {i, index};
                return res;
            }
        }

        throw new IllegalStateException("the input has no solution");
    }



}