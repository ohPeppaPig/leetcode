package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class 完全二叉树节点个数 {
    // 递归写法
    public int countNodes1(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+1;
    }
    // 非递归
    public int countNodes(TreeNode root){
        if(root ==null){
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return count;
    }
}
