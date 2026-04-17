class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap=new PriorityQueue<>((a,b) ->b[2]-a[2]);
        for(int[] p: points){
            int d= p[0]*p[0];
            d+=(p[1]*p[1]);
            maxHeap.offer(new int[]{p[0],p[1] ,d});
            //check size
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] res=new int[k][2]; // k rows with x,y cord
        while(!maxHeap.isEmpty()){
            int[]p=maxHeap.poll();
            res[--k][0]=p[0];
            res[k][1]=p[1];
        }
        return res;
    }
}
