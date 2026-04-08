class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /**
        //a
            s1 > s2 return false
            max size of s2? can it be greater than 10^10
            can there be special chars?
            if uppercase do we need to handle?
        //l
            we can get count of s1 char
            then start sliding window on s2
            window can grow till s1 size is match
            window shrink if more than s1 size is match 
            update count map
            check both maps
        //t :O(n)+o(m)*O(26)
        //s:)(26)
        */
        if(s1.isEmpty()) return true;
        if(s1.length()>s2.length())return false;
        //get s1 freq in map
        Map<Character,Integer> smap=new HashMap<>();
        for(char c: s1.toCharArray()){
            smap.put(c,smap.getOrDefault(c,0)+1);
        }

        int l=0,r=0;
         Map<Character,Integer> smap2=new HashMap<>();
         while(r<s2.length()){
            char c=s2.charAt(r);
            smap2.put(c, smap2.getOrDefault(c,0)+1);
            //invalid window
            if(r-l+1>s1.length()){
                char lc=s2.charAt(l++);
                smap2.put(lc,smap2.get(lc)-1);
                if(smap2.get(lc)<=0){
                    smap2.remove(lc);
                }
            }
            if(smap.equals(smap2))return true;
            r++;
         }
         return false;
    }
}
