/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
     //  return  dfs(root, root.val);
     return bfs(root);
    }

    private int bfs(TreeNode root){
        if(root==null)return 0;
        int countGoodNodes=0;
        Queue<Pair<TreeNode,Integer>> q=new ArrayDeque<>(); // [root, maxValSofar]
        q.offer(new Pair(root,root.val));
        while(!q.isEmpty()){
            Pair<TreeNode,Integer> top=q.poll(); //polled from front of q;
            TreeNode node=top.getKey();
            int maxVal=top.getValue();
            boolean isNodeGoodNode=node.val>=maxVal;
            if(isNodeGoodNode){
                countGoodNodes++;
                maxVal=node.val;
            }
            if(node.left!=null) q.offer(new Pair<>(node.left, maxVal));
            if(node.right!=null) q.offer(new Pair<>(node.right, maxVal));
        }
        return countGoodNodes;
    }
    
    private int dfs(TreeNode root, int maxVal){
        if(root==null)return 0;
        boolean isRootGoodNode= root.val>=maxVal;
        int countGoodNodes=0;
        if(isRootGoodNode){
            countGoodNodes++; //found root as good node
            maxVal=root.val;
        }
        int leftSubTreeGoodNodes =  dfs(root.left, maxVal);
        int rightSubTreeGoodNodes =  dfs(root.right, maxVal);
         countGoodNodes += leftSubTreeGoodNodes;
         countGoodNodes += rightSubTreeGoodNodes;
         return countGoodNodes;
    }
}
