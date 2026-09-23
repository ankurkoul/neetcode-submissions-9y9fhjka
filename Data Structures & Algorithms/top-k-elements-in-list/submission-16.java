class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       //create freq map
       Map<Integer, Integer> count = new HashMap<>();
       for(int num: nums){ //n
         count.put(num, count.getOrDefault(num,0)+1); 
       }
       
      
      // return heapWay(nums,k, count);
      return bucketsort(nums,k, count);
    }
       
    private int[] bucketsort( int[] nums, int k, Map<Integer, Integer> count){
        // each element can appear 1 times to length of array
        // hence we can use that as index  like 
        /*  1. all nums at 1 index appear 1 time ,
            2. all nums at 2 index appear 2 times
            we will create [] with nums+1 hence last index reperesent num which repeated in whole array
            X[] -> where X is List<Integer> 
        */
         List<Integer>[] freqArr=new List[nums.length+1];
         for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                int idx= entry.getValue();
                int num=entry.getKey();

                if(freqArr[idx]==null) freqArr[idx]=new ArrayList<>();
                freqArr[idx].add(num);
         } 

         int[]res=new int[k];
         int resIdx=0;
         for(int i= freqArr.length-1 ; i>0 && resIdx <k ;i--){
            List<Integer> list= freqArr[i];
            if(list ==null) continue;
            for(int num: list){
                res[resIdx++] = num;
            }
         }

         return res;
       }

       private int[] heapWay(int[] nums, int k, Map<Integer, Integer> count){
       // we need k most freq hence min heap (with only k largest freq atanytime )
        Queue<int[]>minHeap=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            minHeap.offer(new int[]{ entry.getKey(), entry.getValue()}); //logK
            if(minHeap.size()>k)
                minHeap.poll(); //logK
        }
        //hence uniqueKey * log k , worst case all n are unique key hence NlogK

        int[] res=new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            res[i++]=minHeap.poll()[0];
        }

        return res;
    }
}
