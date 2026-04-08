class Solution {
    public int numIslands(char[][] grid) {
        //q: grid.length
        // can we update grid 
        int count=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        return count;
    }
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int i, int j, char[][] grid){
        if(i<0|| j<0|| i==grid.length || j== grid[0].length || grid[i][j]=='0')return;
        grid[i][j]='0';
        for(int []d: dirs){
            dfs(i+d[0],j+d[1],grid);
        }
    }
}
