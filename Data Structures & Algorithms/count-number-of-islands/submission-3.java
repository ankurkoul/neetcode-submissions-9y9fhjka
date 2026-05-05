class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        //ICORE
        int res=0;
        //DFS vs BFS? it is connected component pblm
        // we need to explore all connected land 
        /*
        Natural fit for “flood fill” problems
        This problem is essentially:
        “Start at a cell and spread in all directions”
        That’s exactly how DFS behaves:

        Go deep → explore fully → backtrack
        So it feels very intuitive:

        “Find land → sink the entire island”
        */

        n=grid.length;
        m=grid[0].length;
        for(int r=0; r<n;r++){
            for(int c=0; c<m;c++){
                if(grid[r][c]=='1'){
                    res++;
                    //sink the entire island
                    dfs(r,c, grid);
                }
            }
        }
        return res;
    }

    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int r, int c, char[][] grid){
        if(r<0 || c<0 || r==n || c==m || grid[r][c] =='0')return;
        grid[r][c] ='0';

        for(int[] d: dirs){
            dfs(r+d[0],c+d[1], grid);
        }

        
       // no backtracking bcz 
       //Once we visit a land cell ('1'), we never want to visit it again
    }
}
