class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //create board
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0; j<n ;j++){
                board[i][j]='.';
            }

        // we place one queen in one row
        int row=0;
        dfs(0, board);
        //print board
        return res;
        
    }
    Set<Integer> colSet=new HashSet<>();
    Set<Integer> posDig=new HashSet<>(); // [3,1], [2,2], [1,3]
    Set<Integer> negDig=new HashSet<>(); // [0,2],[1,1], [2,0]

    private void dfs(int row,  char[][] board){
        if(row==board.length){
            //got enought queens
            // print row
            res.add(printRow(board));
            return;
        }
        // check postion col wise
        for(int col=0; col< board[0].length; col++){
            if(colSet.contains(col)|| posDig.contains(row+col) || negDig.contains(row-col)){
               continue; 
            }
            colSet.add(col);
            posDig.add(row+col);
            negDig.add(row-col);
            board[row][col]='Q';
            // move to next row
            dfs(row+1, board);
            //bavktrack
            colSet.remove(col);
            posDig.remove(row+col);
            negDig.remove(row-col);
            board[row][col]='.';

        }
    }

   private List<String> printRow(char[][]board){
       List<String> rows=new ArrayList<>();
       for(int i=0;i<board.length;i++)
            rows.add(String.valueOf(board[i]));
        return rows;
    }

}
