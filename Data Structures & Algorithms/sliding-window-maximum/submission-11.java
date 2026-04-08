class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         if(nums==null || k==0 || nums.length==0) return new int[]{};
        return heap(nums,k);
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
}
