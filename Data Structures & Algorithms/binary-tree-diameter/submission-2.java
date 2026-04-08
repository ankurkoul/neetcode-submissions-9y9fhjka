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
        helper(root); 
        // Not max = Math.max(max, helper(root)) as l+r;
        return max;
    }
    private int helper(TreeNode root){
        if(root ==null)return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        int d= l+r;
        max=Math.max(max,d);
        return 1+ Math.max(l,r);
        // t: O(N)
        //s: O(H) where h is log N in balanced  and N in case of skewed tree
    }
}
