class Solution {
    public boolean hasDuplicate(int[] nums) {
        // boundaries first
        // nums is empty or null -> then return false
        // since integer what range  2billion  (10^9)
        // use array if range small less -> less than 1000 as no hashing overhead

        if(nums== null || nums.length==0)return false;
        if(nums.length>1000){
            return chooseArrayOption(nums);
        }
        return chooseSetOption(nums);
    }

    private boolean chooseArrayOption(int[] nums){
        // no hasing overheading
        // s-> o(n) , t -> for each n elments o(1) lookup hence o(n)
        boolean[] isPresent=new boolean[1000];
        for(int n: nums){
            if(isPresent[n]){
                return true;
            }
            isPresent[n]=true;
        }
        return false;
    }

     private boolean chooseSetOption(int[] nums){
        Set<Integer> seen=new HashSet<>();
         for(int n: nums){
            if(!seen.add(n))return true; // seen.contains() return true;
         }
        return false;
     }
}