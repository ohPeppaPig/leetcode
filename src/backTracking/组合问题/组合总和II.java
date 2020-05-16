package backTracking.组合问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。 
 示例 1:
 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 */
public class 组合总和II {
    List<List<Integer>> res;

    /**
     * 该题主要还是去重
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        // 去重
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        backtrack(candidates,target,0,temp);
        return res;

    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> temp) {
        if(target<0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(i>start&&candidates[i] == candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            backtrack(candidates,target-candidates[i],i+1,temp);
            temp.remove(temp.size()-1);

        }


    }

}
