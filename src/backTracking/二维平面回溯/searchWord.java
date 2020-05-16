package backTracking.二维平面回溯;

/**
 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 */
public class searchWord {
//    private int d[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
//    private int m, n;
//    private boolean[][] visited;
//
//    public boolean exist(char[][] board, String word) {
//
//        if(board == null || word == null)
//            throw new IllegalArgumentException("board or word can not be null!");
//
//        m = board.length;
//        if(m == 0)
//            throw new IllegalArgumentException("board can not be empty.");
//        n = board[0].length;
//        if(n == 0)
//            throw new IllegalArgumentException("board can not be empty.");
//
//        visited = new boolean[m][n];
//        for(int i = 0 ; i < m ; i ++)
//            for(int j = 0 ; j < n ; j ++)
//                if(searchWord(board, word, 0, i, j))
//                    return true;
//
//        return false;
//    }
//
//    private boolean inArea( int x , int y ){
//        return x >= 0 && x < m && y >= 0 && y < n;
//    }
//
//    private boolean searchWord(char[][] board,String word,int index,int x,int y){
//        if(index == word.length()-1){
//            return board[x][y] == word.charAt(index);
//        }
//        if(board[x][y] == word.charAt(index)){
//            visited[x][y] = true;
//
//        for (int i = 0; i < 4; i++) {
//            int newx = x+d[i][0];
//            int newy = y+d[i][1];
//            if(inArea(newx,newy)&&!visited[newx][newy]&&searchWord(board,word,index+1,newx,newy)){
//                return true;
//            }
//        }
//        //没有找到则回溯
//        visited[x][y] = false;
//    }
//    return false;
//    }
boolean[][] visit;
    public boolean exist(char[][] board, String word) {
        if(board.length == 0){
            return false;
        }
        visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;

    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if(index == word.length()){
            return true;
        }
        // 越界
        if(i>=board.length||j>=board[0].length||i<0||j<0){
            return false;
        }
        // 访问
        if(visit[i][j]){
            return false;
        }

        // 元素正确
        if(!(board[i][j] == word.charAt(index))){
            return false;
        }
        visit[i][j] = true;
        // 四周遍历
        if(dfs(board,word,index+1,i+1,j)||dfs(board,word,index+1,i-1,j)
                ||dfs(board,word,index+1,i,j+1)||dfs(board,word,index+1,i,j-1)){
            return true;
        }

        // 回溯
        visit[i][j] = false;

        return false;

    }


}
