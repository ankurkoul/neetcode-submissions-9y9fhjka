class Solution {
    private final List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,0,0,"");
       return res;  
    }

    private void helper(int n, int open ,int close, String temp){
        if(close==n && open==n ){
            res.add(temp);
        }
        if(open<n){
             helper(n,open+1,close, temp+"(");
        }
       if(close<open){
        helper(n,open,close+1, temp+")");
       }
    }
}
