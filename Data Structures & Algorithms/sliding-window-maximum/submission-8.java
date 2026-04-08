class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || k==0 || nums.length==0) return new int[]{};
    return approach(2,nums,k);
    }

    private int[] approach(int ch, int[] nums, int k){
        switch(ch){
            case 1: return brute(nums,k);
            case 2: return heap(nums,k);
            case 3: return deque(nums,k);
            default:return new int[]{};
        }
    }

    private int[] heap(int[] nums, int k){
        int n=nums.length;
        int[] res= new int[n-k+1];
        Queue<int[]> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int r=0;r<n;r++){
            //remove out of range values for queue before insert 
            // left boundary is r-k+1
            while(!maxHeap.isEmpty() && maxHeap.peek()[1]< r-k+1){
                maxHeap.poll();
            }
            //insert new value
            maxHeap.offer(new int[]{ nums[r], r});
            //if left boundary is postive
            if(r-k+1>=0){
                res[r-k+1]=maxHeap.peek()[0];
            }
        }
        return res;
    }


    private int[] brute(int[] nums, int k){
        int n=nums.length;
        int[] res= new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            int min=nums[i];
            for(int j=i;j<i+k; j++){
                min=Math.max(min, nums[j]);
            }
            res[i]=min;
        }
        return res;
    }

        //a
            // nums length can be max?
            // nums[i] can be -ve ?
            // nums[i] can be min or max?
            // what can be size of k?
        //l
          // monotonic decrease Queue:  why?
          // bcz i dont maintain lower values at left since i willnt revist lower value
          // 
    
          // [1,1,2,3] ,k=3 
          // here [1,1,2]-> 2
          // now if shift window we dont need to check [1,2,3]
          // hence we dont need to check for 1,2 again
          // hence we can remove 1
          // we can have queue we keep adding until we find value greater than it ,
          // if it is value we require
          /*
           nums -> [1,1,1,1,1,4,5] , k=6
           Q->  [1]
                [1,1]
                [1,1,1]
                [1,1,1,1]
                [1,1,1,1,1]
                [1,1,1,1,1] [4] hence value is greater
                [1,1,1,1,X] [4]
                [1,1,1,1]   [4]
                [1,1,1,X]   [4]
                [1,1,1]     [4]
                [1,1]       [4]
                [1,X]       [4]
                [1]         [4]
                [x]         [4]
                //remove all lesser value and then add 4
                [4]
                // if window is k size add left most value to output
                --> output[4]
                [4] [5]
                [x] [5]
                //add 5
                if window and left most value is 5

                t: O(1) -> add, there O(N)

                Why deque?
                we want to add /remove from r: O(1)
                we want to remove from l: O(1)

          */
    private int[] deque(int[] nums, int k){
        int n=nums.length;
        int[] res= new int[n-k+1]; // +1 to make n from 0 offest to 1 offest
        //montonic Decreasing Deque
        Deque<Integer> deque=new ArrayDeque<>(); // // Store indices, not values
        for(int i=0;i<n;i++){
            // Remove indices out of current window
            while(!deque.isEmpty() && deque.peekFirst()<i-k+1){
                 deque.pollFirst();
            }
            // maintian decreasing property
            // Remove smaller values from the back when new max comes
            while(!deque.isEmpty() && nums[deque.peekLast()]<= nums[i]){
                deque.pollLast();
            }
             // Add current index to deque
            deque.offerLast(i);
            // Add the max for current window
            if(i-k+1<0)continue;
            res[i-k+1]=nums[deque.peekFirst()];
        }


        return res;
    }

     private int[] deque2(int[] nums, int k){  
        Deque<Integer> q = new LinkedList<>(); // Store indices, not values
        int n=nums.length;
        int[]res =new int[n-k+1];
        int l=0,r=0,idx=0;
        while(r<n){
            //remove queue :r
            while(!q.isEmpty() && nums[q.peekLast()]< nums[r]){
                q.pollLast();
            }
            //add new r
            q.addLast(r);

            //remove left if out of limit mean r-k+1
            if(!q.isEmpty() && q.peekFirst()< (r-k+1)){
                q.pollFirst();
            }
            if(r+1>=k){
                res[idx++]=nums[q.peekFirst()];
            }
            //last update r for next iteration
            r++;
        }
        return res;
    }
}