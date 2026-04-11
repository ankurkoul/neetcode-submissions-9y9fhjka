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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return root;
        if(root.val< p.val && root.val< q.val)return dfs(root.right,p,q);
        if(root.val>p.val && root.val> q.val)return dfs(root.left,p,q);
        // as in binary search only root is where  all left <= root >=right
        return root;
    }

}
