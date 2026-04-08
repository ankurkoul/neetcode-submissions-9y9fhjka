class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // points:
        // max, min vale
        // k max, min value
        //minheap with distance from k from origin hence
        //since origin is (0,0) hence x^2 +y^2
        Queue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        for(int[] p: points){
            int d= p[0]*p[0];
            d+=(p[1]*p[1]);
            minHeap.offer(new int[]{p[0],p[1],d});
        }
        
        int[][] res=new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] top=minHeap.poll();
            res[i]=new int[]{top[0],top[1]};
        }
        return res;
    }
}
