package backTracking.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * 定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 candidates 中的数字可以无限制重复被选取。
 说明：
 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。 
 示例 1:
 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]

 */
public class 组合总和 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        backTrcking(candidates,target,0,temp);
        return res;
    }

    private void backTrcking(int[] candidates, int target, int start, List<Integer> temp) {
        if(target<0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            // 该组合可以包含该元素，故start原地开始
            backTrcking(candidates,target - candidates[i],i,temp);
            temp.remove(temp.size()-1);

        }


    }

}
