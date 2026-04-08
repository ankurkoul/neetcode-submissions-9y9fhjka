class Solution {
    class DSU{
        int[]parent,rank;

        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // Path compression
            }
            return parent[x];
        }

        boolean union(int a, int b){
            int parenta=find(a);
            int parentb=find(b);
            if(parenta==parentb)return false;
            else if(rank[parenta]>rank[parentb]){
                rank[parenta]+=rank[parentb];
                parent[parentb]=parenta;
            }else{
                rank[parentb]+=rank[parenta];
                parent[parenta]=parentb;
            }
            return true;
        }
    }
     public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;  // A tree must have exactly n-1 edges

        DSU dsu = new DSU(n);  // Fix: Use n instead of n+1
        for (int[] e : edges) {
            if (!dsu.union(e[0], e[1])) return false;  // Cycle detected
        }
        return true;
    }
}
