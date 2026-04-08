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
        //c
        if(matrix.length==0)return false;
        int m=matrix.length;
        int n=matrix[0].length;
        int l=0, r=n-1;
        while(l<m && r>=0){
            if(matrix[l][r]==target)return true;
            if(matrix[l][r]<target)l++;
            else r--;
        }
        return false;
    }
}
