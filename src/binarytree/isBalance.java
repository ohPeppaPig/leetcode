package binarytree;

import java.lang.annotation.Retention;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。

 本题中，一棵高度平衡二叉树定义为：

 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class isBalance {
    /**
     * 自顶向上，暴力递归，产生了很多的重复计算
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(Math.abs(highOfTree(root.left)-highOfTree(root.right))>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    private int highOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(highOfTree(root.left),highOfTree(root.right));
    }
    public boolean isBalanced1(TreeNode root){
        return helper(root)!=-1;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = helper(root.left);
        if(l==-1){
            return -1;
        }
        int r = helper(root.right);
        if(r == -1){
            return -1;
        }
        return Math.abs(l-r)<2?1+Math.max(l,r):-1;
    }
}
