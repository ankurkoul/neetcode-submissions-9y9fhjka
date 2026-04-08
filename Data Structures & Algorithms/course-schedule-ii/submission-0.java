class Solution {
    public int[] findOrder(int n, int[][] pre) {
        //DIP_BR
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer>q=new ArrayDeque<>();
        int[]indegree=new int[n];
        int[]res=new int[n];
        for(int[]p:pre){
            int a=p[0],b=p[1];
            // b is parent, a is child
            map.computeIfAbsent(b, x->new ArrayList<>()).add(a);
            indegree[a]++;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        //bfs
        int i=0;
        int visited=0;
        while(!q.isEmpty()){
            int top=q.poll();
            visited++;
            res[i++]=top;
            for(int c: map.getOrDefault(top,Collections.emptyList())){
                //reduce parent 
                indegree[c]--;
                 if(indegree[c]==0){
                     q.offer(c);
                }
            }
        }

        return visited ==n?res: new int[]{};
    }
}
