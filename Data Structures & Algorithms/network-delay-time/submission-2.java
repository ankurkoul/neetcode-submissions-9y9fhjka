class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
    //n nodes: 1 to n : what max value of n can be?
    // times list: directed edges [u,v,t] -> src, tar, time from s to t : what max value of time can be?
    // k : starting node : is it gurantee node is present
    // min time it takes for node to receive signal
    // else -1
    //Can there be multiple edges between the same pair of nodes?
    // Are there negative edge weights like t<0?
    // If yes, Dijkstra’s algorithm won’t work, and we’ll need Bellman-Ford.
    //squid
    // setup of adj and queue
     Map<Integer,List<int[]>> adj=new HashMap<>();
     for(int [] t: times){
        adj.computeIfAbsent(t[0],x->new ArrayList<>()).add(new int[]{ t[1],t[2]});
     }
    //Queue
    Queue<int[]>q=new PriorityQueue<>((a,b)->a[1]-b[1]);
    q.offer(new int[]{k,0});

    //Set
    Set<Integer> set=new HashSet<>();
    int res=0;
    while(!q.isEmpty()){
        int[] top=q.poll();
        int node=top[0], ttr= top[1];
        if(set.contains(node))continue;
        set.add(node);
        res=ttr;
        //load neighbours into queue
        for(int[]ne: adj.getOrDefault(node, Collections.emptyList())){
            q.offer(new int[]{ne[0], ne[1]+ttr});
        }

    }
    // if visited all nodes then res will store min time else -1
    return set.size()==n ?res:-1;
    }
}
