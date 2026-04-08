class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //a
            // if both are empty? then ?
            // if one is empty? then ?
            // if s1 is greater than s2
            // if contains special chars, numbers? then
            // max size of s1 and s2?
            // can have duplicate then
        //a 
            // get freq of smaller number why?
            // abc,cba,bac,bca,cab --> present in lecabee -> here cab is presnt hence true
            // abc,cba,bac,bca,cab --> present in lecaabee -> here no perm is presnt hence false
            // hence perm is just count of chars , 
            // hene any time in window of 3 have a=1,b=1,c=1 we can return true
            // sliding window: grow till window size is less than s1 size
            //in valid window check if got all counts?
            // shrink it why? bcz cant have word greater than s1.length

        //e 
            if(s1.isEmpty())return true;
            if(s1.length()>s2.length())return false;
            Map<Character,Integer> smap=new HashMap<>();
            for(char c: s1.toCharArray()){
                smap.put(c, smap.getOrDefault(c,0)+1);
            }
            //smap={a=1,b=1,c=1}
            //setup window
            int l=0,r=0, windowSize=s1.length();
            Map<Character,Integer> map=new HashMap<>();
            while(r<s2.length()){ 
                //check window is valid if not shrink it
                //since we are moving r one by one hence we can go with if condition
                if(r-l+1>windowSize){
                    //shrink window
                    char c=s2.charAt(l);
                    map.put(c, map.getOrDefault(c,0)-1);
                    if(map.get(c)<=0){
                        map.remove(c);
                    }
                    l++;
                }
                //valid window
                char c=s2.charAt(r);
                map.put(c, map.getOrDefault(c,0)+1);
                r++;
                //valid window check for coutns
                if(map.equals(smap))return true;

            }
            return false;

        //c
        //t  //if n=s1.length, s2=m.length
            // for loop : O(n)
            // while loop : o(m)
            //  inside loop : shrink :condition check : O(1) 
                        //    map update  : 0(1)
                        //    map.remove : O(1)
                        // l++            :O(1)
                //valid window
                //map update: O(1)
                // map equals is 0(26) hence O(1)
            // hence O(m)
        //s // O(26) hence we can say O(1)
    }
}
