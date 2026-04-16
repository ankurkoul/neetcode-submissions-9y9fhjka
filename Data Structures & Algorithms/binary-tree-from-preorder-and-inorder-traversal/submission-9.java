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
    int preIdx=0, inIdx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit){
        if(preIdx==preorder.length)return null;
        //When inorder hits current root. we reach boundary
        if(inorder[inIdx]== limit){
            //left tree is processed and we are on root, shift inorder to focus on right
            inIdx++;
            // we have build complete left tree hence return null
            // Returning null tells parent no child further
            return null;
        }
        int rootVal=preorder[preIdx++];
        TreeNode root=new TreeNode(rootVal);
        // Left subtree ends exactly when we reach the root value.
        root.left=dfs(preorder,inorder, rootVal);
        //why not pass infinity for all right node?
        /*
        Because not every right subtree belongs to the whole tree.
        Some right subtrees belong inside a smaller boundary created by an ancestor.

        We do NOT pass ∞ for every right subtree because
        each subtree must inherit the boundary set by its parent.

        If we always pass ∞,
        we remove ancestor constraints and risk consuming nodes outside the subtree’s valid inorder range.
       

         20
         /
       10
         \
          15

        Fence ∞
        └── Fence 20
                └── (10's right subtree still under fence 20)
        */
        root.right=dfs(preorder,inorder, limit);
        return root;
    }
}
