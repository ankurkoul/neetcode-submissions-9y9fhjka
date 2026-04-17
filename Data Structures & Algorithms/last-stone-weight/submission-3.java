class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        // load queue
        for(int s: stones){
            maxHeap.offer(s);
        }
        //proess q
        while(maxHeap.size()>1){
            int heavy1st = maxHeap.poll();
            int heavy2nd = maxHeap.poll();
            int res= heavy1st - heavy2nd;
            if(res!=0){
                maxHeap.offer(res);
            }
        }

        return maxHeap.isEmpty()?0:maxHeap.peek();
        
    }
}
