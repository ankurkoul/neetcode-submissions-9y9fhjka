class Solution {
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
       // rows/ grid : less than 10^5 
       // -1 : block
       // 0 : treasure
       // inf: empty : Integer.Max_Value
      // we need fill it with nearest value : shortest distance hence bfs is good choice
      // start from treasure point and spread in level by level way
      Queue<int[]> q=new ArrayDeque<>();
      for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length ;j++){
            if(grid[i][j]==0)
                q.offer(new int[]{i,j});
        }
        if (q.size() == 0) return;
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] top=q.poll();
                int r=top[0];
                int c=top[1];
                int val= grid[r][c];
               for(int[]d: dirs){
                int nr= r+d[0];
                int nc= c+d[1];
                if(nr<0 || nc<0 || nr==grid.length || nc==grid[0].length || grid[nr][nc]!=Integer.MAX_VALUE) continue;
                grid[nr][nc]=val+1;
                q.offer(new int[] {nr, nc});
               }
            }
        }
    }
}
