class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0, r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[l]<=nums[mid]){
                //if yes it is left is sorted part
                if(nums[l]<=target && target<=nums[mid]){
                    r=mid-1;
                }else{
                    //check in other part
                    l=mid+1;
                }
            }else{
                // if no , right is sorted part
                if(nums[mid]<=target && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
