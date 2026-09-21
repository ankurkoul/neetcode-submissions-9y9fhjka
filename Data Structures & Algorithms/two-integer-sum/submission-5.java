class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int[][] numsWithIndex=new int[n][2];

        for(int i=0;i<n;i++){
            numsWithIndex[i][0]=nums[i];
            numsWithIndex[i][1]=i;
        }

        // created array with map to old index hence we can sort them no

        Arrays.sort(numsWithIndex, (a,b)->a[0]-b[0]);

        int i=0, j=n-1;
        while(i<j){// dont cross and dont self select
        int sum= numsWithIndex[i][0] +numsWithIndex[j][0];
        // ZReturn the answer with the smaller index first.
        if(sum==target) {
            // when index order doesnt matter
           // return new int[]{ numsWithIndex[i][1], numsWithIndex[j][1]};
           return new int[]{ 
                Math.min ( numsWithIndex[i][1], numsWithIndex[j][1]),
                Math.max ( numsWithIndex[i][1], numsWithIndex[j][1]),
            };
        }
        if(sum<target) i++;
        if(sum > target)j--;
        }
        return new int[0];
    }
}
