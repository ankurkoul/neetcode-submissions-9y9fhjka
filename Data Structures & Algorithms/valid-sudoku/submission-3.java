class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();
         for(int i=0;i<board.length;i++)
        for(int j=0; j<board[0].length;j++){

            char val=board[i][j];
            if(val!='.'){
                if(!set.add("row" + i + "val"+ val)
                || !set.add("col" +j + "val"+val)
                || !set.add("box row"+i/3+ "col"+j/3 +"val"+val)                
                )
                return false;
            }
        }
        return true;
    }
}
