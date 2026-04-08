class Solution {
    public boolean hasDuplicate(int[] nums) {
        //a
        //e
        if(nums==null || nums.length==0)return false;
        Set<Integer> set=new HashSet<>();
        for(int n: nums){
            if(!set.add(n))return true;
        }
        return false;

        //s: o(n)
        //t: o(n)
    }
}
