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
            int mid=low+(high-low)/2;
            int midx=mid/m;
            int midy=mid%m;
            if(target==matrix[midx][midy])return true;
            else if(target<matrix[midx][midy]){ //mid is greater
                high=mid-1;
            }else{
                low=mid+1;
            }

        }
        return false;
    }
}
