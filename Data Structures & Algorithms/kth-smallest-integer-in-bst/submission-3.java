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
    public int kthSmallest(TreeNode root, int k) {
        //use morris algo -> 2 step algo
        /*
        BST inoreder : left subtree -> root -> right subtree
        1. find rightmost in left subtree
        2. link it with root
        3. now traverse left subtree if reach back then official left subtree is explored then update count as evaluate root
        */
        TreeNode cur=root;
        int count=0; //update count only when we process root
        while(cur !=null){
            TreeNode pre=cur.left;
            //explore left subtree
            if(pre ==null){
                //if no left tree , means we have processed left tree hence evalute root
                count++;
                if(count==k)return cur.val;
                cur=cur.right;// explore right subtree
            }else{
                while(pre.right!=null && pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    //reach rightmost node
                    // hence link to parent and now ask cur to travese
                    pre.right=cur;
                    //cur travese left subtree
                    cur=cur.left;
                }else{
                    //rightmost node connected to parent hence reached root
                    pre.right=null;
                     count++;
                    if(count==k)return cur.val;
                    cur=cur.right;// explore right subtree
                }
            }
        }
        return -1;
    }
}
