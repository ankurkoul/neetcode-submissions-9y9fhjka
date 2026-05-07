class Solution {
    int n,m;
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) {
        int res=0;
        //traverse whole grid to fing=d first land , when got do dfs or bfs to sink it
        n= grid.length;
        m= grid[0].length;
        for(int r=0;r<n;r++){
            for(int c=0; c<m ;c++){
                if(grid[r][c]=='1'){
                    //found on island
                    res++; //count and sink it
                    dfs(r,c,grid);
                }
            }
        }
        return res;
    }

    private void dfs(int r , int c , char[][] grid){
        if(r<0 || c<0 || r==n || c==m || grid[r][c]=='0')return;
        grid[r][c]='0'; //sink island 
        //spread it
        for(int[] d: dirs){
            int nr=r+d[0];
            int nc=c+d[1];
            dfs(nr,nc,grid);
        }
    }
}
