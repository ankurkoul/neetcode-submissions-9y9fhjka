class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target,0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int id, List<Integer> subset) {
    if (target == 0) {
        res.add(new ArrayList<>(subset));
        return;
    }
    if (id == candidates.length || target < 0) {
        return;
    }

    // Choose the current element
    subset.add(candidates[id]);
    dfs(candidates, target - candidates[id], id + 1, subset);
    subset.remove(subset.size() - 1); // Backtrack

    // Skip duplicates properly
    while (id + 1 < candidates.length && candidates[id] == candidates[id + 1]) {
        id++;
    }

    // Proceed to the next distinct element
    dfs(candidates, target, id + 1, subset);
}

}
