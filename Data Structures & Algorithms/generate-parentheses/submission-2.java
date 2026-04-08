class Solution {
    private final List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n,0,0,new StringBuilder());
       return res;  
    }

    private void helper(int n, int open ,int close, StringBuilder temp){
        if(close==n ){
            res.add(temp.toString());
        }
        if(open<n){
             helper(n,open+1,close, temp.append("("));
             //remove last char
             temp.deleteCharAt(temp.length()-1);
        }
       if(close<open){
        helper(n,open,close+1, temp.append(")"));
        temp.deleteCharAt(temp.length()-1);
       }
    }
}
