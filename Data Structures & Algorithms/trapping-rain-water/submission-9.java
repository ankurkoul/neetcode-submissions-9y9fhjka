class Solution {
    public int trap(int[] height) {
        //a 
        /*
        height[i] -> +ve and width of 1 -> 0 to 10^6
        height.length -> 1 to 10^6
        we need atleast 3 height to store water
        we cant store water at boundary hence h[0]and h[legth-1] cant store water
        how much water can be stored? depends on left/right neigbour (which ever is min)
        [0,1,0,2]
        at 0 index-> 0 boundary
        at 1 index->0 as prev was 0 hence this is boundary
        at 2 index-> either 1 or 2 which ever is min hence 1
        at 3 index-> 0 boundary
        
        [4,2,5]
        here at 1 index-> Min(4,5)-2 = water it cant be -ve


        Appraoch1:
        min of lmax and rmax ->prefix array and suffix array
        */
        //b
       
        if(height==null ||height.length<3)return 0;
        //c
        return approach1(height);
    }

    private int approach1(int[] height){
        int[] pre=new int[height.length];
        int[] suf=new int[height.length];

        int max=0;
        for(int i=0;i<height.length;i++){
            pre[i]=max;
            max=Math.max(max, height[i]);
        }

        max=0;
        for(int i=height.length-1;i>=0;i--){
            suf[i]=max;
            max=Math.max(max, height[i]);
        }
        int res=0;
        for(int i=0;i<height.length;i++){
            int cap=Math.min(pre[i],suf[i])-height[i];
            res+=Math.max(cap,0);
        }

        return res;
    }
}
