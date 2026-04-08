class Solution {
    List<String> res=new ArrayList<>();
    String[] dict={
        "","", // 0,1
        "abc","def","ghi",
        "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())return res;
        dfs(0,"",digits);
        return res;
    }

    private void dfs(int id, String cur, String digits){
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
         //choose
        char key= digits.charAt(id);
        String value=dict[key-'0'];

        for(char v: value.toCharArray()){
            dfs(id+1, cur+v,digits);
        }
    }
}
