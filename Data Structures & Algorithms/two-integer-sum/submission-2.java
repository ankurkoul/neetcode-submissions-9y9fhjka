class Solution {
    public int[] twoSum(int[] nums, int target) {
        //l
        /*
        map ->[num, i] bcz num is comapred to target and index is saved
         iterate over nums : 0 to n
         int val= nums[i];
         map.containsKey(target- val) // 2nd pair is presnet
         return new int[] { map.get(targetr-val,i)}
        s -> o(n), t->o(n)
        */
        //a
        // nums: min or max -> if nums : +-10^10 then int or -2^32 to 2^31-1
        // num can be -ve ? what is min or max

        //b
        if(nums==null || nums.length==0 )return new int[]{};
        Map<Integer,Integer> prevMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(prevMap.containsKey(target-num))return new int[]{prevMap.get(target-num) ,i};
            prevMap.put(num, i);
        }
    return new int[]{};
        //c
    }
}
