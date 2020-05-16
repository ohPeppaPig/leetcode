package backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 示例：

 输入：n = 3
 输出：[
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 */
public class 括号生成 {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        String path = "";
        dfs(path,0,0,n);
        return res;
    }

    private void dfs(String path, int left, int right, int n) {
        if(left == n&&right == n){
            res.add(path);
            return;
        }
        // 剪枝
        if(left<right){
            return;
        }
        if(left<n){
            dfs(path+"(",left+1,right,n);
        }
        if(right<n){
            dfs(path+")",left,right+1,n);
        }
    }

    public static void main(String[] args) {
        括号生成 a = new 括号生成();
        System.out.println(a.generateParenthesis(2));
    }
}
