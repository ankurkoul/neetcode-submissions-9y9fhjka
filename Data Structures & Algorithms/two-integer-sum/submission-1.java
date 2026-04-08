class Solution {
    public int[] twoSum(int[] nums, int target) {
        //a
            //always length is 2 to 1000
            // nums[i] and target both are int range
            // both can be -ve
            //return idx
        //e
           Map<Integer,Integer> map=new HashMap<>();
           for(int i=0;i<nums.length;i++){
            int partner= target-nums[i];
            if(map.containsKey(partner)){
                int partnerIdx=map.get(partner);
                return new int[]{partnerIdx,i};
            }
            map.put(nums[i],i);
           }
        return new int[]{};
    }
}
