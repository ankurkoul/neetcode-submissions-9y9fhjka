class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
               //a
            // number distinct in both list?
            // max size of num1 , num2,
            // can they be empty?
            // max min values of num1, num2
            // for even-sized combined arrays, how is the median defined?

        //l
        /*
         a=[1,2,3,4]         => n=4
         b=[1,2,3,4,5,6,7,8] => m=8
         here median=(4+8)/2=> 6 but it 0 index hence  (n+m+1) rather (n+m)
         
         
         int partitionY = half - (partitionX + 1) - 1;  
		//PartitionX is 0 indexed so you need to add 1 
        to exactly know the size of partition 1.
        
        Then you subtract it from half to know the size of partition B.
        Once you do that  extra -1 at the end
        because we want to calculate index of partitionY. Partition should be 0 indexed as we are dealing with arrays.
        Even if you calculate this,  you get half - partitionX - 2 in the end.
         
         */
        int n= nums1.length, m=nums2.length;
        int total=n+m;
        int half = (total ) / 2;
        if(n>m)return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int r = n; //include extra element in left parttion
         while (l <= r) {
            int amid = (l + r) / 2;
            int bmid = half - amid;

             int aright = amid == n ? Integer.MAX_VALUE : nums1[amid];
             int bright = bmid == m ? Integer.MAX_VALUE : nums2[bmid];

             int aleft = amid == 0 ? Integer.MIN_VALUE : nums1[amid - 1];
             int bleft = bmid == 0 ? Integer.MIN_VALUE : nums2[bmid - 1];


             if (aleft <= bright && bleft <= aright) {
                if (total % 2 != 0) {
                    return Math.min(aright, bright);
                }
                return (Math.max(aleft, bleft) + Math.min(aright, bright)) / 2.0;
            }else if(aleft > bright){
                //remove a
                r=amid-1;
            }else{
                l=amid+1;
            }
        }
        return -1;
    }
}
