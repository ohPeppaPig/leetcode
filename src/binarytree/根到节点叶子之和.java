package binarytree;

public class 根到节点叶子之和 {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root,0);

    }

    private int dfs(TreeNode root, int sum) {
       if(root == null){
           return 0;
       }
       int temp = sum*10+root.val;
       if(root.left==null&&root.right==null){
           return temp;
       }
       return dfs(root.left,temp)+dfs(root.right,temp);

    }
}
