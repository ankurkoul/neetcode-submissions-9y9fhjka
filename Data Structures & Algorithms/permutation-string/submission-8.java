class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //ICORE
        if(s1==null || s1.isEmpty())return true;
        if(s2==null || s2.length()<s1.length())return false;
        //collect all necessary char count for s1
        Map<Character,Integer> s1map=new HashMap<>();
        for(char c: s1.toCharArray()){
            s1map.put(c,s1map.getOrDefault(c,0)+1);
        }
        int l=0,r=0;
        Map<Character,Integer> s2map=new HashMap<>();
        while(r<s2.length()){
            char c=s2.charAt(r);
            s2map.put(c,s2map.getOrDefault(c,0)+1);
            if(r-l+1>s1.length()){ //have more char than required hence not valid hence shrink 
                 char c2=s2.charAt(l++);
                 s2map.put(c2,s2map.getOrDefault(c2,0)-1);
                 if(s2map.get(c2)==0){
                    s2map.remove(c2);
                 }
            }
            if(s1map.size()==s2map.size()){
                if(s1map.equals(s2map))return true;
            }
            r++;
        }
        return false;

    }
}
