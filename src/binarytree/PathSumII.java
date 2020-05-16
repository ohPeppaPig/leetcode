package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

 说明: 叶子节点是指没有子节点的节点。
 */
public class PathSumII {
//    List<List<Integer>> list = new ArrayList<>();
//    ArrayList<Integer> inner = new ArrayList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        if (root == null) return list;
//        sum -= root.val;
//        inner.add(root.val);  // 入列表
//        if (root.left == null && root.right == null){
//            if (sum == 0){
//                list.add(new ArrayList<>(inner));  // 记得拷贝一份
//            }
//
//        }
//        if (root.left != null)  pathSum(root.left, sum);
//        if (root.right != null)  pathSum(root.right, sum);
//        inner.remove(inner.size()-1);  //从列表中删除
//        return list;
//    }

    List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        dfs(root,sum,path);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        if(root == null){
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(path));
        }

        dfs(root.left,sum - root.val,path);
        dfs(root.right,sum-root.val,path);
        path.remove(path.size()-1);

    }

}
