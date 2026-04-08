class Solution {
    public int largestRectangleArea(int[] heights) {
        // trick
        // in area btw 2 bars-> height is always limited by smallest bar in btw
        // [3,2,1,4]-> here  1 is ht btw 3&4

       
        /* Approach 1: use 2 loops
        i as starting and j as ending
        at each j find minHtSoFar and calucate area

                int minsofar=Integer.MAX_VALUE;
                for(int j=i;j<n;j++){
                    minsofar=Math.min(minsofar, heights[j]);
                    res=Math.max(res, minsofar *(j-i+1) );
                }

         //Approach 2:
            use monotonic increasing stack
            We want to find for each bar:
            1. How far it can extend to the left and right before encountering a smaller bar.
            2. That tells us how wide a rectangle we can build using this bar's height.
            */

        //a
            // hts all are +ve?
            // width is 1
            // max length of hts array
            // max value of ht[i]
        //l
            int max=0, n=heights.length;
           Deque<int[]> stack=new ArrayDeque<>(); //[index,height]
            for(int i=0;i<n;i++){ //O(N)
                int start=i;
                // start can goin left too 
                //[7,7,1,2] here 1 is start : 2th idx but it can go 0th idx too
                 //If current bar is shorter → it means previous taller bars cannot extend further → compute area for them.
                while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                    //we can move if peek is greater value
                    // why pop? since 7 cant move ahead of current idx ie 2nd
                    int[] top= stack.pop();
                    int idx=top[0];
                    int height=top[1];
                    max=Math.max(max,height*(i-idx)); // here we are not adding 1 bcz i is not inclusive
                    start=idx;  //the current smaller bar can extend left to where the previous taller bar started.
                }
                 //If the current bar is taller or equal → push to stack.
                stack.push(new int[]{start,heights[i]});//O(1)
            }

            // what abt stack elements?
            for(int[]pair: stack){  // O(n) can have max n elements
                int idx=pair[0];
                int height=pair[1];
                max=Math.max(max,height*( n - idx));
            }
            return max;
//  t: 
// while loop only performs the pop operation
    // when its condition is satisfied.
    // The key point is that each element is popped from the stack at most once during the entire process.
    // hence while loop is performing pop operations atmost 1 hence total pop for outer n loop will be N pop
    // The outer loop contributes O(n).
    // The total number of pop operations across all iterations of the while loop is: O(n)
    // O(n) (for the outer loop)+ O(n) (for the total pop operations)= O(n)
    }
//s: O(n)
}
