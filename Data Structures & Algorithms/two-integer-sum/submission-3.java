class Solution {
    public int[] twoSum(int[] nums, int target) {
        //boundaries  -> nums null or zero?
        // nums ->max range less than 2 billion ie 2ˆ9
        // target -> max value +/- 2 billion ie 2ˆ9
        // nums[i]- > value +/-2 billion ie 2ˆ9

        if(nums ==null || nums.length==0) return new int[]{};
        Map<Integer,Integer> valueIndexMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int n= nums[i];
            Integer pre=valueIndexMap.get(target- n);
            if(pre==null) valueIndexMap.put(n,i);
            else return new int[]{ pre,i};
        }
        return new int[]{};
    }
}
