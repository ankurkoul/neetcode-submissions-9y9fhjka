class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
        int[]res=new int[n];
        int acc=1;
        for (int i = 0; i < n; i++) {
            res[i]=acc;
            acc*=nums[i];
        }

        acc=1;
        for(int j=n-1;j>=0;j--){
            res[j]*=acc;
            acc*=nums[j];
        }

        return res;
    }
}  
