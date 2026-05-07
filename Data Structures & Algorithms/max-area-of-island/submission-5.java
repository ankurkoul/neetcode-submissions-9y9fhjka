class Solution {
    int n,m;
    int[][]dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int max=0;
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==1){
                    max=Math.max(max, dfs(r,c,grid));
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int[][] grid){
        if(r<0 ||c<0 || r==n || c==m || grid[r][c]==0) return 0;
        //process
        int count=1;
        //sink it
        grid[r][c]=0;
        //spread it
        for(int[] d: dirs){
            int nr=r+d[0], nc=c+d[1];
            count+= dfs(nr,nc,grid);

        }

        return count;

    }
}
