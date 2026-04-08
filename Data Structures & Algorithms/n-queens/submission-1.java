class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // max value of n here?
        //prepare board
        char[][] board=new char[n][n];
        // for(int r=0;r<n;r++)
        //   Arrays.fill(board[r],'.');
        for(char[]row: board){
            Arrays.fill(row,'.');
        }
        //start rowise  queen filling
        dfs(0, board);

        //print board
        return res;
    }
    Set<Integer> col=new HashSet<>();
      Set<Integer> dig=new HashSet<>();
        Set<Integer> negDig=new HashSet<>();

    private void dfs(int r, char[][]board){
        if(r==board.length){
            //print r
            res.add(printRow(board));
            return;
        }
        //check q position
        //col, dig, neg use set
        for(int c=0;c<board[0].length;c++){
            if(col.contains(c)|| dig.contains(r+c) || negDig.contains(r-c))continue;
            //valid pos
            //choose
            col.add(c);
            dig.add(r+c);
            negDig.add(r-c);
            board[r][c]='Q';
            //move to next
            dfs(r+1,board);
            //backtrack remove
            col.remove(c);
            dig.remove(r+c);
            negDig.remove(r-c);
            board[r][c]='.';
        }
    }

    private List<String> printRow(char[][]board){
       List<String> rows=new ArrayList<>();
       for(int i=0;i<board.length;i++)
            rows.add(String.valueOf(board[i]));
        return rows;
    }
}
