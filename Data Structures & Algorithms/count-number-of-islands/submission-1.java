class Solution {
    public int numIslands(char[][] grid) {
        int island=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    island++;
                    dfs(i,j,grid);
                }
            }
        return island;
    }
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int i, int j, char[][] grid){
        if(i<0|| i==grid.length || j<0|| j==grid[0].length || grid[i][j]=='0')return;
        grid[i][j]='0';
        //spread in four directions
        for(int [] d: dirs){
            dfs(i+d[0],j+d[1],grid);
        }
    }
}
