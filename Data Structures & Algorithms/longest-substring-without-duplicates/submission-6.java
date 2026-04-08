class Solution {
    public int lengthOfLongestSubstring(String s) {
        //a
        /*
        s-> length() will be 0 to 10^9?
        case: lowercase only?
        can include special char like  blank space?

        */
        //b
        if(s==null|| s.length()==0)return 0;
        //c
        //2 pointer approach
        // l, r-> r will move till we find unique char
        // for unique char check at constant time set use
        // as soon i encounter duplicate i will l and remove char from set
        // at each non conflict point i will calualte r-l+1 and compare with max to get value

        int l=0,r=0,max=0;
        Set<Character> set=new HashSet<>();
        while(r<s.length()){
            char c=s.charAt(r++);
            while(set.contains(c)){
                set.remove(s.charAt(l++));
            }
            set.add(c);
            max=Math.max(max,r-l);
        }
        return max;
    }
}
