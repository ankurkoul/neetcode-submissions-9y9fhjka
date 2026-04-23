class Solution {
     // Space: O(n * 2^n) → storing all subsets in result
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Time: O(n log n) for sorting (required for duplicate handling)
        Arrays.sort(nums);
         // Space: O(n) → temporary subset list
        List<Integer>subset=new ArrayList<>();
        dfs(nums, 0, subset);
        return res;
    }

    private void dfs(int[] nums, int id, List<Integer> subset){
        if(id==nums.length){
            // Time: O(n) → copying subset
            res.add(new ArrayList<>(subset));
            return;
        }
        //choose
        int val =nums[id];
        subset.add(val);  // O(1)
        // Total recursion tree size ≈ O(2^n)
        dfs(nums,id+1,subset);

        //dont choose
        //backtrack
        subset.remove(subset.size()-1); // O(1)
        //skip all duplicates
        while(id+1< nums.length && nums[id]==nums[id+1]){
            id++;
        }
        dfs(nums,id+1,subset);

        //remember [1,2,1] => will get [1,1] subset but from choose branch
    }

    //Time : n* 2^n  -> for each idx we have 2 choose hence 2^n and we do copy list hence n opeartion hence
    // The recursion explores 2ⁿ subsets,
    // and since we copy each subset in O(n),
    // total time becomes O(n × 2ⁿ). 
    // Space is dominated by storing all subsets.”
}
