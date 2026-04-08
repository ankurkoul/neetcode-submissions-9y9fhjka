class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // need to get freq 
        // need to get top k
        Map<Integer,Integer>fmap=new HashMap<>();
        for(int n: nums){
            fmap.put(n, fmap.getOrDefault(n,0)+1);
        }
        Queue<Integer>pq=new PriorityQueue<>((a,b)->fmap.get(a)-fmap.get(b)); //min heap
        for(int n: fmap.keySet()){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            res[k-i-1]=pq.poll();
            i++;
        }
        return res;
    }
}
