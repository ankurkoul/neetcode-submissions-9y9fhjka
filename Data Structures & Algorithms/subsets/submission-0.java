class Solution {
    List<List<Integer>> res=new ArrayList<>();
   
    public List<List<Integer>> subsets(int[] nums) {
        //Q:
        // max /min value nums
        //  max length of nums array
        //  return as arrayList

        dfs(nums,0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> subset){
        if(nums.length==idx){
            res.add(new ArrayList<>(subset));
            return;
        }
        //choose
        subset.add(nums[idx]);
        dfs(nums,idx+1,subset);
        //dont choose
        subset.remove(subset.size()-1);
         dfs(nums,idx+1,subset);
    }

}
