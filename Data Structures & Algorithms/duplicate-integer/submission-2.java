class Solution {
    public boolean hasDuplicate(int[] nums) {
        //l:
        /*
        Use set: if value is not present add else return true
        s-> 0(n), t->O(n)


        Use sorting:
        so all duplicate will be together
        hence start loop from 1 to n
        and check a[i-1]==a[i] if yes true
        s-> o(1) t-> o(nlogn)
        */
        if(nums==null || nums.length==0)return false;
        Set<Integer> set=new HashSet<>();
        for( int n: nums){
            if(!set.add(n))return true;
        }
        return false;
        //a 
        //b
        //c
    }
}