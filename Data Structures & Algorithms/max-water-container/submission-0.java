class Solution {
    public int maxArea(int[] heights) {
        int l=0,r=heights.length-1;
        int max=Integer.MIN_VALUE;
        while(l<r){
            int width=r-l;
            int lh=heights[l],rh=heights[r];
            if(lh<rh){
                max=Math.max(max,width*lh);
                l++;
            }else{
                  max=Math.max(max,width*rh);
                r--;
            }
        }
        return max;
    }
}
