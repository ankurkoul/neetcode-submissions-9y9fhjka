class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //a 
       //e
       Map<Integer,Integer> fmap=new HashMap<>();
       for(int n: nums){
        fmap.put(n, fmap.getOrDefault(n,0)+1);
       }
       // use min or max heap to get top k 
       // here we will sort by freq
       Queue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer>e: fmap.entrySet()){
            minHeap.offer(e);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=minHeap.poll().getKey();
        }
        return res;
       
    }
}
