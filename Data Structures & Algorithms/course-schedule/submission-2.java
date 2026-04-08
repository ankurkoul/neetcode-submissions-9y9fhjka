class Solution {
    public boolean canFinish(int n, int[][] pre) {
        //DIP_BR
        // prepare dependency matrxix
        // update in degree matrix
        // process super node

        // run bfs
        // reduce count
        Map<Integer,List<Integer>> map=new HashMap<>();
        int[]indegree=new int[n];
        Queue<Integer> q=new ArrayDeque<>();
        for(int[] p: pre){ //O(E)
            int a=p[0],b=p[1];
            //a ->b
            map.computeIfAbsent(b,x->new ArrayList<>()).add(a); //d
            indegree[a]++;  //i
        }

        for(int i=0;i<n;i++){//o(n)
            if(indegree[i]==0)
            q.offer(i);
        }

        int visited=0;
        while(!q.isEmpty()){ //o(n)
            int top=q.poll();
            visited++;
            for(int ch: map.getOrDefault(top, new ArrayList<>())){
                //reduce indegree
                indegree[ch]--;
                 if(indegree[ch]==0)
                  q.offer(ch);
            }
            
        }

        return visited==n;

    }
}
