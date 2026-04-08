class Solution {
    public int search(int[] nums, int target) {
        // ICORE 
        // what are inputs?
        /*
            inputs -> under billion ie 10^9 we can go with num 
                ----> max targt 
            constraint->
        */
        if(nums==null|| nums.length==0)return -1;
        int n=nums.length;
        int l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==target)return m;
            else if(nums[m]<target){
                l=m+1; //increase mid
            }else{
                r=m-1;
            }
        }
        return -1;
    }
}
