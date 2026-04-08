class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0 || k==0 || k> nums.length)return new int[]{};
        //get most freq
        Map<Integer,Integer> map=new HashMap<>();
        for(int n: nums){
            map.put(n , map.getOrDefault(n,0)+1); //O(n)
        }
        Queue<int[]> q=new PriorityQueue<>((a,b)->a[1]-b[1]); // min heap
        for(Map.Entry<Integer,Integer> e: map.entrySet()){// O(unque elemnt) -> worst case :0(n)
            q.offer(new int[] { e.getKey(),e.getValue()}); // OlogK
            if(q.size()>k)
            q.poll(); //remove least freq O(1)
        }
        int[]res=new int[k];
        int i=0;
        while(!q.isEmpty()){
            res[i++]=q.poll()[0];//O(k)
        }
        return res;

        //s : O(n) for map and o(k) for min heap hence O(n)
        //t : nlogk -> heapify on offer
    }
}
