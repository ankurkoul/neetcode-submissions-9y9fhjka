class Solution {
    public int majorityElement(int[] nums) {
        int cand=0, vote=0;
        for(int num: nums){
            if(vote==0){
                cand = num;
            }

            if(num == cand){
                vote++;
            }else{
                vote--;
            }
        }

        return cand;
    }
}