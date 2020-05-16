package DFS;

import java.util.Stack;

public class 验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        return core(root, null, null);
    }
    // min  max上下界问题要考虑
    private boolean core(TreeNode node, TreeNode min, TreeNode max) {
        if(node == null) return true;
        if(min != null && node.val <= min.val) return false;
        if(max != null && node.val >= max.val) return false;
        return core(node.left, min, node) && core(node.right, node, max);
    }


    // 中序遍历
    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }



}
