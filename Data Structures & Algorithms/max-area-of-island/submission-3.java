class Solution {
    int n,m,countIslands;
    public int maxAreaOfIsland(int[][] grid) {
       //ICore

     n=grid.length;
     m=grid[0].length;
     countIslands=0;
     int max=0;
     for(int r=0;r<n;r++){
        for(int c=0;c<m;c++){
            //we need area  and among them max area ,
            // area is count of islands in that connected path
            if(grid[r][c]==1){
               max=Math.max(max , dfs(r,c,grid));
            }
             
        }
     }

     return max;
    }

    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};

    private void dfs_countAllIslands(int r, int c, int[][] grid){
        if(r<0 || c<0 || r==n || c==m || grid[r][c]==0)return;
        //mark visited by sink
        grid[r][c]=0;
        countIslands++;
        for(int[] d: dirs){
            dfs_countAllIslands(r+d[0],c+d[1],grid);
        }

    }

     private int dfs(int r, int c, int[][] grid){
         if(r<0 || c<0 || r==n || c==m || grid[r][c]==0)return 0;
         grid[r][c]=0;
         int count=1;
         for(int[] d: dirs){
           count+= dfs(r+d[0],c+d[1],grid);
            }
        return count;
     }
}
