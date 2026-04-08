class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())return false;
        int[] arr=new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c: t.toCharArray()){
            arr[c-'a']--;
        }
        for(int c: arr){
            if(c!=0)return false;
        }
        return true;
    }
}
