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
     public boolean isSameTree(TreeNode p, TreeNode q) {
        // we need to handler p,q
        // why not use bfs ? since dfs is less space , and here we are doing preorder much sorted for dfs
        Stack<TreeNode[]> stack=new Stack<>();
        stack.push(new TreeNode[]{p,q});
        while(!stack.isEmpty()){
            //preorder hence pop root
            TreeNode[] node=stack.pop();
            TreeNode p1=node[0],q1=node[1];
            if(p1==null && q1==null)continue;
            if(p1==null || q1==null)return false;
            if(p1!=null && q1!=null && p1.val != q1.val)return false;
            //process child nodes
            stack.push(new TreeNode[]{p1.left,q1.left});
            stack.push(new TreeNode[]{p1.right,q1.right});
        }

        return true;

     }
    public boolean isSameTreeRec(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p!=null && q!=null && p.val!=q.val) return false;
        //check child nodes
        boolean left=isSameTreeRec(p.left , q.left);
        boolean right=isSameTreeRec(p.right , q.right);
        return left && right;
    }
}
