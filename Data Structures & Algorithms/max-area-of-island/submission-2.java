class Solution {
    int max=0;
    public int maxAreaOfIsland(int[][] grid) {
        //Q: max: row and cols
        //1-> land, 0-> water
        // island--> group of 1 ieland
        // 4 directions
        // area: no of land cells
        // max area ?
        for(int i=0;i< grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(i,j,grid));
                }
            }
        return max; 
    }
    int[][]dirs= {{0,1},{1,0},{-1,0},{0,-1}};
    private int dfs(int r, int c, int[][] grid){
        if(r<0 || c<0 ||r==grid.length || c== grid[0].length || grid[r][c]==0)return 0;
        grid[r][c]=0;
        int land=1;
        for(int[]d: dirs){
           land+= dfs(r+d[0],c+d[1],grid);
        }
        max=Math.max(max,land);
        return land;
    }
}
