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
            //print row
            res.add(printRow(board));
            return;
        }
        //check q position
        //col, dig, neg use set
        // here for each row we have n choice - 1 (previous) row column
        /*
        for row 0: n col choice
        for row 1: n-1 col choice( Any column except the one blocked by Row 0)
        for row 2: n-2 col choice ( Any column except the one blocked by Row 0 ,1)
        for row 3: n-3 col choice ( Any column except the one blocked by Row 0 ,1,2)
        .....
        for row n= 1
        hence total choice: like nested loop n and n-1 and n-2 and n-3 =>
        n   *  n-1 *   n-2 *   n-3 * 1  =n!
        Total paths = Product of branches at each level = n!
        
        */
        for(int c=0;c<board[0].length;c++){
            if(col.contains(c)|| dig.contains(r+c) || negDig.contains(r-c))continue;
            //valid pos
            //choose
            col.add(c);
            dig.add(r+c);
            negDig.add(r-c);
            board[r][c]='Q';
            //move to next row
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
