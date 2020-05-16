package 剑指;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Node1 {
    int val;
    Node next;
    Node random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class solution1 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int l = 0,r = matrix[0].length-1,t = 0,b = matrix.length-1;
        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true){
            //从左到右
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];
            }
            if(++t>b){
                break;
            }
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r];
            }
            if(--r<l){
                break;
            }
            for (int i = r; i >=l; i--) {
                res[x++] = matrix[b][i];
            }
            if(--b<t){
                break;
            }
            for (int i = b;i>=t;i--){
                res[x++] = matrix[i][l];
            }
            if(++l>r){
                break;
            }
        }
        return res;

    }
}
