package Arrays.对撞指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组


 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0;k<nums.length - 2;k++){
            // 当大于0时停止
            if(nums[k]>0) break;
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k+1;
            int j = nums.length-1;
            while(i<j){
                int sum = nums[k]+nums[i]+nums[j];
                if(sum<0){
                    while(i<j&&nums[i] == nums[++i]);
                }else if(sum>0){
                    while(i<j&&nums[j]==nums[--j]);
                }else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while(i<j&&nums[i] == nums[++i]);
                    while(i<j&&nums[j] == nums[--j]);
                }
            }
        }
        return res;
    }

}
