class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if(nums==null || k==0 || nums.length==0) return new int[]{};
         int n=nums.length;
         int[]res=new int[n-k+1];
         Deque<Integer>indexq=new ArrayDeque<>();
         for(int i=0;i<n;i++){
            // verify queue before adding keep it montonic decereasing qa
            // left -> is max and right ->is min
            while(!indexq.isEmpty() && nums[indexq.peekLast()]<nums[i]){
                indexq.pollLast();
            }
            indexq.offerLast(i);
            //adjust left side to remove invlaidabstract
            if(indexq.peekFirst()<i-k+1){
                indexq.pollFirst();
            }
            if(i-k+1>=0){
                //
                res[i-k+1]=nums[indexq.peekFirst()];
            }
         }
          return res;
    }
}
