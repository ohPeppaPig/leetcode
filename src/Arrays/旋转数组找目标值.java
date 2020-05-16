package Arrays;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

 你可以假设数组中不存在重复的元素。

 你的算法时间复杂度必须是 O(log n) 级别。

 示例 1:

 输入: nums = [4,5,6,7,0,1,2], target = 0
 输出: 4
 */
public class 旋转数组找目标值 {
    public static int search(int[] nums, int target) {
        int i = 0,j = nums.length-1;
        while (i<=j){
            int mid = (i+j)>>1;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>=nums[i]){
                // 考虑最左边界
                if(target>=nums[i]&&target<nums[mid]){
                    j = mid-1;
                }else {
                    i = mid+1;
                }
            }else {
                // 考虑最右边界
                if(target<=nums[j]&&target>nums[mid]){
                    i = mid+1;
                }else {
                    j = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
    }
}
