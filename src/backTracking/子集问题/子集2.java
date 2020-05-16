package backTracking.子集问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集2 {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res= new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
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
            if(i>start&&nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(nums,i+1,path);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        子集2 a = new 子集2();
        System.out.println(a.subsetsWithDup(nums));
    }

}
