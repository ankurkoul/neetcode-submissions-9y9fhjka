class Solution {
    public int lengthOfLongestSubstring(String s) {
        //s is zero return o
        if(s==null || s.length()==0)return 0;
        int l=0, r=0, res=0;
        Set<Character>set=new HashSet<>();
        while(r<s.length()){
            char rchar=s.charAt(r);
            //check if rchar is duplicate
            while(set.contains(rchar)){
                //remove duplicate from left/old
                set.remove(s.charAt(l));
                l++;
            }
            //no duplicate rchar hence
            res=Math.max(res,r-l+1);
            set.add(s.charAt(r));
            r++;
        }


        return res;
    }
}
