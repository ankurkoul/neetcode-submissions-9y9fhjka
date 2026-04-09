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
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
      if(root==null)return true;
       helper(root);
        return res;
    }

    private int helper(TreeNode root){
        if(root==null)return 0;
        if(!res)return 0;
        int l= helper(root.left);
        int r=helper(root.right);
        int diff=Math.abs(l-r);
        res= res && diff<=1;
        return 1+Math.max(l,r);
    }
}
