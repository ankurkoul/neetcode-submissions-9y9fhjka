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
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, int left, int right){
        if(root==null)return true;
        boolean isValid=false;
        if(left<root.val && root.val<right){
            isValid=true;
        }
        boolean leftIsValid=dfs(root.left,left,root.val);
        boolean rightIsValid=dfs(root.right,root.val,right);
        return isValid && leftIsValid && rightIsValid;
    }
}
