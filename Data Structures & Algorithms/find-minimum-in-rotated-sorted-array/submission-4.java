class Solution {
    public int findMin(int[] nums) {
        //icore
        if(nums==null || nums.length==0)return -1;
        int n=nums.length;
        int l=0, r=n-1;
        int min=Integer.MAX_VALUE;
        while(l<=r){
            //not roated
            if(nums[l]<nums[r]){
                min=Math.min(min, nums[l]);
                break;
            }
            //is rotated?
            int mid=l+(r-l)/2;
            min=Math.min(min, nums[mid]);
            //check for disruption
            if(nums[l]>nums[mid]){
                r=mid-1;
            }else{
                l=mid+1;
            }
            
        }
        return min;
    }
}
