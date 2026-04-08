class Solution {
    Set<String> po=new HashSet<>();
    Set<String> ao=new HashSet<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //use 2 sets
        // spread water from PO and AO to all cells and collect them in set
        // just ensure not collecting same set again
        
        // start rowwise and iterate each col
        // for first rows-> m columns
        // for last row -> m columns
        int n=heights.length, m=heights[0].length;
        for(int c=0;c<m;c++){
            dfs(0,c, heights,po,heights[0][c]);
            dfs(n-1,c, heights,ao,heights[n-1][c]);
        }

        //go column and iterate each row
        //for first col
        //sec col
        
        for(int r=0;r<n;r++){
            dfs(r,0,heights,po,heights[r][0]);
            dfs(r,m-1,heights,ao,heights[r][m-1]);
        }

        List<List<Integer>> res=new ArrayList<>();
        //cheeck list contains all 
         for(int r=0;r<n;r++){
             for(int c=0;c<m;c++){
                String key= r+"-"+c;
               if(po.contains(key) && ao.contains(key)){
                    res.add(Arrays.asList(r,c));
               }
             }
         }

        return res;
    }

    int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};

    private void dfs(int r, int c, int[][]grid, Set<String> set, int prevHt){
        if(r<0 || r==grid.length || c<0 || c==grid[0].length )return;
        if(grid[r][c]<  prevHt)return;
        String key= r+"-"+c;
        if(set.contains(key))return;
        set.add(key);
        for(int []d:dirs){
             dfs(r+d[0],c+d[1],grid,set,grid[r][c]);
        }
    }
}
