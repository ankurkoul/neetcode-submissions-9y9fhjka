class Solution {
    //Set
    Set<String> po=new HashSet<>();
    Set<String> ao=new HashSet<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
       // max height
       // row, cols 
       //       p
       // p |-------|
       //   |       |a
       //       a
       // water flow in 4 dirs
       //  cell to neighbour cell : height_cell >= height_neigh --> po/ao
       // po/ao --> water can reach if height of ocean cell<=height inside

        // first row and all cols
        // last row and all cols
        int n=heights.length;
        int m=heights[0].length;
        for(int c=0;c<m;c++){
            dfs(0,c,heights,po);
            dfs(n-1,c,heights,ao);
        }

        for(int r=0;r<n;r++){
            dfs(r,0,heights,po);
            dfs(r,m-1,heights,ao);
        }

        List<List<Integer>>  res=new ArrayList<>();

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                String key=r+"-"+c;
                if(po.contains(key) && ao.contains(key)){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int r, int c,int[][] heights, Set<String> set ){
        if(r<0 ||c<0 || r==heights.length || c==heights[0].length )return;
        if(set.contains(r+"-"+c))return;
        int srcHt= heights[r][c];
        set.add(r+"-"+c);
        for(int []d: dirs){
            int nr=r+d[0];
            int nc= c+d[1];
            if (nr < 0 || nc < 0 || nr == heights.length || nc == heights[0].length) continue;  // Add bounds check here
            if (srcHt > heights[nr][nc]) continue;
            dfs(nr,nc,heights,set);
        }
    }
}
