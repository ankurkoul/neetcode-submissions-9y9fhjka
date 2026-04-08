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
    public int maxDepthRec(TreeNode root) {
        //Q: 
        /**
        Input:
            // tree can be null?
            // max nodes in tree
        Output:
         single node: depth will be 1?
          DFS: O(H) vs BFS: O(N)
        */
        if(root==null)return 0;
        int lh= maxDepth(root.left);
        int rh= maxDepth(root.right);
        return 1+Math.max(lh,rh);
    }

    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        Stack<Pair<TreeNode,Integer>> stack=new Stack<>();
        stack.push(new Pair<>(root,1));
        int res=0;
        while(!stack.isEmpty()){
            Pair<TreeNode,Integer> top=stack.pop();
            TreeNode node= top.getKey();
            int depth = top.getValue();
            if(node !=null){
                res=Math.max(res,depth);
                stack.push(new Pair<>(node.left,depth+1));
                stack.push(new Pair<>(node.right,depth+1));
            }
        }

        return res;
    }
}
