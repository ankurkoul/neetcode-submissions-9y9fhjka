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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        TreeNode cur=root;
        while(cur!=null){
            if(p.val>cur.val && q.val>cur.val) cur=cur.right;
            else if(p.val<cur.val && q.val<cur.val) cur=cur.left;
            else return cur;
        }
        return null;
    }
    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        //i:
        //root, p,q ... number of nodes , can be null?
        // can it be same?
        //At each recursive step, we either move left or move right based on the BST property.
        // hence we remove half hence n -> n/2 -> n/4  hence logN iterations or height of tree
        if(root==null)return null;
        if(root.val<p.val && root.val<q.val)return lowestCommonAncestor(root.right, p,q);
        if(root.val>p.val && root.val>q.val)return lowestCommonAncestor(root.left, p,q);
        return root;
    }
}
