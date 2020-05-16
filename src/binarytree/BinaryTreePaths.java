package binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        if(root.left == null&&root.right == null){
            res.add(Integer.toString(root.val));
            return res;
        }
        List<String> left = binaryTreePaths(root.left);
        for (String s :
                left) {
            StringBuffer sb = new StringBuffer(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
        List<String> right = binaryTreePaths(root.right);
        for (String s :
                right) {
            StringBuffer sb = new StringBuffer(Integer.toString(root.val));
            sb.append("->");
            sb.append(s);
            res.add(sb.toString());
        }
    return res;

    }

}
