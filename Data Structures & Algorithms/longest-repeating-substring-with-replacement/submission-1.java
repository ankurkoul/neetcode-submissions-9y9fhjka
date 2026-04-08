class Solution {
    public int characterReplacement(String s, int k) {
        /**
        //a
            min or max s?
            can lowercase or special char?
        //l 
            replacement count should be less than k;
            min replacement is possible if we turn non most freq char
            hence replacement is (window-maxf)
            valid window: grow window   by moving r++
            invalid     : shrink window by moving l++
        //e

        //t

        /s
        
        */
        if(s==null || s.isEmpty())return 0;
        int l=0,r=0;
        Map<Character,Integer>count=new HashMap<>();
        int res=0,maxF=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            count.put(ch, count.getOrDefault(ch,0)+1);
            maxF=Math.max(maxF,count.get(ch));
            if((r-l+1)-maxF>k){
                char ch2=s.charAt(l++);
                count.put(ch2,count.get(ch2)-1);
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
}
