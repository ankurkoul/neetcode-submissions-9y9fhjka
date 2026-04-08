class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if(nums==null || k==0 || nums.length==0) return new int[]{};
         int n=nums.length;
         int[] res=new int[n-k+1];
         Deque<Integer> indexQ=new ArrayDeque<>();
         for(int i=0;i<n;i++){
            // montonic decreasing index
            // verify new value is max
            //
            while(!indexQ.isEmpty() && nums[indexQ.peekLast()]<nums[i]){
                indexQ.pollLast();
            }
            indexQ.offerLast(i);
            //if invalid range
            while(indexQ.peekFirst()<i-k+1){
                indexQ.pollFirst();
            } 
            if(i-k+1>=0){
                res[i-k+1]=nums[indexQ.peekFirst()];
            }        
         }
         return res;
    }
}
