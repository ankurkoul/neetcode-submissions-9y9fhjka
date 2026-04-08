class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //a
            // if size is less than 3?
            //  can be negative?
            //  if no res?
            // order?
            // max_ min values hence 10^5 is within int range
            // sorted ?
            // what to return?
        //e
        if(nums.length<3)return new ArrayList<>();
        //sorted?
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int i=0;
        while(i<nums.length-2){
            //reset j and r after each i teration
            int j=i+1;
            int r= nums.length-1;
            while(j<r){
                int num1= nums[i];
                int num2= nums[j];
                int num3= nums[r];
                int sum= num1+num2+num3;
                if(sum==0){
                   res.add(Arrays.asList(num1,num2,num3));
                   j++;
                   r--;
                }
                else if(sum>0)r--;
                else j++;
            }
            i++;
        }
        return new ArrayList(res);
    }
}
