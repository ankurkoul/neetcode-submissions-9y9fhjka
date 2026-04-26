class Solution {
    /**

    Backtracking is required only when we modify shared mutable state. With String, each recursive call gets a new copy, so no backtracking is needed—regardless of whether we use a loop or not.”
    
    “Each digit maps to at most 4 characters,
    so the recursion tree has branching factor 4 and depth n, giving O(4ⁿ). Since we build strings of length n, total time becomes O(n × 4ⁿ).
    Space is dominated by storing all combinations.”


    here for 
    
    */


    List<String> res=new ArrayList<>();
    String[] dec={
           "","", // 0,1
        "abc","def","ghi",
        "jkl", "mno", "qprs", "tuv", "wxyz"
        };
    public List<String> letterCombinations(String dig) {
        //ICORE
        if(dig.isEmpty())return res; //O(1)
        StringBuilder path=new StringBuilder("");
        dfs(dig,0,path);
        return res;
    }

    private void dfs(String dig, int id, StringBuilder path){
        //This happens inside recursion 
        // hence Repeat 4^n times:
        //  do O(n) work
        //“The O(n) work happens for each of the 4ⁿ combinations, so instead of adding,
        // we multiply, giving O(n × 4ⁿ).”
        if(id==dig.length()){
            res.add(path.toString()); //O(n)
            /**

            path = "abcd"   (length = 4)
            
            toString():
                    copy 'a'
                    copy 'b'
                    copy 'c'
                    copy 'd'
            Number of operations = 4 = n
            O(n)

            Java cannot reuse the same memory as String is immutable
            👉 It must create a new String object

            hence cost of .add is O(1) and .toString is O(n)
            */
            return;
        }
        //choose
        char key= dig.charAt(id);
        String val= dec[key-'0'];

        for(char v: val.toCharArray()){  // Loop over all possible characters (max 4)
             // Tree height = n
            // Branching factor = up to 4 -> each index we have 4 choice 
            // choice ^ height = 4 ^ n
            path.append(v);
            dfs(dig,id+1, path);
            path.deleteCharAt(path.length()-1);
        }

        /*
        “We use backtracking where each digit gives up to 4 choices, and recursion depth is n, 
        so we generate 4ⁿ combinations.
        At each leaf, we build a string of length n, which takes O(n), 
        so total time complexity is O(n × 4ⁿ). 
        Space complexity is O(n) for recursion and O(n × 4ⁿ) for storing results.”

        choices → depth → total nodes → work per node → final complexity

        “Branching factor ^ depth × work per leaf”
        
        */
    }
}
