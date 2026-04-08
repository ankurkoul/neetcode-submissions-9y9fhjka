class Solution {
    int ROWS,COLS;

    public void solve(char[][] board) {
        ROWS=board.length;
        COLS=board[0].length;

        // Mark all 'O' connected to the border
        for (int r = 0; r < ROWS; r++) {
                for (int c = 0; c < COLS; c++) {
                    if ((r == 0 || r == ROWS - 1 
                        || c == 0 || c == COLS - 1)
                       ) {
                        dfs(r, c, board);
                    }
                }
            }
       // Flip remaining 'O' to 'X' and revert 'T' back to 'O'
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int r, int c, char[][]board){
        if(r<0 || r==ROWS || c<0 || c==COLS || board[r][c]!='O')return;
        board[r][c]='T';
        
        for(int[]d: dirs){
            dfs(r+d[0],c+d[1],board);
        }
    }
}
