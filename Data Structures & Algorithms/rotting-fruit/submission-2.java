class Solution {
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        //collect rotten organges
        // check if rotten oranges are 0 then return -1
        // check if no fresh fruit -1
        // check if replace all fresh fruit
        Queue<int[]>q=new ArrayDeque<>();
        int fresh=0;
        int level=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        if(fresh==0)return 0;
        if(q.isEmpty())return -1;
        
        
        while(!q.isEmpty() && fresh>0){
            int len=q.size();
            while(len-->0){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[]d: dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr<0 || nr==grid.length || nc<0 || nc==grid[0].length || grid[nr][nc]!=1) continue;
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
            level++;
        }
        return fresh==0? level: -1;

    }
}
