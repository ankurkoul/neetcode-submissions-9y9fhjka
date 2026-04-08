class Solution {
    public int longestConsecutive(int[] nums) {
        //A
        /**
        nums .length <=10^9
        nums[i]<=+/-10^9
        */
        //B
        if(nums==null || nums.length==0 )return 0;
        //C
        int max=0;
        Set<Integer> set=new HashSet<>(); //store all nums so that i can get num in O(1)time
        for(int n: nums){
            set.add(n);
        }
        for(int n: nums){
            if(set.contains(n-1))continue; //skip since not starting num
            int cur=0;
            while(set.contains(n++)){
                cur++;
            }
            max=Math.max(max,cur);
        }
        
        return max;
    }
}
