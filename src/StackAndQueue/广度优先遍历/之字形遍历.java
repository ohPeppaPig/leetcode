package StackAndQueue.广度优先遍历;

import java.util.*;

public class 之字形遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            Deque<Integer> deque = new LinkedList<>();
            int n = deque.size();
            while (n>0){
                TreeNode node = queue.poll();
                if(level%2 == 0){
                    //偶层从左到右
                    deque.addLast(node.val);
                }else {
                    //奇数层从右到左
                    deque.addFirst(node.val);
                }
                // 开始放下层元素
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                n--;
            }
            res.add(new ArrayList<>(deque));
            level++;
        }
        return res;
    }
}
