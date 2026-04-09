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

    record MyPair(TreeNode node, int d){};

    public int maxDepth(TreeNode root) {
        return maxDepthInc(root);
    }

    private int maxDepthInc(TreeNode root) {
          if(root==null)return 0;
          Stack<MyPair> stack=new Stack<>();
          stack.push(new MyPair(root,1));
          int res=0;
          while(!stack.isEmpty()){
            MyPair top=stack.pop();
            TreeNode node=top.node();
            if(node !=null){
                int d=top.d();
                res=Math.max(res,d);
                /*
                Why we do h+1? 
                👉 If parent is at depth 1
                👉 Its children must be at depth 2
                */
                stack.push(new MyPair(node.left, d+1)); //child at next depth
                stack.push(new MyPair(node.right, d+1)); // child at next depth
            }

          }
        return res;

    }
     private int maxDepthRec(TreeNode root) {
         if(root==null)return 0;
        int leftChildDepth =maxDepthRec(root.left);
        int rightChildDepth =maxDepthRec(root.right);
        return 1+Math.max(leftChildDepth,rightChildDepth);

        //t-> O(n)
        //s -> o(h)
    }
}
