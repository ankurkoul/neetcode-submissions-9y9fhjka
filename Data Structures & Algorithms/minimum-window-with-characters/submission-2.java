class Solution {
    public String minWindow(String s, String t) {
        //icore
        if(t==null || s==null || s.length()<t.length())return "";
        Map<Character,Integer>tmap=new HashMap<>();
        for(char c: t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        int req=tmap.size();
        int l=0,r=0,min=Integer.MAX_VALUE;;
        String res="";
        Map<Character,Integer>smap=new HashMap<>();
        while(r<s.length()){
            char rchar=s.charAt(r);
            smap.put(rchar,smap.getOrDefault(rchar,0)+1);
            if(tmap.containsKey(rchar) && tmap.get(rchar)==smap.get(rchar)){
                req--; //found matching char
            }
            while(req==0){
                //found all char 
                //save string and try shrink
                if(min>r-l+1){ 
                    min=r-l+1;
                    res=s.substring(l,r+1);
                }
                //shrink by move l and updaing lchar and check req
                char lchar = s.charAt(l++);
                smap.put(lchar, smap.get(lchar) - 1);

                if(tmap.containsKey(lchar) && smap.get(lchar) < tmap.get(lchar)) {
                    req++;
                }
            }
            r++;   
        }
        return min==Integer.MAX_VALUE?"":res;
    }
}
