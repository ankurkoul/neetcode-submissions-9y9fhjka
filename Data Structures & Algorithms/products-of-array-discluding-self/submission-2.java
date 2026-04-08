class Solution {
    public int[] productExceptSelf(int[] nums) {
        //a
        //nums<=10^9 , nums[i]<=10^9? 
        int[] res=new int[nums.length];
        if(nums==null || nums.length==0)return res; 
        int p=1;
        for(int i=0;i<nums.length;i++){
            res[i]=p;
            p*=nums[i];
        }
        p=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=p;
            p*=nums[i];
        }
        return res;
    }
}  
