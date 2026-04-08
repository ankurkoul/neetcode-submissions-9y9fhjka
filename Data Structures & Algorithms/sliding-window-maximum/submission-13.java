class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k==0 || nums.length==0) return new int[]{};
        return deque(nums,k);
    }

    private int[] brute(int[] nums, int k){
        int n=nums.length;
        int[] res=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int max=nums[i];
            for(int j=i;j<i+k;j++){
                max=Math.max(max, nums[j]);
            }
            res[i]=max;
        }
        return res;
    }

    private int[] heap(int[] nums, int k){
        int n=nums.length;
        int[] res=new int[n-k+1];
        int idx=0;
        Queue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){
           maxHeap.offer(new int[]{nums[i],i});
           //if maxheap index point outside range remove it
           while(maxHeap.peek()[1]<i-k+1){
            maxHeap.poll();
           }
          if (i >= k - 1)
          res[idx++]=maxHeap.peek()[0];

        }
        return res;
    }

   private int[] deque(int[] nums, int k){
        int n=nums.length;
        int[] res=new int[n-k+1];
        Deque<Integer>q=new ArrayDeque<>();// Store indices, not values
        //Use a deque to store indices of elements in decreasing order of their values.
        for(int i=0;i<n;i++){
            //q -> montanic decreasing q
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.addLast(i);
            //window left boundary outside range
            if(q.peekFirst()<i-k+1){
               q.pollFirst(); 
            }
                //FRONT → largest element index 
                //BACK  → smallest element index
                //q.peekFirst() = index of maximum element
                //Max element may still be inside next window
               //We should only remove it when it goes out of range
            if(i-k+1>=0)
            res[i-k+1]=nums[q.peekFirst()];
        }
        return res;
   }
}
