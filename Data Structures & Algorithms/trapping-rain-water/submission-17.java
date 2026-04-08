class Solution {
    public int trap(int[] height) {
        if(height==null ||height.length<3)return 0;
        return approach1(height);
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
