class MedianFinder {
    //two Heaps
    // min Of greater values
    Queue<Integer> largerMinHeap=new PriorityQueue<>();
     // max Of smaller values
    Queue<Integer> smallerMaxHeap=new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        //add number to smallerMaxHeap
        smallerMaxHeap.offer(num);
        // move from smallHeap to largerHeap
        if(smallerMaxHeap.size()-largerMinHeap.size()>1 || 
            (!largerMinHeap.isEmpty() && largerMinHeap.peek()< smallerMaxHeap.peek())
        ){
            largerMinHeap.offer(smallerMaxHeap.poll());
        }
         // move from largerHeap to smallHeap
        if(largerMinHeap.size()-smallerMaxHeap.size()>1){
            //largerMinHeap.offer(smallerMaxHeap.poll());
            smallerMaxHeap.offer(largerMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if(smallerMaxHeap.size()>largerMinHeap.size())return (double) smallerMaxHeap.peek();
        if(largerMinHeap.size()>smallerMaxHeap.size())return (double) largerMinHeap.peek();
        return (double)( smallerMaxHeap.peek() + largerMinHeap.peek())/2;
    }
}
