class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0 ,new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int id , List<Integer> subset){
        if(id==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        //choose
        subset.add(nums[id]);
        dfs(nums,id+1,subset);
        //dont choose
        subset.remove(subset.size()-1);
        dfs(nums,id+1,subset);
    }
}
