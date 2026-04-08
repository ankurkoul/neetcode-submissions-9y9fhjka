class Solution {
    public String minWindow(String s, String t) {
        //a
            // s < t then?
            // s or t : min/mx?
            // s/t can be lower/upper?
            // s/t can have special chars?
            // s is empty
            // t is empty

        //l 
            // count of t: "xyz"-> x=1,y=1,z=1
            // slide window: grow until find all chars 
            // find all chars: first match save substring
            // shrink behind till chars 
            // return minwindow with all count of t 
            Map<Character,Integer> tmap=new HashMap<>();
            for(char c: t.toCharArray()){
                tmap.put(c, tmap.getOrDefault(c,0)+1);
            }
            int l=0,r=0,min=Integer.MAX_VALUE;
            int have=0, need=tmap.size();
            String res="";
            Map<Character,Integer> smap=new HashMap<>();
            while(r<s.length()){
                char cc= s.charAt(r);
                smap.put(cc, smap.getOrDefault(cc,0)+1);
                if(tmap.containsKey(cc) && smap.get(cc).equals(tmap.get(cc))){
                    have++;
                }
                while(have==need){
                   //valid window save it
                   if(r-l+1<min){
                    min=r-l+1;
                    res=s.substring(l,r+1);
                   }
                   // shrink window
                   char lcc= s.charAt(l);
                   smap.put(lcc, smap.getOrDefault(lcc,0)- 1);
                   if(tmap.containsKey(lcc) && tmap.get(lcc)>smap.get(lcc)){
                    have--;
                   }
                   l++;
                }
                r++;
            }

            return min==Integer.MAX_VALUE? "": res;
        //t
        //s
    }
}
