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
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //ICORE
        /*
        in preorder -> first node is root 
        we find postiion of root in inorder -> say mid
        now recursively build left substree based on 
            preorder : [1 to n]
            inorder :[0 to mid-1]
        now recursively build right subtree based on:
                inorder :[mid+1]
                prorder
        then return root
        */
        //basedcondition 
        if(preorder==null || inorder==null)return null;
        if(preorder.length != inorder.length)return null;
        int n= inorder.length;
        // Build value -> index map for inorder
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
       return dfs(preorder, 0, n-1);
    }

    private TreeNode dfs(int[] preorder, int inLeft, int inRight) {
        // No elements in this subtree
        if (inLeft > inRight) return null;
        // Pick current root from preorder
        int rootVal=preorder[preorderIndex++];
        TreeNode root=new TreeNode(rootVal);
        // get inorder id of root say mid
         int mid = inorderIndexMap.get(rootVal);
         // Recursively build left and right subtree
        root.left =dfs(preorder,inLeft, mid-1);
        root.right =dfs(preorder,mid+1, inRight);
       return root;
    }
}
