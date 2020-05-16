package DFS;

public class 二叉树转为链表 {
    public void flatten(TreeNode root) {
        // 递归结束
        if(root == null||(root.left == null && root.right ==null)){
            return;
        }
        // 缕平左子树
        flatten(root.left);
        // 缕平右子树
        flatten(root.right);
        // 保存右子树
        TreeNode temp = root.right;
        // 连接左子树
        root.right = root.left;
        // 根左边置空
        root.left = null;
        while(root.right!=null){
            root = root.right;
        }
        // 连接右边
        root.right = temp;
    }
}
