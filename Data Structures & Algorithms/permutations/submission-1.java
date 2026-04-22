class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        List<Integer> path=new ArrayList<>();
        dfs(nums, visited, path);
        return res;
    }

    private void dfs( int[]nums, boolean[] visited, List<Integer> path){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //choose number 
        for(int i=0; i< nums.length ; i++){
            // ❌ Skip if number is already used in current permutation
            if(visited[i])continue;
            // ✅ CHOOSE
            visited[i]=true; // mark used
            path.add(nums[i]); //add to path

            //explore ,go for next post
            dfs(nums,visited, path); // it has  visited[i]as true and nums[i] added

            // BACKTRACK 
            visited[i]=false; // mark unused
            path.remove(path.size() - 1);  // remove last added element
        }

    }

    

}
