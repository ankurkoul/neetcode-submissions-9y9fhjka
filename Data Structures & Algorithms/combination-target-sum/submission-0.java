class Solution {
     List<List<Integer>>res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //q: nums -> min/max value, length: can be empty, can contains duplicate?
        //q: target-> min/max value
        res=new ArrayList<>();
        dfs(nums, target,0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int idx, List<Integer> subset){
        if(target==0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(nums.length==idx || target<0){
            return;
        }
        //choose same number again
         subset.add(nums[idx]);
         dfs(nums,target-nums[idx],idx,subset);

         //dont choose
         // backtrack
         subset.remove(subset.size()-1); 
         dfs(nums,target,idx+1,subset);
         
    }
}
