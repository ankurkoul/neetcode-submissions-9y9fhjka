class Solution {
    Set<String> po=new HashSet<>();
    Set<String> ao=new HashSet<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    // water from po -> enters from top row, first col
    // water from ao -> enter from last row, last col
    // water can do if new height is equal or more neighbour
    // store cell which we can fill water
    // cell which are present in both will be answer
        int n=heights.length;
        int m=heights[0].length;
        // iterate rowwise for 2 columns
        for(int r=0;r<heights.length;r++){
            // here we choose 2 cols
            dfs(r,0,                    heights,    po , heights[r][0]);
            dfs(r, m-1, heights,    ao , heights[r][m-1] );
        }

         // iterate colwise for 2 rows
        for(int c=0;c<heights[0].length;c++){
            dfs(0,  c,                    heights,    po  , heights[0][c]  );
            dfs(n-1,   c,     heights,    ao , heights[n-1][ c] );
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r=0;r<heights.length;r++){
            for(int c=0;c<heights[0].length;c++){
                String key=r+"-"+c;
                if(ao.contains(key) && po.contains(key)){
                    List<Integer> list=Arrays.asList(r,c);
                    res.add(list);
                }
            }
        }
        return res;

    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int r, int c,int[][] grid, Set<String> set ,int srcHeight){
       if(r<0 || r==grid.length || c<0 || c==grid[0].length)return;
       if(grid[r][c]<srcHeight) return;
        String key=r+"-"+c;
        if(set.contains(key))return; //already visited
           set.add(key);
        for(int[]d: dirs){
            int nr=r+d[0], nc=c+d[1];
                dfs(nr,nc,grid,set,grid[r][c]);
            
        }
    }
}
