class KthLargest {
    /**
    Q:
    what is max range of k?
    what will happen K is greater than nums.length
    what can be values of nums? -ve  or +Ve?
    duplicate values are there? 
    can nums be empty?
    */
    Queue<Integer> minHeap;
    int k;
    // we need k largest : maxHeap remove k-1
    //or minHeap with size k , allowing val greater than root
    public KthLargest(int k, int[] nums) {
        // data structure to use
        // max heap or min heap
        // max heap : root will store max element 
        //              and to get kth largest need to remove k-1 elements
        //              hence each peek : KlogK (in case we are maintain only k)
        // hence min heap is better
        // minHeap:  keeps the smallest element at the root
        //           heap size is k ,
        //  if we maintain largest values in heap say 10,20,30 
        // and pick up smallest of them is 10 which actually 1st smallest and k largest
        minHeap=new PriorityQueue<>();
        this.k=k;
        for(int n: nums){
            add(n);
        }

    }
    
    public int add(int val) {
        if(minHeap.size()<k)minHeap.offer(val);
        else if(val> minHeap.peek()){
            minHeap.poll(); //remove root
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
