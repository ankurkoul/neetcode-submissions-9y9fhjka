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

        /*
        for each n -> we need to generate 2n strings
        and each position has 2 choices, brute force would be 2^(2n).
        But pruning ensures we only generate valid combinations.
        
        we know  2^(2n) =(2^2)^n= 4^n
        eg: a^bc= (a^b)^c
        2^3n= (2^3)^n =8^n
        
        If you see these, think Catalan immediately:
            Valid parentheses
            Binary search trees count
            Mountain/valley paths
            Ways to triangulate polygon
            “Catalan = counting valid structures with constraints (like balanced parentheses).”
            Due to pruning (close ≤ open), we only generate valid combinations, 
            whose count is given by the Catalan number (~4ⁿ/√n).
            Each string takes O(n) to construct,
            so total time complexity is O(n × Catalan(n)).”

            Space complexity: O(n)

        */
       
    }
}
