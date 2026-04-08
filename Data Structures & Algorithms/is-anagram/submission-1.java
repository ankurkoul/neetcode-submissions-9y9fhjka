class Solution {
    public boolean isAnagram(String s, String t) {
        //a
        //e
        if(s== null || t==null || s.length()!=t.length()){
            return false;
        }
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int id= c-'a';
            count[id]++;
        }

        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            int id= c-'a';
            count[id]--;
        }

        for(int c: count){
            if(c!=0)return false;
        }
        return true;
    }
}
