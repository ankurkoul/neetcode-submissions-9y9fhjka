class Solution {
    int n,m;
     List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        //dfs
        //ICOre
        n=board.length;
        m=board[0].length;
        res=new ArrayList<>();
        for(String word : words){
            boolean found=false;
            for(int r=0;r<n && !found ;r++){
                for(int c=0;c<m && !found ;c++){
                    if(dfs(board, r, c, word, 0)) {
                        res.add(word);
                        found=true; // break  when found first match dont continue search
                    }
                }

            }
        }
        return res;
    }


    private boolean dfs(char[][] board, int r, int c, String word, int idx){
        if(idx==word.length()) return true;
        if(r< 0 || r==n || c<0 ||c==m || board[r][c]!=word.charAt(idx))return false;
        char temp=board[r][c];
        board[r][c]='#';
        boolean ret= dfs(board, r+1, c, word, idx+1) ||
                dfs(board, r-1, c, word, idx+1) ||
                dfs(board, r, c+1, word, idx+1) ||
                dfs(board, r, c-1, word, idx+1);
        board[r][c]=temp; // word.charAt(idx)
        return ret;    
    }
}
