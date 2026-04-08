class Solution {
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   max=Math.max(max,dfs(i,j,grid));
                }
            }
    return max;
    }
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    private int dfs(int i,int j, int[][] grid){
        if(i<0|| i==grid.length || j<0 || j==grid[0].length || grid[i][j]==0)return 0;
        grid[i][j]=0;
        int island=1;
        for(int[]d: dirs){
            island+= dfs(i+d[0],j+d[1],grid);
        }
        return island;
    }
}
