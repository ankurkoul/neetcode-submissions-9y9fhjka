class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //here we have option to go with staircase search or binary search
        // staircase -> good when there is no link between two sorted rows 
        // every iteration of the loop: we either move one row down (l++) Or move one column left (r--).
        // max no. of rows you can move down is m,
        // and the max no. of columns you can move left is n.
        // hence time complexity : O(m+n)

        // binary search : Strictly Sorted: Every row starts higher than the previous row ends.
        int n=matrix.length, m=matrix[0].length;
        int l=0, r=n*m-1;
        while(l<=r){
            int mid=l+(r-l/2);
            //determine mid x and mid y 
            int midx=mid/m;
            int midy=mid%m;
            if(matrix[midx][midy]==target)return true;
            else if(matrix[midx][midy]<target)l=mid+1;
            else r=mid-1;
        }
        return false;
    }
}
