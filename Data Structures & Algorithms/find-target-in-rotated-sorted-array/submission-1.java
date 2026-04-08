class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        int n=nums.length;
        int l=0, r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target)return m;

            //search which part it lie 
            //if sorted array
            if(nums[l]<=nums[m]){
                if(nums[l]<=target && target<=nums[m]){
                    // reduce current space 
                    r=m-1;
                }else{
                    l=m+1;
                }
            }else{
                 if(nums[m]<=target && target<=nums[r]){
                    // reduce current space 
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }
        return -1;

    }
}
