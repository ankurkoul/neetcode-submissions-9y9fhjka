class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       //create freq map
       Map<Integer, Integer> count = new HashMap<>();
       for(int num: nums){
         count.put(num, count.getOrDefault(num,0)+1);
       }
       
       // we need k most freq hence min heap (with only k largest freq atanytime )
        Queue<int[]>minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            minHeap.offer(new int[]{ entry.getKey(), entry.getValue()});
            if(minHeap.size()>k)
                minHeap.poll();
        }

        int[] res=new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            res[i++]=minHeap.poll()[0];
        }

        return res;
    }
}
