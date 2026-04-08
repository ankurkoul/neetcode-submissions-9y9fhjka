class Solution {
    boolean isOnlyLowercase=false;
    boolean isBothCaseSame=false;

    public boolean isAnagram(String s, String t) {
        //Anangram -> string has same characters
        //boundaries -> s or t is null -> return false
        // if length diff -> return false;
        // s or t both null -> return true;
        // s or t range -> less than 2 billion or not?
        // s or t -> characters case -> lowercase only?
        // s or t size-> only lowercase/uppercase -> need int[26]
        // if both -> int[52] -> with x- 'a' or x-'A'
        // if ascii -> 2^7 -> 128 char  -> int[126]
        //if unicode -> map<Character,Integer>

        // if both case -> then case senstivity
        // what chars allowed ? like space/comma
        if(s==null && t== null) return true;
        if( s== null || t== null) return false;
        if(s.length() != t.length()) return false;
        if(isOnlyLowercase){
            return isOnlyLowercase(s,t);
        }
        //if mixed case
        if(isBothCaseSame){
            //convert string to lowercase
            String lowerS = s.toLowerCase();
            String lowerT = t.toLowerCase();
            return isOnlyLowercase(lowerS,lowerT);
        }else{
            return useMap(s,t);
        }

        //return false;
    }

    boolean isOnlyLowercase(String s, String t) {
        int[] charArr=new int[26];
        for(char c: s.toCharArray()){
            charArr[c-'a']++;
        }
        for(char c: t.toCharArray()){
            charArr[c-'a']--;
        }

        for(int c: charArr){
            if(c!=0)return false;
        }
        return true;
    }
    boolean useMap(String s, String t) {
        Map<Character,Integer> countMap=new HashMap<>();
        for(char c: s.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
           if(!countMap.containsKey(c)){
                return false;
           }
           countMap.put(c, countMap.get(c)-1); 
           if(countMap.get(c)==0){
            countMap.remove(c);
           }
        }
        return true;
    }
}
