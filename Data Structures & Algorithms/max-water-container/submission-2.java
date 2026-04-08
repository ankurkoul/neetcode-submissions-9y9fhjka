class Solution {
    public int maxArea(int[] h) {
        //ICORE
        if(h==null || h.length==0)return 0;
        int n=h.length;
        int res=0;
        int l=0,r=n-1;
        while(l<n && r>=0){
            int ht=Math.min( h[l], h[r]);
            res=Math.max(res, ht*(r-l));
            if(h[l]<h[r]){
                l++;
            }else{
                 r--;
                 }
        }
        return res;
    }
}
