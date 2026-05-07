class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        //ICORE
       
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

        An island is a group of connected land cells (up, down, left, right).
        Whenever we find a land cell that hasn’t been visited,
        we start a DFS to sink the entire island by marking all its connected land as water.
        Each DFS call corresponds to one island.
        */
        int res=0;
        n=grid.length;
        m=grid[0].length;
        for(int r=0; r<n;r++){
            for(int c=0; c<m;c++){
                if(grid[r][c]=='1'){
                    res++;
                    //sink the entire island
                    
                    bfs(r,c, grid);

                    //bfs(r,c,grid);
                    
                }
            }
        }
        return res;
    }

    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};

    private void bfs(int r, int c, char[][] grid){

        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{r,c});
        grid[r][c]='0'; // mark visited
        while(!q.isEmpty()){
            int[] top=q.poll();
            for(int[] d: dirs){
                int nr= top[0]+d[0];
                int nc= top[1]+d[1];
                if(nr <0 || nr==n || nc<0 || nc==m ||  grid[nr][nc]=='0')continue;
                //else
                //add to queue and mark visited
                q.offer(new int[]{nr, nc});
                grid[nr][nc]='0'; // need to mark visited
                
            }
        }
    }


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
