class Solution {
    public int[] productExceptSelf(int[] nums) {
       //ICORE
       if(nums==null || nums.length==0)return new int[]{};
       int n=nums.length;
       int[] res=new int[n]; 
       int acc=1;
       for(int i=0;i<n;i++){
        res[i]=acc;
        acc*=nums[i];
       }
       acc=1;
       for(int i=n-1;i>=0;i--){
        res[i]*=acc;
        acc*=nums[i];
       }
        return res;
    }
}  
