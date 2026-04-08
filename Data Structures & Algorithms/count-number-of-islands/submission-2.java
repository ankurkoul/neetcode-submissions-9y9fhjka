class Solution {
    public int numIslands(char[][] grid) {
        // what max, length of rowa/cols
        // in grid changes allowed
        // 1-> land , 0 -> water
        // multiple land-> island
        int res=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        return res;
    }
    int[][] dirs= {{0,1},{0,-1},{1,0},{-1,0}};
    private void dfs(int r, int c, char[][] grid){
        if(r<0 ||r==grid.length || c<0 ||c==grid[0].length || grid[r][c]=='0')return;
         grid[r][c]='0'; // mark visited and spread
         for(int [] d: dirs){
            dfs(r+d[0],c+d[1],grid);
         }

    }
}
