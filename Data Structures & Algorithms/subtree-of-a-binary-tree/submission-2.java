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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfsRec(root, subRoot);
    }

     private boolean dfsRec(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null)return false;
        if(subRoot==null) return true;

         //check same root with root
         if(sameTree(root,subRoot))return true;
         //check for left and right subtree
         return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot){
       if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null)return false;
        if(root.val !=subRoot.val)return false;
        //check for childern
        boolean left=sameTree(root.left,subRoot.left);
        boolean right=sameTree(root.right,subRoot.right);
        return left && right;

    }
}
