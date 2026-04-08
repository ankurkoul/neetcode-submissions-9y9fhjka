class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //a
        //e
         // Step 1: Count frequencies using a HashMap
        Map<Integer,Integer> map=new HashMap<>();
        for(int n: nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        // Step 2: Create buckets where index represents frequency
        // arraylist bcz two elements can have same freq
        // List<>[] r=new List[size]
        List<Integer>[] buckets=new List[nums.length+1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Place elements into their corresponding buckets
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int num = e.getKey();
            int freq = e.getValue();
            buckets[freq].add(num);
        }
        //Step 4: Collect the top k frequent elements
         int[] res = new int[k];
         int idx=0;
         for (int i = buckets.length - 1; 
                  i >= 0 && idx < k;
                 i--) {
            List<Integer> list=buckets[i];
            for (int n : list) {
                res[idx++] = n;

                if (idx == k) {
                    return res;
                }
            }
             if(idx==k)
             return res;       
        }
        return res;
        //t: 
        //Building the Frequency Map: N
        //Filling Buckets: run N+1
        //Place elements into their corresponding buckets: N
        //Collecting the Top k Elements: n+1 to 0 : N
        //N

        //s
        //O(N)
    }
}
