class Solution {
    class DSU{
        int[] parent,rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];

            for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }
        int find(int x){
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b){
            int parenta=find(a);
            int parentb=find(b);
            if(parenta==parentb)return false;
            if(rank[parenta]>rank[parentb]){
                rank[parenta]+=rank[parentb];
                parent[parentb]=parenta;
            }else{
                rank[parentb]+=rank[parenta];
                parent[parenta]=parentb;
            }
            return true;
        }
    }
    public int countComponents(int n, int[][] edges) {
        int res=n; // each node is its own comp
        DSU dsu=new DSU(n);
        for(int[]e: edges){
           boolean isConnected= dsu.union(e[0],e[1]);
           //since isConnected hence we reduce compons
           if(isConnected){
            res--;
           }
        }
        return res;
    }
}
