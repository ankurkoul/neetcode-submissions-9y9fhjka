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
