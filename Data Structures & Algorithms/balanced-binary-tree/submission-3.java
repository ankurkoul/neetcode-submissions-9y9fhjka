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
    boolean isBalancedFlag=true;
    public boolean isBalanced(TreeNode root) {
        /*
         input : no of nodes
        */
        helper(root);
       return isBalancedFlag;
    }
    private int helper(TreeNode root){
        if(root==null)return 0;
        if(!isBalancedFlag) return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        int diff=Math.abs(lh-rh);
        // once unbalanced it can be balanced hence check for condiiton
        isBalancedFlag= isBalancedFlag && diff<=1;
        return 1+Math.max(lh,rh);
    }
}
