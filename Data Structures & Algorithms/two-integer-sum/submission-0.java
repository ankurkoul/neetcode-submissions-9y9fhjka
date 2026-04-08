class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valueIndex=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int cur=nums[i];
            int rem=target-cur;
            if(valueIndex.containsKey(rem)){
                return new int[]{valueIndex.get(rem),i};
            }
            valueIndex.put(cur,i);
        }
        return new int[]{};
    }
}
