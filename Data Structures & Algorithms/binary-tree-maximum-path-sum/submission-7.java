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
    int maxSumPath=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxSumPath;
    }
    private int dfs(TreeNode root){
         // If node is null → constant work → O(1)
        if(root==null)return 0;
        // Recursive call on left subtree
        // Cost = T(size of left subtree)
        int leftPathSum=Math.max(0, dfs(root.left));
        // Recursive call on right subtree
        // Cost = T(size of right subtree)
        int rightPathSum=Math.max(0, dfs(root.right));
        /*
         Work done at current node:
         - 2 Math.max() calls  → O(1)
         - 2 additions         → O(1)
         - 1 global max update → O(1)

         Total non-recursive work per node = O(1)
        */
        maxSumPath=Math.max(maxSumPath, root.val+ leftPathSum  + rightPathSum);
         /*
         Return value calculation:
         - 1 addition
         - 1 Math.max
         → O(1)
        */
        return  root.val+ Math.max(leftPathSum  ,rightPathSum);
        /**
        So for every node:

        We recursively visit left child
        We recursively visit right child
        We do constant work:
        2 Math.max
        1 addition
        1 global update
        Recurrence relation
        T(n)=T(left)+T(right)+O(1)
        
        left+right=n-1 
        
        Each node:
            Is visited exactly once
            dfs() is called exactly once per node
            Does constant work

            So total work:  n×O(1)=O(n)
        */
    }
}
