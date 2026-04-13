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
        return dfs(root,root.val);
    }

    private int dfs(TreeNode node, int maxSoFar){
        if(node==null)return 0;
        boolean isGood= node.val>= maxSoFar;
        int totalGoodNodes= isGood? 1: 0; //
        maxSoFar=Math.max(maxSoFar, node.val);
        totalGoodNodes+=dfs(node.left, maxSoFar);
        totalGoodNodes+=dfs(node.right, maxSoFar);
        return totalGoodNodes;
    }
}
