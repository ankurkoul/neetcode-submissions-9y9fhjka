class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        int open=0, close=0;
        backtrack(n, open, close, new StringBuilder());
        return res;
    }

    private void backtrack(int n, int open, int close , StringBuilder subset){
        if(close>open)return;
        //need to get both hence till both reach n
        if(open==close && open==n){
            res.add(subset.toString());
            return;
        }
        if(open<n){
            subset.append('(');
            backtrack(n, open+1, close,subset);
            //backtrack
            subset.deleteCharAt(subset.length() - 1);
        }
        
        if(close<open){
            subset.append(')');
            backtrack(n, open, close+1, subset );
            //backtrack -> fresh for next iteration
            subset.deleteCharAt(subset.length() - 1);
        }
       
    }
}
