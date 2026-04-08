class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /* mem notes
        1. half = (m+n+1)/2
        2. i from A → (j = half - i)
        3. left = i-1, right = i
        4. check: leftA <= rightB && leftB <= rightA
        5. adjust binary search
        */
        if(nums1.length >nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        //divide array into 2 equal parts -> left side and right side
       // LEFT  side → contains exactly `half` elements  
       // LEFT will have some elements from nums1 and nums2 arrays 
       // i = elements taken from nums1
      //  j = elements taken from nums2
      //  i + j = half
      //  nums1 (A): [ ... | ... ]
      //                 ↑ i
     //   nums2 (B): [ ... | ... ]
     //                  ↑ j

       // leftA  = last element on left side of nums1 = nums[i-1]
      //  leftB  = last element on left side of nums2
        
        /*
        we want to find median of 2 arrays without merging
        Strategy -> we can place 2 arrays side by side and making cut so that
        left of cut all elements in both array are <= right of cut
        cut need to have half+1 elements
        
        if we found so cut , then border elements around cut will give as median
        largest on left and smallest of right side

        To determine we use binary search on smaller array
        if we choose cut in smaller array (ie mid of binary) 
        we automatically get cut location for larger array since half -i;
        */

        int[] A=nums1, B=nums2;
        int m=A.length, n=B.length;
        int total=m+n , half=(total+1)/2;
        //use binary search on A
        int l=0, r=m;
        while(l<=r){
            int i= l+(r-l)/2; // i be cut index in A ie midpoint 
            int j=half-i;     // j be cut index in B

            //Define border values
            int ALeft= i>0 ? A[i-1] : Integer.MIN_VALUE;
            int ARight=i<m ? A[i] : Integer.MAX_VALUE;

            int BLeft= j>0 ? B[j-1] : Integer.MIN_VALUE;
            int BRight=j<n ? B[j] : Integer.MAX_VALUE;

            //check if partition is valid
            if(ALeft<=BRight && BLeft <=ARight){
                //found valid
                if(total%2!=0){
                    return Math.max(ALeft,BLeft);
                }
                return (Math.max(ALeft,BLeft) +Math.min(ARight,BRight) )/2.0;
            }else if(ALeft > BRight){
                //A has bigger value hence reduce cut index
                r=i-1;
            }else{
                //B has greater value means A can have higher value hence move cut index
                l=i+1;
            }
        }

        return -1;

    }
}
