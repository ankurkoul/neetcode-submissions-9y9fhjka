class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        // a:
            can it be case specific?
            also include special , numbers?
            min length or max?
        // l
            Set --> till no duplicate grow window -> r++
            found duplicate start shrinking from back ->l++
        // e 
        // t
        // s
        */
        if(s == null || s.isEmpty())return 0;
        int l=0,r=0, max=0;
        Set<Character> set=new HashSet<>();
        while(r<s.length()){
            char c=s.charAt(r);
            while(set.contains(c)){
                char cc=s.charAt(l);
                set.remove(cc);
                l++;
            }
            set.add(c);
            max=Math.max(max,r-l+1);
            r++;
        }

        return max;

    }
}
