class Solution {
    public int lengthOfLongestSubstring(String s) {
        //icore
        if(s==null|| s.length()==0)return 0;
        Set<Character>set=new HashSet<>();
        int l=0,r=0,res=0;
        while(r<s.length()){
            char rchar=s.charAt(r);
            while(set.contains(rchar)){
                set.remove(s.charAt(l++));
            }
            res=Math.max(res, r-l+1);
            set.add(s.charAt(r));
            r++;
        }

        return res;
    }
}
