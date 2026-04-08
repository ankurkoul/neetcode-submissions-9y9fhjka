class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //topological sort
        /*
        pre =[a,b] where a->b 
        1. prepare map : parent-> [children] eg b:a
        2. child matric: indegree[a]++ ; // as it depends on a
        3. load super parent: indegree==0
        4. bfs on super parent
        5. fetch there dependents
        6. reduce dependents indegree
        7. if indegree == 0 load it
        */
        // Topological Sort
        Map<Integer, List<Integer>> pcmap = new HashMap<>();
        int[] indegree = new int[numCourses];

        // Step 1 & 2: Build the adjacency list and indegree array
        for (int[] pre : prerequisites) {
            int a = pre[0], b = pre[1]; // a depends on b
            pcmap.computeIfAbsent(b, x -> new ArrayList<>()).add(a);
            indegree[a]++;
        }

        // Step 3: Load nodes with indegree == 0 (super parents)
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int visited = 0;
        // Step 4-7: BFS processing
        while (!q.isEmpty()) {
            int superParent = q.poll();
            visited++;

            for (int ne : pcmap.getOrDefault(superParent, Collections.emptyList())) {
                indegree[ne]--;
                if (indegree[ne] == 0) {
                    q.offer(ne);
                }
            }
        }

        return visited == numCourses; // If all courses are visited, return true
    }
}
