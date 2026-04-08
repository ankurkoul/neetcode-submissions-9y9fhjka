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
    public TreeNode invertTree(TreeNode root) {
        //Qs?
        /*
        1. tree can be empty?
        2. max no of nodes ? can recursion is option or iterative way
        3. inplace or new node?
        4. How should we handle left- or right-skewed trees?
        */
        if(root==null)return null;
        TreeNode temp= root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }
}
