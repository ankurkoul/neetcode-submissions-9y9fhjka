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
    public TreeNode invertTree(TreeNode root) {

        /*
        1
       / \
      2   3
     / \   \
    4   5   6
        
        */
        if(root==null)return root; //root=1                  //root=3         //root=6         //root=null -> go back
        TreeNode left=root.left;   //2                        // null        //null
        root.left=invertTree(root.right); // left=call(3)    //left=call(6)  left=call(null)                           //left=null            //left=6             //left=3
        root.right=invertTree(left);                                                                                   //right=call(null)    //right=call(null)     right=call(2)
        return root;                                                                                                   //6                   //3

    }
}
