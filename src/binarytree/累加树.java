package binarytree;

import java.util.LinkedList;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

 例如：

 输入: 原始二叉搜索树:
 5
 /   \
 2     13

 输出: 转换为累加树:
 18
 /   \
 20     13

 */
public class 累加树 {
    /**
     * 解法一：前序：递归
     */
    int sumVal = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        sumVal = sum(root);
        inOrder(root);
        return root;
    }

    private void inOrder(TreeNode root) {
        inOrder(root.left);
        int temp = root.val;
        root.val = sumVal;
        sumVal = sumVal - temp;
        inOrder(root.right);
    }

    private int sum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        return left+right+root.val;

    }
    /**
     * 解法二：非递归
     */
    public TreeNode convertBST1(TreeNode root) {
        int sum = sumOfTree(root);
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                int tmp = p.val;
                p.val = sum;
                sum -= tmp;
                p = p.right;
            }
        }
        return root;
    }

    private int sumOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumOfTree(root.left) + sumOfTree(root.right);
    }
    /**
     * 解法三：右根左
     */
    private int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        if(null == root){
            return null;
        }
        post(root);
        return root;
    }

    private void post(TreeNode root) {
        if(root == null){
            return;
        }
        post(root.right);
        root.val+=sum;
        sum = root.val;
        post(root.left);
    }

}
