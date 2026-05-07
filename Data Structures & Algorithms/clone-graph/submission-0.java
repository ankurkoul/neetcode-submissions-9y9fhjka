/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> oldToNewMap=new HashMap<>();

    public Node cloneGraph(Node node) {
        
        return dfs(node);
    }


    private Node dfs(Node node){
        if(node==null)return null;
        //if already process retun that
        if(oldToNewMap.containsKey(node))return oldToNewMap.get(node);
        //process node
        Node clone=new Node(node.val);
        oldToNewMap.put(node,clone);

        //spread
        for(Node nei : node.neighbors){
            Node cloneNei=dfs(nei);
            clone.neighbors.add(cloneNei);
        }

        return clone;

    }
}