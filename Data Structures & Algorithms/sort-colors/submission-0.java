class Solution {
    public void sortColors(int[] nums) {
        int i=0,l=0, r=nums.length-1;
        while(i<=r){
            if(nums[i]==0){
                //swap nums[i] with nums[l]
                swap(nums, l,i);
                l++;
                i++;
            }else if(nums[i]==2){
                swap(nums, r, i);
                r--;
            }else{
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}