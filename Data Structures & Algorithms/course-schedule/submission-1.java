class Solution {
    public boolean canFinish(int n, int[][] preq) {
        //  DIPBR
        //  dependency graph: 
        //  indegree
        //  process zero degree
        //  bfs
        //  remove dependency
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[]indegree=new int[n];
        Queue<Integer> q=new ArrayDeque<>();
        //prepare dependecy
        for(int[] p: preq){
            int a=p[0], b=p[1];
            // a->b
            map.computeIfAbsent(b, x -> new ArrayList<>()).add(a);
            //update indegree graph
            indegree[a]++; // no of parent
        }

        for(int i=0;i<n;i++){
            //process zero degree
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int visitedRoot=0;
        while(!q.isEmpty()){
            int top=q.poll();
            visitedRoot++;
            //for (int ne : map.getOrDefault(top, Collections.emptyList())) {
            for(int ne : map.getOrDefault(top, Collections.emptyList())) {
                //reduce indegree as root is process
                indegree[ne]--;
                if(indegree[ne]==0)
                    q.offer(ne);
            }
        }

        return visitedRoot==n;

    }
}
