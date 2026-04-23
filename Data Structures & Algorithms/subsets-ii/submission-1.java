class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer>subset=new ArrayList<>();
        dfs(nums, 0, subset);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, int id, List<Integer> subset){
        if(id==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        //choose
        int val =nums[id];
        subset.add(val);
        dfs(nums,id+1,subset);

        //dont choose
        //backtrack
        subset.remove(subset.size()-1);
        dfs(nums,id+1,subset);
    }
}
