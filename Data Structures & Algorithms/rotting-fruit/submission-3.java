class Solution {
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        //collect rotten oranges in buffer
        Queue<int[]> q=new ArrayDeque<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                 q.offer(new int[]{i,j});
                if(grid[i][j]==1)
                fresh++;
            }
        if(fresh==0)return 0;
        if(q.isEmpty())return -1;
        int time=0;
        while(!q.isEmpty() && fresh>0){
           int level=q.size(); // go level by level
           while(level-->0){
                int[]top=q.poll();
                int r=top[0], c=top[1];
                //spread in 4 directions
                for(int[]d: dirs){
                    int nr=r+d[0],nc=c+d[1];
                    if(nr<0 || nc<0 || nr==grid.length ||nc==grid[0].length || grid[nr][nc]!=1)continue;
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr,nc});
                    fresh--;
                }
           }
            time++; //after processing level increase time
        }

        return fresh==0? time:-1;
    }
}
