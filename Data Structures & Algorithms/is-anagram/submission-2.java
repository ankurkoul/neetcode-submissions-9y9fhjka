class Solution {
    public boolean isAnagram(String s, String t) {
        //t
        /*
             Appr1:
             check length
             s->toCharArray -> sort
             t-> toCharArray-> sort
              iterate from 0 to n or Use Arrays.equal()
              if s[i]!=t[1]return false
              s->O(n) ,t->o(n +n logn)

              Approach2:
              int[]arr= new int[26] // if all lowercae
              iterate over s from 0 to n:
               arr[ s[i]-'a'] ++;
              iterate over t from 0 to n: // we can club both too
               arr[ t[i]-'a'] --;
               iterate over arr 
               if any element non zero return false;
               s-> o(n) t-> o(n)

        */
        //a 
        //b
        if(s==null && t==null)return true;
        if(s==null || t==null)return false;
        if(s.length()!=t.length())return false;

        int[]count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(i)-'a']--;
        }

        for(int c: count){
            if(c!=0)return false;
        }

        return true;
        //c

    }
}
