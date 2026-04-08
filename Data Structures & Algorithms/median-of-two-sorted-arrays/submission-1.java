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
        int  n= nums1.length, m= nums2.length;
        if(n>m)return findMedianSortedArrays(nums2, nums1);
        int total=n+m;
        int leftSide=(total+1)/2;

        int l=0, r= n; //choosing smaller array for binary search
        while(l<=r){
            //choosing cut1 ie middle of smaller arry
            int cut1= l+(r-l)/2;
            int cut2= leftSide-cut1; // cut2 is after remaining element 
            /**
                                                c2
            [1,2,5,6]          =>       [1,2,   |5,6]
            [3,4]                       [3,     |4 ]
                                                c1

               l2         r2                               
            [1,2        | 5,    6 ]
            [3          | 4       ]
             l1           r1                               
            */

            //determine valid split using boundary left and right across splits/cut
            int l1=cut1==0? Integer.MIN_VALUE : nums1[cut1-1]; //left to cut1 pos;
            int l2=cut2==0? Integer.MIN_VALUE : nums2[cut2-1]; //left to cut2 pos;

            int r1=cut1==n? Integer.MAX_VALUE : nums1[cut1]; //cut1;
            int r2=cut2==m? Integer.MAX_VALUE : nums2[cut2]; //cut1;

            if(l1<=r2 && l2<=r1){
                //valid split
                if(total%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1>r2){
                //means smaller element needed to be selected in smaller array hence reduce cut1
                r=cut1-1;
            }else{
                // l2>r1 or r1<l2
                 //means greater element needed to be selected in smaller array hence incr cut1
                 l=cut1+1;
            }
            
        }



        return 0;
    }
}
