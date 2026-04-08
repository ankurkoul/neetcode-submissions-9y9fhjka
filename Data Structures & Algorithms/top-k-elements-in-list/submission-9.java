class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         if(nums==null || nums.length==0 || k==0 || k> nums.length)return new int[]{};
         //return minHeapApproach(nums,k);
         return bucketSortApproach(nums,k);

    }
    public int[] bucketSortApproach(int[] nums, int k){
         //get most freq
        Map<Integer,Integer> map=new HashMap<>();
        for(int n: nums){
            map.put(n , map.getOrDefault(n,0)+1); //O(n)
        }
        //have count array 
         //int[] countArray =new int[nums.length+1]; // but we can multiple values at same freq hence need list of array
         List<Integer>[] countArray =new  List[nums.length+1];
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
           int key=e.getKey();
           int val=e.getValue();
           if(countArray[val]==null){
            countArray[val]=new ArrayList<>();
           }
           countArray[val].add(key);
        }
         int[] res = new int[k];
         int index=0;
         for(int i=countArray.length-1;i>0 && index<k;i--){
            List<Integer> numbers=countArray[i];
            if (numbers == null) continue;
            for(int n: numbers){
                res[index++]=n;
                if(index==k)return res;
            }
            
         }
        return res;
    }
    public int[] minHeapApproach(int[] nums, int k){
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
