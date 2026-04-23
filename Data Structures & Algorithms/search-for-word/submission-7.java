class Solution {
    int[][] dirs= {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean exist(char[][] b, String word) {
        for(int i=0;i<b.length;i++){
            for(int j=0; j<b[0].length; j++){
                if(dfs(b,i,j,0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] b, int r, int c, int id, String word){
        //valid case
        if(id==word.length())return true;

        //invalid case
        if(r<0 || r== b.length || c<0 || c==b[0].length)return false;
        if(b[r][c]=='#')return false;
        if(b[r][c] != word.charAt(id)) return false;
        char val=b[r][c];
        b[r][c]='#';
        boolean res=false;
        for(int[]d : dirs){
            res= res|| dfs(b, r+ d[0],c+d[1], id+1, word);
        }
        //backtrack
        b[r][c]=val;
        return res;
    }
}
