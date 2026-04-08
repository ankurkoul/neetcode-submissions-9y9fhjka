class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++){
                char val=board[i][j];
                if(val=='.')continue;
                if(!set.add("row"+i+"="+val)
                || !set.add("col"+j+"="+val)
                || !set.add("box"+i/3+","+j/3+"="+val)
                )return false;
            }
        return true;
    }
}
