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

      int[] A=nums1;
      int[] B=nums2;
      int m=A.length, n=B.length;
      int half= (m+n+1) /2;
      int l=0, r=A.length; //choosing smaller array
      while(l<=r){
        int mid= l+(r-l)/2;
        // consider this i means cut point
        int i=mid;
        int j=half-i; 

        int Aleft=i>0? A[i-1] : Integer.MIN_VALUE;
        int Aright=i<m ? A[i] : Integer.MAX_VALUE;

        int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
        int Bright = j < n ? B[j] : Integer.MAX_VALUE;

        if(Aleft <=Bright && Bleft<=Aright){
            //found valid partition
            if((m+n)%2==1){
                return Math.max(Aleft,Bleft);
            }
             return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
        }else{
            //adjust paritions either remove elements from A or B
            if(Aleft > Bright) {
                //means remove A
                r=i-1;
            }else{
                //add higer elemente from A
                l= i+1;
            }
        }

      }
        return -1;
        
    }
}
