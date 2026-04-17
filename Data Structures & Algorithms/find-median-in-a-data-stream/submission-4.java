class MedianFinder {
    Queue<Integer> smallHeap;
     Queue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap=new PriorityQueue<>(Collections.reverseOrder());
        largeHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        //push in one heap
        smallHeap.add(num);
        if(smallHeap.size() - largeHeap.size()>1 ){
            largeHeap.offer(smallHeap.poll());
        }

        if(!largeHeap.isEmpty() && smallHeap.peek()> largeHeap.peek()){
            largeHeap.offer(smallHeap.poll());
        }

        //after inserting check
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        //both heap are same means even number hence avg
        if(smallHeap.size() == largeHeap.size()){
            return (double)(smallHeap.peek()+largeHeap.peek())/2.0;
        }else if (smallHeap.size() > largeHeap.size()){
            return smallHeap.peek();
        }else{
            return largeHeap.peek();
        }
        
    }
}
