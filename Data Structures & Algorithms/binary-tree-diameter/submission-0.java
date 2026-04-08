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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        //Q
        /** 
            input: tree can be empty , number of nodes
            output: what is diamter? it is number of edges in path from node
            // Diamter of node = left edge path + right edge path
            left edge path = height of left tree
            right edge path = height of right tree
            // it not always pass from root?
        */
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root ==null)return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        int d= l+r;
        max=Math.max(max,d);
        return 1+ Math.max(l,r);
    }
}
