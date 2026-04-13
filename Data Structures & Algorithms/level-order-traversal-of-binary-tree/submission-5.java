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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            while(size-->0){
                TreeNode top=q.poll();
                level.add(top.val);
                if(top.left!=null)
                q.offer(top.left);
                if(top.right!=null)
                q.offer(top.right);
            }
            res.add(level);
        }
        return res;

       /**
       Time complexity:
        Each node is:
        Added to queue once
        Removed from queue once
        Processed exactly once

        If tree has n nodes, total operations are proportional to n.

        ✅ Time Complexity = O(n)

------------------------------------------------------
        Space Complexity

        Space comes from:
            Queue
            Result list
        Queue stores nodes level by level.
        Worst case size of queue = maximum number of nodes at any level
        Perfect Binary Tree (Worst Case) Max queue size = n/2
        ✅ Worst-case Queue Space = O(n)
       
       */
    }
}
