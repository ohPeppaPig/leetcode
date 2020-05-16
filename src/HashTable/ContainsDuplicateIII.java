package HashTable;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
 * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

 示例 1:

 输入: nums = [1,2,3,1], k = 3, t = 0
 输出: true

 */
public class ContainsDuplicateIII {
    /**
     *时间复杂度: O(nlogk)
      空间复杂度: O(k)
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i = 0;i<nums.length;i++){
//            if(map.containsKey(Math.abs(t-nums[i]))){
//                if(Math.abs(i-map.get(nums[i]))<=k){
//                    return true;
//                }
//            }else {
//                map.put(nums[i],i);
//            }
//        }
//        return false;
//    }

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

    }
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {

        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Long> record = new TreeSet<Long>();
        for(int i = 0 ; i < nums.length ; i ++){

            //|i-j|<=t  ==>  j-t<=i<=t+j
            if(record.ceiling((long)nums[i] - (long)t) != null &&
                    record.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t)
                return true;

            record.add((long)nums[i]);

            if(record.size() == k + 1)
                record.remove((long)nums[i-k]);
        }

        return false;
    }

}
