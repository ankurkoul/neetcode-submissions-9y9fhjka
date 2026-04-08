class Solution {
    // Time Complexity: O(2^(t/m) * m)
    // Space Complexity: O(t/m)
    // where t = target, m = minimum value in nums array
    /*
    Why t/m ?
    t is the target sum we are trying to achieve.
    m is the minimum value in the nums array.
    In the worst case, the smallest number 
    m is repeatedly chosen to reach the target.
Example:
    If nums = [2, 3, 5] and target = 8, the subset could be:
    [2,2,2,2] which is 8/2=4
    More generally,
    the maximum number of elements in a subset occurs,
    when we repeatedly use the smallest number.
    */

    List<List<Integer>> res;

        public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Initializing result list
        // Space Complexity: O(2^(t/m) * m) in the worst case to store all subsets
        res = new ArrayList<>();
        
        // Start DFS traversal from index 0 with an empty subset
        dfs(nums, target, 0, new ArrayList<>());
        
        // Return the result containing all possible subsets
        return res;
    }

    private void dfs(int[] nums, int target, int idx, List<Integer> subset) {
        // Base case: if target is met, add the current subset to the result
        if (target == 0) {
            // Adding a subset to result
            // Time Complexity: O(m) to copy the current subset
            // Space Complexity: O(m) for the copied subset
            res.add(new ArrayList<>(subset));
            return;
        }

        // If no more numbers to process or target is negative, backtrack
        if (nums.length == idx || target < 0) {
            return;
        }

        // Choose the current number again
        subset.add(nums[idx]);
        // Recursive call: choosing the same number
        // Time Complexity: Recursively branches, leading to 2^(t/m) calls
        // Space Complexity: Maximum recursion depth is O(t/m)
        dfs(nums, target - nums[idx], idx, subset);

        // Backtrack: remove the last added number to explore other combinations
        subset.remove(subset.size() - 1); 

        // Recursive call: skipping to the next number
        // Time Complexity: Continues branching, part of the overall 2^(t/m) calls
        dfs(nums, target, idx + 1, subset);
    }
}