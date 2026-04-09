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
        res= res && diff<=1;//since if res become false in child nodes then stop
        return 1+Math.max(l,r);
    }
    /*
            1
           / \
          2   3
         /
        4
       /
      5
    At node 5 -> l=0, r=0, diff=0, res=true
    At node 4 -> l=1, r=0, diff=1, res=true
    At node 3 -> l=2, r=0, diff=2, res=false


    */
}
