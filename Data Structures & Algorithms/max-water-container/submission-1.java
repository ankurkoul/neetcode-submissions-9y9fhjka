class Solution {
    public int maxArea(int[] heights) {
       //A
       /**
       I/o: heights -> height can be -ve?  range of heights?
                    -> we cant assume same bars as width=0
        Approach- > at each step we calcaute -> Min(a[l],a[r])*(r-l);
        move small ht ptr            
    
       */
       if(heights== null || heights.length==0)return 0;
       int max=0;
       int l=0, r=heights.length-1;
       while(l<r){
        int lh=heights[l];
        int rh=heights[r];
        int area=Math.min(lh,rh)*(r-l);
        max=Math.max(max,area);
        if(lh<rh)l++;
        else r--;
       }

       return max;
    }
}
