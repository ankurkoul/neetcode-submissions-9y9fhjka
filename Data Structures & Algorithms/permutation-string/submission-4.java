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
        //t
        //s
        */
        if(s1.isEmpty()) return true;
        if(s1.length()>s2.length())return false;
        // get count of s1 chars
        Map<Character,Integer> count=new HashMap<>();
        for(char c: s1.toCharArray()){
            count.put(c, count.getOrDefault(c,0)+1);
        }

        //sliding window
         Map<Character,Integer> count2=new HashMap<>();
         int l=0,r=0;
         while(r<s2.length()){
            char c2=s2.charAt(r);
            count2.put(c2, count2.getOrDefault(c2,0)+1);
             if((r-l+1)>s1.length()){
                char c3=s2.charAt(l++);
                count2.put(c3, count2.get(c3)-1);
                if(count2.get(c3)==0){
                    count2.remove(c3);
                }
             }
             if(count.equals(count2))return true;
             r++;
         }
        return false;
    }
}
