class Solution {
    class DSU{
        int[]parent,rank;

        DSU(int size){
            parent=new int[size];
            rank=new int[size];
            for(int i=0;i<size;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }
        int find(int x){
            int parentx=parent[x];
            while(parentx!=parent[parentx]){
                parentx=parent[parentx];
            }
            return parentx;
        }

        boolean merge(int a, int b){
            int parenta=find(a);
            int parentb=find(b);
            //    if a == b, there is a cycle(connected), 
            //    if a != b, no cycle(not connected).
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
    public int[] findRedundantConnection(int[][] edges) {
        //to allow n+1 length and avoid zero based
        DSU dsu=new DSU(edges.length+1);
         for(int[]ed:edges){
            boolean isredundant= dsu.merge(ed[0],ed[1]);
            if(!isredundant){
                return ed;
            }
         }
         return new int[]{};
    }
}
