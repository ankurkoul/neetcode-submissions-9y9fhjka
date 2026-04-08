class Solution {
    public int search(int[] nums, int target) {
        //a
            //nums can be negative, min,max, length of nums?
            //sorted
            //target : max, min value, if not present then?
            //sorted+ logn :=> binary search

        if(nums.length==0)return -1;
        int l=0,r= nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}
