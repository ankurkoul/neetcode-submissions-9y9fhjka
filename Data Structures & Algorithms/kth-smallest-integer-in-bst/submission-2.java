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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        int count = 0;

        while (cur != null) {
            if (cur.left == null) {
                // Process node
                count++;
                if (count == k) return cur.val;
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                // Find the rightmost node in left subtree
                while (pre.right != null && pre.right != cur) {  
                    pre = pre.right;
                }

                if (pre.right == null) {  // Create a thread
                    pre.right = cur;
                    cur = cur.left;
                } else {  // Remove thread and process node
                    pre.right = null;
                    count++;
                    if (count == k) return cur.val;
                    cur = cur.right;
                }
            }
        }
        return -1;  // If k is out of range
    }
}

