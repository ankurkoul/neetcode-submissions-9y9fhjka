class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        int open=0, close=0;
        backtrack(n, open, close,"");
        return res;
    }

    private void backtrack(int n, int open, int close , String subset){
        if(close>open)return;
        if(open==close && open==n){
            res.add(subset);
            return;
        }
        if(open<n)
        backtrack(n, open+1, close,subset+"(");
        if(close<open)
        backtrack(n, open, close+1, subset +")");
    }
}
