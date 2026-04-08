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
       return  dfs(root, root.val);
    }
    
    private int dfs(TreeNode root, int maxVal){
        if(root==null)return 0;
        boolean isRootGoodNode= root.val>=maxVal;
        int countGoodNodes=0;
        if(isRootGoodNode){
            countGoodNodes++;
            maxVal=root.val;
        }
        int leftSubTreeGoodNodes =  dfs(root.left, maxVal);
        int rightSubTreeGoodNodes =  dfs(root.right, maxVal);
        return countGoodNodes + leftSubTreeGoodNodes + rightSubTreeGoodNodes;
    }
}
