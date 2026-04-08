class Solution {
    int[][] dirs={{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
       // grid rows and col < 10^10 
       // 0->empty , 1-> fresh, 2-> rotten
       // every min : fresh bcm rottens if adj horz or vert to rotten
       // min number of mins : until 0 fresh fruit remaning
       // if fresh fruit !=0 return -1
       Queue<int[]> q=new ArrayDeque<>();
       int fresh=0;
       for(int r=0;r<grid.length;r++)
        for(int c=0;c<grid[0].length;c++){
            if(grid[r][c]==1)fresh++;
            if(grid[r][c]==2)q.offer(new int[]{ r,c});
        } 
        if(fresh==0)return 0;
        if(q.isEmpty())return -1;
        int mins=0;
        while(!q.isEmpty() && fresh!=0 ){
            int size=q.size();
            while(size-->0 ){
                int [] top=q.poll();
                int r=top[0],c=top[1];
                for(int []d: dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr<0 || nc<0|| nr==grid.length || nc==grid[0].length || grid[nr][nc]!=1)continue;
                    grid[nr][nc]=2;
                    fresh--;
                    q.offer(new int[]{nr,nc}); // addto rooten queue
                }
            }
            mins++;
        }

        return fresh==0? mins: -1;
    }
}
