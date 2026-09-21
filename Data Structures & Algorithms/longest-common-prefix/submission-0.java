class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre=strs[0];
        for( int next=1; next< strs.length; next++){
            String nextWord= strs[next];
            int i=0;
            while(i < Math.min(pre.length(), nextWord.length())){
                if(pre.charAt(i)!=nextWord.charAt(i)){
                    //both word not match hence found first char diff 
                     break;
                }
                i++;
            }

            pre=pre.substring(0,i); //since i doesnt include i
        }

        return pre;
    }
}