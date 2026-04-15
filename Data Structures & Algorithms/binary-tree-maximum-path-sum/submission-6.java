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
        /**
        So for every node:

        We recursively visit left child
        We recursively visit right child
        We do constant work:
        2 Math.max
        1 addition
        1 global update
        Recurrence relation
        T(n)=T(left)+T(right)+O(1)
        
        left+right=n-1 
        
        Each node:
            Is visited exactly once
            dfs() is called exactly once per node
            Does constant work

            So total work:  n×O(1)=O(n)
        */
    }
}
