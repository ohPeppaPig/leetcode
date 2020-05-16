package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class 合并二叉树 {
    /**
     * 递归解法
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val+=t2.val;
        t1.left = mergeTrees(t1.left,t2.left);
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
    }
    /**
     * 非递归，迭代
     * 思路：一个队列，每次入队两个元素，若为空怎选择嫁接过来
     */
    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(t1);
        queue.add(t2);
        while (!queue.isEmpty()){
            TreeNode p1 = queue.poll();
            TreeNode p2 = queue.poll();
            p1.val+=p2.val;
            if(p1.left!=null&&p2.left!=null){
                queue.add(p1.left);
                queue.add(p2.left);
            }else if(p1.left==null&&p2.left!=null){
                p1.left = p2.left;
            }
            if(p1.right!=null&&p2.right!=null){
                queue.add(p1.right);
                queue.add(p2.right);
            }else if(p1.right==null&&p2.right!=null){
                p1.right = p2.right;
            }

        }
        return t1;
    }

}
