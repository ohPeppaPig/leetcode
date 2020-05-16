package backTracking.排列问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class permutations {
    private ArrayList<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute1(int[] nums) {

        res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0)
            return res;

        used = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        generatePermutation(nums, 0, p);

        return res;
    }

    // p中保存了一个有index-1个元素的排列。
    // 向这个排列的末尾添加第index个元素, 获得一个有index个元素的排列
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){

        if(index == nums.length){
            res.add(new ArrayList<>(p));
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
            if(!used[i]){
                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1, p );
                p.removeLast();
                used[i] = false;
            }

        return;
    }
//    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
//    List<List<Integer>> permute(int[] nums) {
//        // 记录「路径」
//        LinkedList<Integer> track = new LinkedList<>();
//        backtrack(nums, track);
//        return res;
//    }

//    // 路径：记录在 track 中
//// 选择列表：nums 中不存在于 track 的那些元素
//// 结束条件：nums 中的元素全都在 track 中出现
//    void backtrack(int[] nums, LinkedList<Integer> track) {
//        // 触发结束条件
//        if (track.size() == nums.length) {
//            res.add(new LinkedList(track));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            // 排除不合法的选择
//            if (track.contains(nums[i]))
//                continue;
//            // 做选择
//            track.add(nums[i]);
//            // 进入下一层决策树
//            backtrack(nums, track);
//            // 取消选择
//            track.removeLast();
//        }
//    }
//    result = []
//    def backtrack(路径, 选择列表):
//            if 满足结束条件:
//            result.add(路径)
//            return
//
//            for 选择 in 选择列表:
//              做选择
//    backtrack(路径, 选择列表)
//    撤销选择
//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//        LinkedList<Integer> temp = new LinkedList<>();
//        backtrack(nums,temp);
//        return res;
//    }
//
//    private void backtrack(int[] nums, LinkedList<Integer> temp) {
//        if(temp.size()==nums.length){
//            res.add(new LinkedList(temp));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if(temp.contains(nums[i])){
//                continue;
//            }
//            temp.add(nums[i]);
//            backtrack(nums,temp);
//            temp.removeLast();
//        }
//
//
//    }




}

//47
