class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // need to get freq 
        // need to get top k
        Map<Integer,Integer>fmap=new HashMap<>();
        for(int n: nums){
            fmap.put(n, fmap.getOrDefault(n,0)+1);
        }
        Queue<Integer>pq=new PriorityQueue<>((a,b)->fmap.get(b)-fmap.get(a)); //min heap
        for(int n: fmap.keySet()){
            pq.offer(n);
        }
        int[] res=new int[k];
        int i=0;
        while(k>i){
            res[i++]=pq.poll();
        }
        return res;
    }
}
