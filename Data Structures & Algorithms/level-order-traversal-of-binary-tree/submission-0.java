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
        Queue<TreeNode> q=new ArrayDeque<>(); // faster poll/offer + doesnt null 
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            while(size-->0){
                TreeNode top=q.poll();
                //process node
                level.add(top.val);
                // add children
                if(top.left!=null)  q.offer(top.left);
                 if(top.right!=null)  q.offer(top.right);
            }
            res.add(level);
        }
        return res;
    }
    public List<List<Integer>> levelOrderWithLinkedList(TreeNode root) {
        // Q:
        // root can be null, max nodes
        // in case of null return what?
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;
        // if we want to alloe
        Queue<TreeNode> q=new LinkedList<>(); 
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size=q.size();
            while(size-->0){
               TreeNode top=q.poll();
               if(top!=null){
                level.add(top.val);
                //add sub nodes
                q.offer(top.left);
                q.offer(top.right);
               }
            }
            if(!level.isEmpty())
            res.add(level);
        }
        return res;
    }
}
