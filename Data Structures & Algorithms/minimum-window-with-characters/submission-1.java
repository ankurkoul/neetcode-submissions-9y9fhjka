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
                tmap.put(c, tmap.getOrDefault(c,0)+1); //O(T)
            }
            
            int resL=Integer.MAX_VALUE;
            int l=0,r=0;
            String res="";
            int charsMatchedFully=0;
            Map<Character,Integer> smap=new HashMap<>();
            while(r<s.length()){
                char rchar=s.charAt(r);
                smap.put(rchar,smap.getOrDefault(rchar,0)+1);
                if(tmap.containsKey(rchar)&& tmap.get(rchar).equals(smap.get(rchar))){
                    charsMatchedFully++;
                }
                while(charsMatchedFully==tmap.size()){
                    // got all chars
                    // save res and shrink window
                    if((r-l+1)<resL){
                        resL=r-l+1;
                        res=s.substring(l,r+1);
                    }
                    //shrink
                    char lchar=s.charAt(l);
                    smap.put(lchar,smap.get(lchar)-1);
                    if(tmap.containsKey(lchar)&& tmap.get(lchar)>smap.get(lchar)){
                        charsMatchedFully--;
                    }
                    l++;
                }
                r++;
            }
            return resL==Integer.MAX_VALUE?"": res;
    }
}
