class Solution {
    public int removeElement(int[] nums, int val) {
        //ICORE
        // Reader writer
        int validIdx=0;
        for(int reader=0; reader<nums.length; reader++){
            if(val != nums[reader]){
                nums[validIdx++] = nums[reader];
            }
        }

        return validIdx;

    }
}