class KthLargest {
    Queue<Integer>minHeap;
    int k;
    public KthLargest(int k, int[] nums) {
        
        this.minHeap=new PriorityQueue<>();
        this.k=k;
        //load all values from num;
        for(int n: nums){
            add(n);
        }
    }
    
    public int add(int val) {
        /*
        Insert first. why? [4, 5, 8]   // size = 3, it removes 4 and then offer(10) [5, 8, 10]
        If size exceeds k → then remove smallest.
        */
        minHeap.offer(val);
        if(minHeap.size()>k){
                minHeap.poll();
        }
        return minHeap.peek();

    }
}
