package binarytree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class 二叉树的公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p||root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(right!=null&&left!=null){
            return root;
        }
        return null;
    }


    /**
     *  二叉搜索树的LCA问题
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        //p.val == root.val || q.val == root.val|| (root.val - p.val) * (root.val - q.val) < 0;
        return root;
    }

}
