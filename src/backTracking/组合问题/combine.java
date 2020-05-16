package backTracking.组合问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

 示例:

 输入: n = 4, k = 2
 输出:
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 */
public class combine {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>() ;
        if(n<=0||k<=0||n<k){
            return res;
        }
        LinkedList<Integer> l = new LinkedList<>();
        generate(n,k,1,l);
        return res;

    }
    private void generate(int n,int k,int start,LinkedList<Integer> p){
        if(p.size()==k){
            res.add(new LinkedList<>(p));
            return;
        }
        //剪枝

        for (int i = start; i <= n-(k-p.size())+1; i++) {
            p.addLast(i);
            generate(n,k,i+1,p);
            p.removeLast();
        }

    }
}

//39  40  216  90  401
