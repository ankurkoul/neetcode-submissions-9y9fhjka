class Solution {
    Queue<int[]> q=new ArrayDeque<>();
    int fresh;
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)fresh++;
                if(grid[i][j]==2)q.offer(new int[]{i,j});
            }
        
        if(fresh==0)return 0;
        if(q.isEmpty())return -1;
        

        //level wise bfs since we need track time elapses
        // need continue till fresh==0
        int time=0;
        while(!q.isEmpty() && fresh!=0){
            int size=q.size();
            while(size-->0){
                int[] top=q.poll();
                //spread in 4 directions
                int r=top[0], c=top[1];
                for(int[]d: dirs){
                    dfs(r+d[0],c+d[1],grid);
                }
            }
            time++;
        }
        return fresh==0?time: -1;
    }

    private void dfs(int r, int c, int[][] grid){
        if(r<0||c<0|| r==grid.length || c==grid[0].length || grid[r][c]!=1)return;
        grid[r][c]=2;
        fresh--;
        q.offer(new int[]{r,c});
    }
}
