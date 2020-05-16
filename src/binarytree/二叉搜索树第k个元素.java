package binarytree;

import java.util.Stack;

public class 二叉搜索树第k个元素 {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.empty()||cur!=null){
            while (cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if(k == 0){
                return cur.val;
            }
            cur = cur.right;
        }
        return 0;
    }
}
