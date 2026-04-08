class Solution {
    public int largestRectangleArea(int[] heights) {
        //a
            // hts all are +ve?
            // width is 1
            // max length of hts array
            // max value of ht[i]
        //l
            int max=0, n=heights.length;
            Stack<int[]> stack=new Stack<>(); //[index,height]
            for(int i=0;i<n;i++){
                int start=i;
                // start can goin left too 
                //[7,7,1,2] here 1 is start : 2th idx but it can go 0th idx too
                while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                    //we can move if peek is greater value
                    // why pop? since 7 cant move ahead of current idx ie 2nd
                    int[] top= stack.pop();
                    int idx=top[0];
                    int height=top[1];
                    max=Math.max(max,height*(i-idx));
                    start=idx;  
                }
                stack.push(new int[]{start,heights[i]});
            }

            // what abt stack elements?
            for(int[]pair: stack){
                int idx=pair[0];
                int height=pair[1];
                max=Math.max(max,height*( n - idx));
            }
            return max;

    }
}
