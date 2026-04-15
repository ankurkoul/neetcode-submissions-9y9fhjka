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
    int maxSumPath=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSumPath;
    }
    private int dfs(TreeNode root){
        if(root==null)return 0;
        int leftPathSum=Math.max(0, dfs(root.left));
        int rightPathSum=Math.max(0, dfs(root.right));
        maxSumPath=Math.max(maxSumPath, root.val+ leftPathSum  + rightPathSum);
        return  root.val+ Math.max(leftPathSum  ,rightPathSum);
    }
}
