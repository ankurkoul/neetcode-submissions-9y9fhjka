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
     //   return dfsRec(p,   q);
            return dfsItr(p,q);
    }

     public boolean dfsItr(TreeNode p, TreeNode q) {
        Stack<TreeNode[]>stack=new Stack<>();
        stack.push(new TreeNode[]{p,q});
        while(!stack.isEmpty()){
            TreeNode[] res= stack.pop();
            TreeNode p1=res[0], q1=res[1];
            if(p1 ==null && q1==null) continue; //here we dont return rather continue
            if(p1 ==null || q1 ==null)return false;
             if(p1!=null && q1!=null && p1.val != q1.val)return false;
            //push child nodes
            stack.push(new TreeNode[]{p1.left,q1.left});
            stack.push(new TreeNode[]{p1.right,q1.right});
        }
        return true;
     }
    public boolean dfsRec(TreeNode p, TreeNode q) {
        if(p ==null && q==null)return true;
        if(p ==null || q==null)return false;
        //preDFS
        if(p.val != q.val) return false;

        boolean left=dfsRec(p.left,q.left);
        boolean right=dfsRec(p.right,q.right);
        return left && right;
    }
}
