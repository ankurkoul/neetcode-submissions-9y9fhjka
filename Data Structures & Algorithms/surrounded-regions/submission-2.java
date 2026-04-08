class Solution {
    public void solve(char[][] board) {
       // 0 -> which are surrounded by x
       // 0 which are at borders cant be converted 
       // same are its neighbours
       int n= board.length, m=board[0].length;
       for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(r==0 || c==0 || r== n-1 ||c==m-1){
                    dfs(r,c,board);
                }
            }
       }

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                }
            }
        }

        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(board[r][c]=='M'){
                    board[r][c]='O';
                }
            }
        }

    }
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int r, int c, char[][]board){
        if(board[r][c]!='O')return;
        board[r][c]='M';
        for(int[]d: dirs){
           int nr=r+d[0],nc=c+d[1];
           if(nr<0 || nc<0 || nr== board.length || nc==board[0].length)continue;
           dfs(nr,nc,board);
        }
    }
}
