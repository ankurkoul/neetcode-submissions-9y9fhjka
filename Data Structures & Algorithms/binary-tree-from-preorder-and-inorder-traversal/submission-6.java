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
    int preIdx = 0;
    int inIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int rootValAsInorderLimit) {
        if(preIdx >=preorder.length)return null; //process all nodes
        //We have reached the root of this subtree in inorder.
        if(inorder[inIdx]== rootValAsInorderLimit){
            //we have created left subtree and we have reached root
            //inIdx++ -> jump root to right trr
            //return null -> We hit the boundary. So we return null to indicate his subtree does not exist anymore.
            inIdx++;
            return null;
        }
        int rootVal=preorder[preIdx++];
        TreeNode root= new TreeNode(rootVal);
        root.left=dfs(preorder, inorder, root.val);
        root.right=dfs(preorder, inorder, rootValAsInorderLimit);
        return root;
    }
}
