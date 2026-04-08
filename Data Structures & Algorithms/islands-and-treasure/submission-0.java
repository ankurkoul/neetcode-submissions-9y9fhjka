class Solution {
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public void islandsAndTreasure(int[][] grid) {
        //collect treasure in q as bfs
        Queue<int[]> q=new ArrayDeque<>();
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        if(q.isEmpty())return;
        int count=0;
        while(!q.isEmpty()){
            int[] top=q.poll();
            int r= top[0],c=top[1];
            for(int []d: dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<0 || nc<0 || nr==grid.length || nc==grid[0].length || grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[] {nr,nc});
                //source+1
                grid[nr][nc]=grid[r][c]+1;
            }
        }
    }
}
