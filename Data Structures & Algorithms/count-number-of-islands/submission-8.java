class Solution {
    int n, m;
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
                    bfs(r,c,grid);
                }
            }
        }
        return res;
    }

    private void bfs(int r, int c, char[][] grid){
        Queue<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{r, c});
        //mark this land processed hence sink it
        grid[r][c]='0';
        while(!q.isEmpty()){
            int[] top=q.poll();
            //spread to neighbours
            for(int[] d: dirs){
                int nr=top[0]+d[0];
                int nc=top[1]+d[1];
                //check valid if yes process and sink
                if(nr <0 || nc<0 || nr==n || nc==m || grid[nr][nc]=='0')continue;
                //process
                q.offer(new int[]{nr, nc});
                //sink
                grid[nr][nc]='0';
            }
            
        }
    }
}
