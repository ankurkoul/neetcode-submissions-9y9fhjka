class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs ==null || strs.length==0)return null;
        if(strs.length==1) return strs[0];

        //return scanApproach(strs);
        return sort_choose_first_last_word_Approach(strs);


    }

    private String sort_choose_first_last_word_Approach(String[] strs){
        // Sorting N things = N log N operations.
        // But each operation involves comparing strings = up to M work.
        //  Therefore (N log N × M) where N is number of strings.
            Arrays.sort(strs);
            int n= strs.length;
            // now compare first and last word only since after sorting they will be most differnt
            int min= Math.min(strs[0].length(), strs[n-1].length());
       // min means max upto M hence loop will run M times
            for(int i=0; i<min ;i++){
                if(strs[0].charAt(i)!=strs[n-1].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
            return strs[0];
    }

    private String scanApproach(String[] strs){
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