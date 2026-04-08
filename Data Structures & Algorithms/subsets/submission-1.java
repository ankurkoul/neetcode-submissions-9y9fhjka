class Solution {
    List<List<Integer>> res = new ArrayList<>();
   
    public List<List<Integer>> subsets(int[] nums) {
        // Questions to ask:
        // 1. What is the maximum length of the nums array?
        //    - Important for understanding time and space complexity.
        // 2. Can nums be empty?
        //    - Edge case to consider.
        // 3. Are all elements unique?
        //    - Affects whether we need to handle duplicate subsets.
        // 4. What is the range of integer values in nums?
        //    - Could impact constraints or performance.
        // 5. Should the subsets be returned in any specific order?
        //    - Affects the implementation and sorting logic.
        // 6. Can we use additional data structures or libraries?
        //    - Could simplify or optimize the solution.

        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int idx, List<Integer> subset) {
        // Base case: If we've considered all elements
        if (nums.length == idx) {
            // Copying current subset -> O(n) operation per subset
            res.add(new ArrayList<>(subset)); 
            return;
        }
        
        // Choose the current element
        subset.add(nums[idx]); // O(1)
        dfs(nums, idx + 1, subset);

        // Don't choose the current element (backtrack)
        subset.remove(subset.size() - 1); // O(1)
        dfs(nums, idx + 1, subset);
    }
}
