class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap=new HashMap<>();
        for(int n: nums){
            countMap.put(n, countMap.getOrDefault(n,0)+1);
        }
        //Arrays Are Real, Generics Are Fake"
        //Left is complier (fake allowed)
        // right is jvm(need real)
        List<Integer>[] bucket=new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> e: countMap.entrySet()){
            int num=e.getKey();
            int fre=e.getValue();
            if(bucket[fre]==null)bucket[fre]=new ArrayList<>();
            bucket[fre].add(num);
        }

         int[] res=new int[k];
         int r=bucket.length-1;
         while(k>0 && r>=0){
            List<Integer> sub=bucket[r--];
            if(sub==null)continue;
            for(int s: sub){
                res[--k]=s;
            }
         }

         return res;

    }
}
