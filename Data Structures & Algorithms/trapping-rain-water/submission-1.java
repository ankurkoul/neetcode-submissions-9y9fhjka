class Solution {
    public int trap(int[] height) {
        int n=height.length;
       int l=1, r=n-2; //water can be trapped between 2nd and 2nd last
       int lmax=height[0], rmax=height[n-1];// height of trap is based on least max
       int res=0;
       while(l<=r){
        if(lmax<rmax){
           lmax=Math.max(lmax,height[l]);
           res+=lmax-height[l]; // remaining height
           l++;
        }else{
            rmax=Math.max(rmax,height[r]);
            res+=rmax-height[r]; // remaining height
            r--;
        }
       }
       return res;
    }
}
