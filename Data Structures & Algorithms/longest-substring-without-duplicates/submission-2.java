class Solution {
    public int lengthOfLongestSubstring(String s) {
        //a
            // no duplicates
            // empty string possible?
            // lowercase or uppercase? if both then treat them disctinct or same?
            // can have empty space in between?
            // max length of string? under 10^10
            // special characters?
        //e
            if(s.length() ==0)return 0;

        //c
            Set<Character> set=new HashSet<>();
            int start=0,end=0,max=0;
            while(end<s.length()){
                char c=s.charAt(end);
                // Remove characters from the set until the duplicate is removed
                // dvdf at idx=2 , c='d',set={d,v} hence found duplicate hence slide window
                while(set.contains(c)){
                    set.remove(s.charAt(start++));
                }
                set.add(c);
                max=Math.max(max, end-start+1);
                end++;
            }
            return max;
        //t
        //s
    }
}
