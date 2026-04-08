class Solution {
    public boolean exist(char[][] board, String word) {
        // as we can start search from anywhere
        for(int r=0;r<board.length;r++)
        for(int c=0;c<board[0].length;c++){
            if(dfs(board,r,c,word, 0))return true;
        }
        return false;
        
    }
    private boolean dfs(char[][]board, int r, int c, String word, int id){
        if(id==word.length())return true;
        if(r<0 || r==board.length ||c<0 || c==board[0].length)return false;
        if(board[r][c]!= word.charAt(id)|| board[r][c]=='#')return false;
        //found match word
        char res=board[r][c];
        board[r][c]='#';
        //spread 4 direct
      boolean foundMatchInAnyDirection= dfs(board,r+1,c,word, id+1)||
       dfs(board,r-1,c,word, id+1) ||
       dfs(board,r,c+1,word, id+1) ||
       dfs(board,r,c-1,word, id+1);
       board[r][c]=res;
       return foundMatchInAnyDirection;
    }
}
