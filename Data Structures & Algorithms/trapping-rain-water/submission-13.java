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


        Apprach 2:
        we are concerned with min of left/right neighbour if move inward from boundary based on min 
        why 2 ptr approach work?
        
        height=[6,1,2,2,5,4]
        here lmax=6 rmax=4
        we know ever index dpends on min of lmax ,rmax 
        hence rmax is value and we check value of its inward neighbour
        5 -> rmax[5,4]-5=0
        now lmax=6, rmax=5
        again rmax is min and we check value of its inward neighbour
        2->rmax[5,2]-2=3
         now lmax=6, rmax=5
        again rmax is min and we check value of its inward neighbour
        2->rmax[5,2]-2=3
        now lmax=6, rmax=5
        again rmax is min and we check value of its inward neighbour
        1->rmax[5,1]-1=4
        */
        //b
       
        if(height==null ||height.length<3)return 0;
        //c
        //return approach1(height);
        return approach3(height);
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
           
            res+=Math.max(cap,0); //ignore -ve values
        }
        return res;
    }

     private int approach2(int[] height){
        int n= height.length;
        int lmax=height[0], rmax=height[n-1];
        int l=1, r=n-2;
        int res=0;
        while(l<=r){
            if(lmax<rmax){
              //try to improve lmax hence we move it
              lmax=Math.max(lmax, height[l]);
              int cap= lmax-height[l];
              res+=cap;
             System.out.println("left : " + height[l]+ " cap : "+cap +" lmax : "+lmax);
              l++;
            }else{
                rmax=Math.max(rmax,height[r]);
                int cap=rmax-height[r];
                res+=cap;
                System.out.println("right : " + height[r]+" cap : "+cap);
                r--;
            }
        }
        return res;
     }

    private int approach3(int[] height){
        int n=height.length;
        int l=1, r=n-2;
        int lmax=height[0], rmax=height[n-1];
        int res=0;
        while(l<=r){
            if(lmax< rmax){
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
