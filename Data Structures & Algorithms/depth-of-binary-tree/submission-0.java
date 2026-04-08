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
    public int maxDepth(TreeNode root) {
        //Q: 
        /**
        Input:
            // tree can be null?
            // max nodes in tree
        Output:
         single node: depth will be 1?
          DFS: O(H) vs BFS: O(N)
        */
        if(root==null)return 0;
        int lh= maxDepth(root.left);
        int rh= maxDepth(root.right);
        return 1+Math.max(lh,rh);
    }
}
