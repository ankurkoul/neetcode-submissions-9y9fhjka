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
        String path="";
        dfs(dig,0,path);
        return res;
    }

    private void dfs(String dig, int id, String path){
        if(id==dig.length()){
            res.add(path);
            return;
        }
        //choose
        char key= dig.charAt(id);
        String val= dec[key-'0'];

        for(char v: val.toCharArray()){
            dfs(dig,id+1, path+v);
        }
    }
}
