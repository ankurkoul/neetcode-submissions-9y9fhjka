class Solution {
    public int characterReplacement(String s, int k) {
        //icore
        if(s== null || s.length()==0)return 0;
        if(k<0)return 0;
        //get count
        Map<Character,Integer> countMap=new HashMap<>();
        int l=0,r=0,res=0,maxF=0;
        while(r<s.length()){
            char rchar=s.charAt(r);
            countMap.put(rchar,countMap.getOrDefault(rchar,0)+1);
            maxF=Math.max(maxF,countMap.get(rchar));
            while((r-l+1) -maxF > k){
                char lchar=s.charAt(l++);
                countMap.put(lchar,countMap.get(lchar)-1);
            }
            res=Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}
