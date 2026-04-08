class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int n: nums)
            set.add(n);
            
        int max=0;
        for(int n: nums ){
            //check for previous
            if(set.contains(n-1))continue;
           // it has no previous
           //check for consective next
           int cmax=0;
           while(set.contains(n++)){
            cmax++;
           }
           max=Math.max(max,cmax);
        }
        return max;
    }
}
