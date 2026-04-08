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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root==null)return 0;
        //postorder
        // ignore negative value
        int l_subtree_pathSum   = Math.max(0,dfs(root.left));
        int r_subtree_pathSum  = Math.max(0,dfs(root.right));
        int currentPathSum= root.val+ l_subtree_pathSum + r_subtree_pathSum;
        max=Math.max(max,currentPathSum);
        //return tree val
        return root.val + Math.max(l_subtree_pathSum, r_subtree_pathSum);
    }
}
