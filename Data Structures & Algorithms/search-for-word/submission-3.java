class Solution {
    int ROWS, COLS;
    Set<String> path =new HashSet<>(); 
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                 if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r , int c , int i){
        if(i==word.length())return true;

       // invalid case
       if(  r< 0 || r== ROWS || c<0 || c==COLS  ) return false; // reach outside 
       if(  board[r][c]   !=  word.charAt(i)    ) return false; // not matching char
       if(  path.contains(r+"-"+c)) return false;// visited route

      path.add(r+"-"+c);
      int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
      boolean res=false;
      for(int[] d: dirs){
        res= res || dfs(board, word, r+d[0], c+d[1], i+1);
      }
      path.remove(r+"-"+c);
      return res;
    }
}
