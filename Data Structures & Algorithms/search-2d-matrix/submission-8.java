class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // convert 2d array into 1 d array
        /*
            [
            [1, 3, 5, 7],
            [10, 11, 16, 20],
            [23, 30, 34, 50]
            ]
        as big sorted list
            [1, 3, 5, 7, 10, 11, 16, 20, 23, 30, 34, 50]
            how to convert big sorted index into 2d index 
            eg: 16 -> in big list idx=6 and original idx=[1,2]
            ie 6/4 and 6%4 where 4 is total columns
        */

        int n=matrix.length, m=matrix[0].length;
        int low=0, high= n*m-1;
        while(low<=high){
            int mid=low+(high-low)/2; // 16 ie idx 6
            int midx=mid/m;    // 1 -> [6/4]
            int midy=mid%m;    // 2 ->[6 % 4]
            if(target==matrix[midx][midy])return true;
            else if(target<matrix[midx][midy]){ //mid is greater
                high=mid-1;
            }else{
                low=mid+1;
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


