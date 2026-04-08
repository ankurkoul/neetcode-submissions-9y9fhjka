class Solution {
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        // collect all treasure 
        // and then do bfs from treasure to fill land cell with shorest distance
        // here we use level based bfs to understand steps needed
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }

        // start from each treasure collected and for each level 
        while(!q.isEmpty()){
            int size= q.size();
            while(size-->0){
                int[] top=q.poll();
                //spread in 4 directions
                int r=top[0],c=top[1];
                int dist=grid[r][c]; //distance from treasure
                for(int[] d: dirs){
                    dfs(r+d[0],c+d[1],grid,q,dist);
                }
            }
        }
    }

    private void dfs(int r, int c, int[][]grid, Queue<int[]>q,int dist){
        if(r<0 ||r==grid.length || c<0 || c==grid[0].length || grid[r][c]!=Integer.MAX_VALUE)return;
        grid[r][c]=dist+1; // store each step  distance in grid only
        q.offer(new int[]{r,c});
    }
}
