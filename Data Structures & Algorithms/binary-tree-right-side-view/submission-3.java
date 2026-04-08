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
    public List<Integer> rightSideView(TreeNode root) {
     // dfs(root,0);
     bfs(root);
      return res;  
    }
    private void dfs(TreeNode root, int level){
        if(root==null)return;
        if(res.size()==level){
            res.add(root.val);
        }
        // here first node at each level should be right node hence
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
    private void bfs(TreeNode root){
        if(root==null)return ;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            //level by level
            int size=q.size(); 
            for(int i=0;i<size;i++){
                TreeNode top=q.poll(); //poll from front
                if(i==size-1){
                    res.add(top.val);
                }
                if(top.left!=null) q.offer(top.left);
                if(top.right!=null) q.offer(top.right);
            }
        }
    }
}
