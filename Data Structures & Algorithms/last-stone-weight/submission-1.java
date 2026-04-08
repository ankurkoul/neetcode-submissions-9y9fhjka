class Solution {
    public int lastStoneWeight(int[] stones) {
        //Q
        // what is max/min value of stone can it be more 10^10 
        // what is no of stones ?
        // can it be emopty? if yes then return what?

        //we need heaviest stone: maxheap can give it O(1)

        //approach1
        return  heapify(stones);

    }

    private int heapify(int[] stones){
       // Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a); //as descending b-a or Integer.compare(b,a)
       // Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder()); //as descending b-aor 
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int s: stones){
            maxHeap.offer(s); // nlogn
        }
        while(maxHeap.size()>1){ //atleast 2
            int first= maxHeap.poll();
            int sec=  maxHeap.poll();
            int diff=first-sec;
            if(diff==0)continue; // both stomne destroyed
            maxHeap.offer(diff);

        }
        
        return maxHeap.isEmpty()?0:maxHeap.peek();
    }
}
