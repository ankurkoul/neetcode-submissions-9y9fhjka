class Solution {
    public int trap(int[] height) {
        if(height==null ||height.length<3)return 0;
        return approach2(height);
    }

    private int approach2(int[] h){
        int n=h.length;
        int l=1, r=n-2;
        int lmax=h[0], rmax=h[n-1];
        int res=0;
        while(l<=r){
            if(lmax<rmax){
                //improve lmax
                lmax=Math.max(lmax, h[l]);
                res+=lmax-h[l++];
            }else{
                rmax=Math.max(rmax, h[r]);
                res+=rmax-h[r--];
            }
        }
        return res;
    }

    private int approach1(int[] h){
        int n=h.length;
        int[]p=new int[n];
        int[]s=new int[n];
        int res=0;
        // build prefix max
        for(int i = 1; i < n; i++){
            p[i] = Math.max(p[i-1], h[i-1]);
        }
        for(int r=n-2;r>=0;r--){
            s[r]=Math.max(s[r+1],h[r+1]);
        }

        for(int l=1;l<n-1;l++){
            res+=Math.max(Math.min(p[l],s[l])-h[l],0);
        }

        return res;
    }
}
