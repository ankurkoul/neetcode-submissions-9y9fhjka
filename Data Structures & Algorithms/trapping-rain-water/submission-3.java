class Solution {
    public int trap(int[] height) {
        int n =height.length;
        int l=1, r= n-2;
        int lmax=height[0], rmax=height[n-1];
        int res=0;
        while(l<=r){
            if(lmax<rmax){
               lmax=Math.max(lmax,height[l]);
               res+=lmax-height[l];
               l++;
            }else{
                rmax=Math.max(rmax,height[r]);
                res+=rmax-height[r];
               r--;
            }
        }
        return res;
    }
}
