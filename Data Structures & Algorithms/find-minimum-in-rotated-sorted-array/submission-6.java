class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)return -1;
        int l=0, r=nums.length-1, res=Integer.MAX_VALUE;
        while(l<=r){
            int m=l+(r-l)/2;
            // if sorted part
            if(nums[l]<=nums[r]){
                res=Math.min(res, nums[l]);
                break;
            }
            //if not sorted 
            res=Math.min(res, nums[m]);
            // if(nums[l] <= nums[m]){
            //     r=m-1;
            // }else{
            //     l=m+1;
            // }
              if(nums[l]<=nums[m]){
                //search right
                l=m+1; //skip mid too
            }else{
                //search left
                r=m-1; //skip mid too
            }
        }
        return res;
    }
}
