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
    List<Integer> res=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        //Q
        /*
        I: root can be null then return?
            max no of nodes
            max value of k
            if k is not present then?
            tree is binary or bst?
        */
        //approach  inorder traversal
        dfs(root);
        return res.get(k-1);
    }

    private void dfs(TreeNode root){
        if(root==null)return ;
        //inoreder treavese -> left, node, right
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}
