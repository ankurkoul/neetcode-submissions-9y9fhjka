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
       //  dfs(root);
        //return res.get(k-1);
        return morrisTraversal(root,k);
    }

    private void dfs(TreeNode root){
        if(root==null)return ;
        //inoreder treavese -> left, node, right
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }

    private int morrisTraversal(TreeNode root, int k) {
        /*
        Morris Traversal:
        is a way to perform inorder traversal of a binary tree 
        using O(1) space.
        It avoids using a stack or recursion 
        by temporarily modifying the tree structure using Threads
        (leverages the concept of Threaded Binary Trees)
        Threads are temporary links
             made to inorder predecessors to remember the path back to the root.
        After visiting,
             these links are removed to restore the original tree structure.
        */
         TreeNode cur = root;
         int count = 0; // To keep track of the number of nodes visited
          while (cur != null) {
            // Case 1: No left child
            if (cur.left == null) {
                //  vist node , 
                //  if count ==k then return node
                //  move to right for next
                count++;
                if(count==k)return cur.val;
                cur=cur.right;
            }else{
                //current has a left child
                //Find the rightmost node in left subtree
                TreeNode pred=cur.left;
                // loop will break
                // pred.right ==null or pred.right=current
                // If pred.right is null:
                    // Create a thread from pred.right to current.
                    // Move to the left child
                // if pred.right is current
                    //  Break the thread
                    //  Visit the current node.
                    //  If the counter equals k, return this node's value.
                    //  Move to the right child.
                while(pred.right!=null && pred.right!=cur){
                    pred = pred.right;
                }
                //loop end
                // check condition
                if(pred.right==null){
                    //create thread
                    pred.right = cur;
                    //move to left of curr
                    cur=cur.left;
                }else{
                    //break thread
                     pred.right = null;
                    //vist node
                    count++;
                    if(count==k)return cur.val;
                    cur=cur.right;
                }
            }
          }
         return -1; // This should never be reached if k is valid
    }
}
