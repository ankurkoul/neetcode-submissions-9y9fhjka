class Solution {
    public int longestConsecutive(int[] nums) {
        //icore
        if(nums==null || nums.length==0)return 0;
        Set<Integer> set=new HashSet<>();
        for(int n: nums)set.add(n);
        int max=0;
        for(int n: nums){
            //check if no predecessor
            if(set.contains(n-1))continue;
            int cur=0;
            while(set.contains(n++)){
                cur++;
            }
            max=Math.max(max,cur);
        }

        return max;
    }
}
