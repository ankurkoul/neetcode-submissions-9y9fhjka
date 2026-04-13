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

    private boolean dfs(TreeNode node, int left, int right){
        if(node==null)return true;
        boolean isValid =false;
        if(left< node.val && node.val <right){
            isValid =true;
        }
        boolean isLeftSubTreeValid= dfs(node.left, left, node.val);
        boolean isRightSubTreeValid= dfs(node.right, node.val, right);
        return isValid && isLeftSubTreeValid && isRightSubTreeValid;

    }
}
