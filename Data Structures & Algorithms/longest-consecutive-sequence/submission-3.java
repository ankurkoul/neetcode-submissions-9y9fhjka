class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int n: nums){
            set.add(n);
        }
        int max=0;
        for(int n: nums){
            // if prev exist it is not starting point
            // prevent mult number iterations
            //If the sequence is [1, 2, 3, 4]
            //loop enter for 1 and skip for 2,3,4
           // hence total work done is O(n)
            if(set.contains(n-1))continue;
            //no prev it is start point
            int cmax=0;
            while(set.contains(n++)){
                cmax++;
            }
            max=Math.max(max,cmax);
            
        }
        return max;
    }
}
