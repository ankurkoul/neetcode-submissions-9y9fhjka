class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
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


        Deque<Integer> q = new LinkedList<>(); // Store indices, not values
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int idx = 0;
        int r=0;
        while(r < n) {
            // Remove indices whose values are smaller than the current value
            while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                q.removeLast();
            }

            // Add the current index to the deque
            q.addLast(r);

                    // Remove indices that are out of the current window
            if (!q.isEmpty() && q.peekFirst() < r - k + 1) {
                q.removeFirst();
            }

            // Start adding to the output array once the window size is met
            if (r >= k - 1) {
                output[idx++] = nums[q.peekFirst()];
            }
            r++;
        }

        return output;
    }
}