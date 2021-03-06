package binarytree;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

 说明: 叶子节点是指没有子节点的节点。
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root ==null){
            return false;
        }
        // 根节点时，判断是否成立
        if(root.left==null&&root.right==null){
            return sum == root.val;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    //404
}
