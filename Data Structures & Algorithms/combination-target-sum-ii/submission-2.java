class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        res=new ArrayList<>();
        //sort to allow all duplicate come together
        Arrays.sort(cand);
        dfs(cand,target,0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] cand, int target, int id, List<Integer> subset){
        if(target ==0){
            res.add(new ArrayList<>(subset));
            return;
        }
        if(target<0 || id== cand.length)return;
        int val=cand[id];
        //choose but not repeat
        subset.add(val);
        dfs(cand, target -val , id+1 , subset);

        //dont choose
        //bcaktrack
        subset.remove(subset.size()-1);
        //move id to not prev
        while(id+1 < cand.length && cand[id]==cand[id+1]){
            id++;
        }
        dfs(cand, target , id+1 , subset);
    }
}
