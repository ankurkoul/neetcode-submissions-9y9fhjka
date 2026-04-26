class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s.isEmpty())return res;
        int startIdx=0;
        List<String> part=new ArrayList<>();
        dfs(s,startIdx,part);
        return res;
    }

    private void dfs(String s, int startIndex, List<String> part){
        if(startIndex== s.length()){
            res.add(new ArrayList<>(part));// o(n ) at leaf neode
            return;
        }
    
    //At each position: we have choice Cut ❌ or Not cut ✅ hence we have 2 choice
    /*
    Each valid partition corresponds to:

        a | b | c | d

    👉 Each | is optional

        So:

    cut or not cut → binary decision

    👉 👉 👉 👉 Partitioning = cut or not cut → 2ⁿ”
    
    */
        for(int endIndex=startIndex ;endIndex< s.length() ; endIndex++){
        
            if(isPallindrome(s, startIndex, endIndex)){
                String sub=s.substring(startIndex, endIndex+1);
                part.add(sub);
                //go to nextindex
                dfs(s,endIndex+1,part);
                //backtrack
                part.remove(part.size()-1);
            }
        }
    }
    //total work is (n* 2^n) 
    

    private boolean isPallindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
