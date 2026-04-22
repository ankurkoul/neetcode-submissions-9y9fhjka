class Solution {
     List<List<Integer>>  res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res=new ArrayList<>();
        dfs(nums,target, 0 ,new ArrayList<>()); // id
        return res;
    }

    private void dfs(int[] nums, int target, int id ,List<Integer> subset){
        if(target==0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(id==nums.length || target <0){
            return;
        }
        int val=nums[id];
        /**
        If reuse is allowed → stay on same index
        If reuse is NOT allowed → move to next index
        
        */
        //choose
        // choose (stay on same index to allow reuse)
        subset.add(val);
        dfs(nums,target-val,id,subset);
        //dont choose
        // backtrack
        subset.remove(subset.size()-1);
        dfs(nums,target,id+1,subset);

        /*
        
        time complexity:
        “In worst case,
         we keep picking the smallest number until target becomes 0, so depth = t/m.”

        t/m → max depth (how many numbers we can pick)
        we have 2 choice at all levels hence 
        time complexity is 2^ (t/m)
        space complexity : t/m
        
        */
    }
}
