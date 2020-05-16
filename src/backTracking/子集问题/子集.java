package backTracking.子集问题;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]
 */
public class 子集 {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        res.add(path);
        dfs(nums,0,path);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> path) {
        if(start>nums.length-1){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        子集 a = new 子集();
        System.out.println(a.subsets(nums));
    }

}
