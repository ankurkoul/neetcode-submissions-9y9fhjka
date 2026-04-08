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
    public TreeNode invertTreeRecursion(TreeNode root) {
        //Qs?
        /*
        1. tree can be empty?
        2. max no of nodes ? can recursion is option or iterative way
        3. inplace or new node?
        4. How should we handle left- or right-skewed trees?
        */
        if(root==null)return null;
        TreeNode temp= root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }

     public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        Deque<TreeNode> stack=new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top=stack.pop();
            TreeNode temp=top.left;
            top.left=top.right;
            top.right=temp;

            if(top.left!=null)
                 stack.push(top.left);
            
            if(top.right!=null)
            stack.push(top.right);

            
        }
        return root;

     }
}
