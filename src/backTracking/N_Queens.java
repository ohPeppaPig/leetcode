package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class N_Queens {

//    private boolean[] col;
//    private boolean[] dia1;
//    private boolean[] dia2;
//    private ArrayList<List<String>> res;
//
//    public List<List<String>> solveNQueens(int n) {
//
//        res = new ArrayList<List<String>>();
//        col = new boolean[n];
//        // 行加列的和相等
//        dia1 = new boolean[2 * n - 1];
//        // 行列之差相等
//        dia2 = new boolean[2 * n - 1];
//
//        LinkedList<Integer> row = new LinkedList<Integer>();
//        putQueen(n, 0, row);
//
//        return res;
//    }
//
//    // 尝试在一个n皇后问题中, 摆放第index行的皇后位置
//    private void putQueen(int n, int index, LinkedList<Integer> row){
//
//        if(index == n){
//            res.add(generateBoard(n, row));
//            return;
//        }
//
//        for(int i = 0 ; i < n ; i ++)
//            // 尝试将第index行的皇后摆放在第i列
//            if(!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]){
//                row.addLast(i);
//                col[i] = true;
//                dia1[index + i] = true;
//                dia2[index - i + n - 1] = true;
//                putQueen(n, index + 1, row);
//                //回溯
//                col[i] = false;
//                dia1[index + i] = false;
//                dia2[index - i + n - 1] = false;
//                row.removeLast();
//            }
//
//        return;
//    }
//
//    private List<String> generateBoard(int n, LinkedList<Integer> row){
//
//        assert row.size() == n;
//
//        ArrayList<String> board = new ArrayList<String>();
//        for(int i = 0 ; i < n ; i ++){
//            char[] charArray = new char[n];
//            Arrays.fill(charArray, '.');
//            charArray[row.get(i)] = 'Q';
//            board.add(new String(charArray));
//        }
//        return board;
//    }
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        // 布置空棋盘
        for (char[] chars : board) Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }

    /**
     * 路径：board中小于row的那些行都已经成功放置了皇后
     * 可选择列表: 第row行的所有列都是放置Q的选择
     * 结束条件: row超过board的最后一行
     *
     * @param board
     * @param row
     */
    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
//            res.add(charToString(board));
            return;
        }
        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col)) continue;
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        int rows = board.length;
        // check is valid in col
        for (char[] chars : board) if (chars[col] == 'Q') return false;
        // check is valide upright
        for (int i = row - 1, j = col + 1; i >= 0 && j < rows; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        // check is valide upleft
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    //52  37


}
