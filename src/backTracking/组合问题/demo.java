package backTracking.组合问题;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class demo {
//    boolean[] col;
//    boolean[] dia1;
//    boolean[] dia2;
//    List<List<String>> res;
//    public List<List<String>> solveNQueens(int n) {
//        res = new ArrayList<List<String>>();
//        col = new boolean[n];
//        // 行加列的和相等
//        dia1 = new boolean[2 * n - 1];
//        // 行列之差相等
//        dia2 = new boolean[2 * n - 1];
//        LinkedList<Integer> row = new LinkedList<>();
//        putQueens(n,0,row);
//        return res;
//    }
//
//    private void putQueens(int n, int index, LinkedList<Integer> row) {
//        if(index == n){
//            res.add(Generat(n,row));
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if(!col[i]&&!dia1[index+i]&&!dia2[index-i+n-1]){
//                col[i] = true;
//                dia1[index+i] = true;
//                dia2[index-i+n-1] = true;
//                row.addLast(i);
//                putQueens(n,index+1,row);
//                col[i] = false;
//                dia1[index + i] = false;
//                dia2[index - i + n - 1] = false;
//                row.removeLast();
//            }
//
//        }
//    }
//
//    private List<String> Generat(int n, LinkedList<Integer> row) {
//        List<String> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            char[] ch = new char[n];
//            Arrays.fill(ch,'.');
//            ch[row.get(i)] = 'Q';
//            res.add(new String(ch));
//        }
//        return res;
//    }

    List<List<Integer>> res;
    boolean[] visit;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        visit = new boolean[nums.length];
        List<Integer> temp = new ArrayList<>();
        dfs(nums,0,temp);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> temp) {
        if(start == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visit[i]){
                visit[i] = true;
                temp.add(nums[i]);
                dfs(nums,start+1,temp);
                temp.remove(temp.size()-1);
                visit[i] = false;
            }
        }
    }

}
