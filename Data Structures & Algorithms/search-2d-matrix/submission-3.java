class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //a
        // matrix: mXn : max value of m,n , can grid be empty?
        // target not present then return what?
        // each row is non decreasing
        // first integer is every row is greater than previous row last integer
        // max, min integer it can store ?
        // target max. min value
        // log(m*n): binarty search
        
        //return stairCaseSearch(matrix,target);
        return binarySearch(matrix,target);
    }
     private boolean binarySearch(int[][] matrix, int target) {
        //here we do binary search on rows to find deseried row: log m
        // once found row we do binary search on cols to find desired val: log n
        // hence logm+logn hence log(m+n);
        //find row
        int ROWS=matrix.length, COLS=matrix[0].length;
        int top=0,  bot=  ROWS-1;
        int targetRow=Integer.MAX_VALUE;
        //row search
        while(top<=bot){
            int midRow= top+(bot-top)/2;
            // check if target is larger than largest value in this row?
            // yes we can mov lower bound hence top=midRow+1;
            int largestValueInMidRow=matrix[midRow][COLS-1];
            int smallestValueInMidRow=matrix[midRow][0];
            if(target > largestValueInMidRow){
                //increase lower bound
                top=midRow+1;
            }else if(target< smallestValueInMidRow){
                //decrease upper bound
                bot=midRow-1;
            }else{
                //found desired row 
                targetRow=midRow;
                break;
            }
        }

        //check we are out bcz of break or loop end?
        if(targetRow==Integer.MAX_VALUE)return false;
        int l=0,r=COLS-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(target > matrix[targetRow][m]){
                //target is greater hence increase currentn
                l=m+1;
            }else if(target<matrix[targetRow][m]){
                //target is smaller hence decrease value
                // remove greater value
                r=m-1;
            }else{
                return true;
            }
        }
        return false;


     }
    private boolean stairCaseSearch(int[][] matrix, int target) {
                //stair case search
        if(matrix.length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0, r=n-1;
        while(l<m && r>=0){
            if(matrix[l][r]==target)return true;
            if(matrix[l][r]<target)l++; // m rows or
            else r--;                   // n cols
        }
        return false;

        //t:
        // here we either go m rows down or n cols left hence m+n.
        // Why O(m+n) and Not O(m×n)?
        // The algorithm does not visit every element of the matrix.
        // Instead, it eliminates one row or one column in every step, reducing the search space efficiently.
    }
}
