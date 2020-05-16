package binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的序列化与反序列化 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res=mySeri(root,new StringBuilder());
        return res.toString();
    }

    StringBuilder mySeri(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return sb;
        }
        else if(root!=null){
            sb.append(root.val);
            sb.append(",");

            mySeri(root.left,sb);
            mySeri(root.right,sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String []temp=data.split(","); // 将序列化的结果转为字符串数组
        List<String> list=new LinkedList<>(Arrays.asList(temp)); // 字符串数组转为集合类 便于操作
        return myDeSeri(list);
    }
    public TreeNode myDeSeri(List<String> list){
        TreeNode root;
        if(list.get(0).equals("null")){
            list.remove(0); // 删除第一个元素 则第二个元素成为新的首部 便于递归
            return null;
        }
        else{
            root=new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left=myDeSeri(list);
            root.right=myDeSeri(list);
        }
        return root;
    }

}
