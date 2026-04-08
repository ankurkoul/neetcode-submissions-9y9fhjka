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
      // Step 1: Build adjacency list (O(E))
     Map<Integer,List<int[]>> adj=new HashMap<>();
     for(int [] t: times){ //iterate over edges  hence O(E)
        adj.computeIfAbsent(t[0],x->new ArrayList<>()).add(new int[]{ t[1],t[2]});
     }
    //Queue
    //Step 2: Priority Queue (Min-Heap) to always expand the shortest path first (O(V))
    Queue<int[]>q=new PriorityQueue<>((a,b)->a[1]-b[1]);
    q.offer(new int[]{k,0}); //O(1)

    //Set
    // Step 3: Visited Set to avoid re-processing nodes (O(V))
    Set<Integer> set=new HashSet<>();
    int res=0;
     // Step 4: Dijkstra’s Algorithm
    while(!q.isEmpty()){
        // Extracting node with smallest time -> O(V log V)
        int[] top=q.poll(); // o(logV)  // Min-heap extract (O(log V)), runs at most V times → O(V log V)
        int node=top[0], ttr= top[1];
        if(set.contains(node))continue; // O(1)
        set.add(node); //O(1)
        res=ttr;
         // Step 5: Process all outgoing edges (O(E log V))
        //load neighbours into queue
        // worst case: one node can have edge to all node thats d =E
        // hence loop runs for O(E)
        //ElogV
        for(int[]ne: adj.getOrDefault(node, Collections.emptyList())){ //O(E)
            q.offer(new int[]{ne[0], ne[1]+ttr}); //O(logv)
        }

    }
    // if visited all nodes then res will store min time else -1
    return set.size()==n ?res:-1;
    }
    /**
    time complex:
    1. int[] top=q.poll() -> VlogV
    2. for(int[]ne: adj.getOrDefault(node, Collections.emptyList())){ //O(E)
            q.offer(new int[]{ne[0], ne[1]+ttr}); //O(logv)
        }
      ElogV
    hence (v+e)logv
    
    space:
    map: O(E)
    q: O(V)
    s: O(V)
    hence O(v+e)
    */
}
