class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //icore
        // nums-> empty/null, k-> -ve or k> nums , nums[i]-> -ve?
        // nums -> 2x10^9 billion and nums[i]
        // out -> return top k in what as array
        // rules -> assumption
        // e->

        if(nums==null || nums.length==0 || k<=0 || k> nums.length)return new int[]{};
        Map<Integer,Integer> countMap=new HashMap<>();
        for(int n: nums){
            countMap.put(n, countMap.getOrDefault(n,0)+1);
        }
        //bucket sort
        // [][] -> here each index will have list not integer
        // why n+1 -> [1,1,1] her count is 3 but having arr[0..2] if n hence n+1
        List<Integer>[] bucketArr=new ArrayList[nums.length+1];
        for(Map.Entry<Integer,Integer> e : countMap.entrySet()){
           int count= e.getValue();
           int key= e.getKey();
           if(bucketArr[count]==null)bucketArr[count]=new ArrayList<>();
           bucketArr[count].add(key);
        }
        int[] res=new int[k];
        int i=bucketArr.length-1;
        int r=0;
        while(i>0 && r<k){
            List<Integer> bucket=bucketArr[i--];
            if(bucket==null)continue;
            for(int b: bucket){
                if(r==k) break;
                res[r++]=b;
            }
        }
        return res;
        
    }
}