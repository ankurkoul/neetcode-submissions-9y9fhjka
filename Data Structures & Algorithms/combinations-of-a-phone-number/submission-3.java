class Solution {
    List<String> res=new ArrayList<>();
    String[] dec={
           "","", // 0,1
        "abc","def","ghi",
        "jkl", "mno", "qprs", "tuv", "wxyz"
        };
    public List<String> letterCombinations(String dig) {
        //ICORE
        if(dig.isEmpty())return res;
        StringBuilder path=new StringBuilder("");
        dfs(dig,0,path);
        return res;
    }

    private void dfs(String dig, int id, StringBuilder path){
        if(id==dig.length()){
            res.add(path.toString());
            return;
        }
        //choose
        char key= dig.charAt(id);
        String val= dec[key-'0'];

        for(char v: val.toCharArray()){
            path.append(v);
            dfs(dig,id+1, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
