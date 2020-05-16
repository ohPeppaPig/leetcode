package backTracking.DFSAndFloodFill;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 */
public class NumberOfIslands {
    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    int m,n;
    boolean[][] visited;
    private boolean inArea(int x,int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    public int numIslands(char[][] grid) {
        if(grid == null||grid.length==0||grid[0].length==0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'&&!visited[i][j]){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int i,int j){
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
           int x = i+d[k][0];
           int y = j+d[k][1];
            if(inArea(x,y)&&grid[x][y]=='1'&&!visited[x][y]){
                dfs(grid,x,y);
            }
        }
    }
}

//130  417
