class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<>());
        return res;
    }

    void dfs(int[]nums, int id, List<Integer> subset){
        //base
        if(id==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        // choose
        subset.add(nums[id]);
        dfs(nums,id+1, subset);
        // dont choose
        //backtrack
        subset.remove(subset.size()-1);
        //skip all match id
        while(id+1<nums.length && nums[id]==nums[id+1]){
            id++;
        }
        //here id+1 will not be same as id
         dfs(nums,id+1, subset);
    }
}
