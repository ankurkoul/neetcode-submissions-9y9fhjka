class Solution {
    // Time Complexity: O(2^(t/m) * m)
    // Space Complexity: O(t/m)
    // where t = target, m = minimum value in nums array

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // q: nums -> min/max value, length: can be empty, can contain duplicates?
        // q: target -> min/max value
        res = new ArrayList<>();
        dfs(nums, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int idx, List<Integer> subset) {
        // Base case: if target is met, add the current subset to the result
        if (target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        // If no more numbers to process or target is negative, backtrack
        if (nums.length == idx || target < 0) {
            return;
        }

        // Choose the current number again
        subset.add(nums[idx]);
        dfs(nums, target - nums[idx], idx, subset);

        // Backtrack: remove the last added number and try the next one
        subset.remove(subset.size() - 1);
        dfs(nums, target, idx + 1, subset);
    }
}
