class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
         // used[i] tells whether nums[i] is already included in current path
        boolean[] used = new boolean[nums.length];
        // start DFS with empty path
        dfs(nums, new ArrayList<>(), used);
        return res;
    }

    private void dfs(int[] nums, List<Integer> path, boolean[] used) {
        // ✅ Base case:
        // If current permutation size == nums length → we formed one full permutation
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path)); // make a copy and store
            return;
        }

         // 🔁 Try every number at current position
        for (int i = 0; i < nums.length; i++) {

            // ❌ Skip if number is already used in current permutation
            if (used[i]) continue;

            // ✅ CHOOSE
            // mark this number as used and add to current path
            used[i] = true;
            path.add(nums[i]);

            // 🔽 EXPLORE
            // go deeper to fill next position
            dfs(nums, path, used);

            // 🔙 BACKTRACK (VERY IMPORTANT)
            // undo the choice so we can try other numbers
            path.remove(path.size() - 1); // remove last added element
            used[i] = false;              // mark it as unused again
        }
    }
}
