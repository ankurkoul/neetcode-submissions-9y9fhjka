class Solution {
    public int trap(int[] height) {
        //a
            // zero or +ve integers
            // width is 1
            // water cant be -ve at any position
            // in case of 2 hts: 0
            // atlease 3 hts must be there
            // at any point max is will help as get max area
            // we cant store water at end as it flow away
            // [0,1,0,2]
            // here at 0, no water
            // here at 1, no water can stay as left is open
            // here at 0 ,water can be stored as covered from both end
                // how much water can be stored?
                    // depends on left/right neigbour
                    // which ever is min
                    // here 1 is left max, 2 is right max
                    // it cant hold 2 as 1 will allow water flow
                    // 1 is max 
                    // but if it has own ht it cant hold that much too
                // per position:
                     // min(l,r)-h[i];
                                    // need consider it can be negative 
                                    // if negative consider 0
            //here at 2, no water as border
        //e 
            // approach 1:
            // at each position we need to check max left and max right
            // maxleft[]--->[]--> 0 to n-1 get left max for i idx
            // maxRight[]-->[]--> n-1 to 0 get right max for i idx
            // calculate min(l,r)-h[i]
            //return approach1(height);
            return approach2(height);
        //t
        //s
    }
    private int approach2(int[] height){
        // 2 pointer why?
        // at each point we focus on min of left,right
        // we arent concerned with max
        // [1,2,........10....3]
        // here we are at 2, we know left neigh is lowest

        // l        r
        // maxL, maxR  --> so far
        // always shift smaller left,right
        if(height == null || height.length<3)return 0;
        int n=height.length;
        int l=1, r=n-2; // ignore border 
        int lmax=height[0],rmax=height[n-1];// border as max
        int res=0;
        while(l<=r){
            if(lmax<rmax){
                //this one we want choose
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

    private int approach1(int[] height){
        if(height == null || height.length<3)return 0;
        int n=height.length;
        int[]leftMax=new int[n];
        int[]rightMax=new int[n];

        int max=0;
        for(int i=0;i<n;i++){
            leftMax[i]=max;
            max=Math.max(max, height[i]);
            //System.out.println("at "+i +": "+Arrays.toString(leftMax));
        }
        max=0;
        for(int i=n-1;i>=0;i--){
            rightMax[i]=max;
            max=Math.max(max, height[i]);
           // System.out.println("at "+i +": "+Arrays.toString(rightMax));
        }
        int sum=0;
        for(int i=0;i<n;i++){
            int minMax=Math.min(leftMax[i],rightMax[i]);
            sum+=Math.max(minMax-height[i],0); // cant have -ve added to result
        }
        return sum;
    }
}
