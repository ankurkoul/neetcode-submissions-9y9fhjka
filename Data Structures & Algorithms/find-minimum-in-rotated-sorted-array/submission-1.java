class Solution {
    public int findMin(int[] nums) {
        //a
        // array is sorted? roated
        // 1 to n
        // max value of n?
        // algo need log(n)-> binary search
        // l
        // min will lies where boundary are mis match
        // [3,4,5,6,1,2] => l=3, r=2 , mid=5 // 
        // [3,4,5] boundaries are l=3, r=5 here l<=r true hence l is smallest
        // [6,1,2] boundaries are l=6, r=2 here l<=r false hence min must be in between
        // we always choose not sorted part as min lies there
        // as sorted will always be greater in roated
        // if our mid is in left sorted we want to search for min in right sorted
        // if our mid is in right sorted we want to search min in left sorted
        // how to check mid is in left sorted? check left <= mid if yes then in left 
        //          if no then right is sorted
        int l=0, r=nums.length-1, res=Integer.MAX_VALUE;
        while(l<=r){
            // if sorted
            if(nums[l]<=nums[r]){
                res=Math.min(res,nums[l]);
                break;
            }
            // if not sorted
            int mid=l+(r-l)/2;
            res=Math.min(res,nums[mid]); //save mid as it could be min
            if(nums[l]<=nums[mid]){
                //search right
                l=mid+1; //skip mid too
            }else{
                //search left
                r=mid-1; //skip mid too
            }
        }
        return res;
    }
}
