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
    boolean isBalancedFlag=true;
    public boolean isBalanced(TreeNode root) {
        /*
         input : no of nodes
        */
       // helper(root);
       //return isBalancedFlag;
        return iterativePostDFS(root);
    }
    private boolean iterativePostDFS(TreeNode root){
        if(root==null)return true;
        // need stack : to process in post order dfs
        // need map to store height of each node
        Stack<TreeNode> stack=new Stack<>();
        Map<TreeNode,Integer> map=new HashMap<>();

        stack.push(root);
        map.put(null,0);

        while(!stack.isEmpty()){
            //peek since post order traverse hence peek before pop
            TreeNode node=stack.peek();
            // process child nodes if not processed
            if(node.left!=null && !map.containsKey(node.left)){
                stack.push(node.left);
            }else if(node.right!=null && !map.containsKey(node.right)){
                stack.push(node.right);
            }else{
                //processed child nodes
                node=stack.pop();
                int lh= map.get(node.left);
                int rh= map.get(node.right);
                int diff=Math.abs(lh-rh);
                if(diff>1)return false;
                map.put(node,1+Math.max(lh,rh));
            }
        }
        return true;
    }
    private int helper(TreeNode root){
        if(root==null)return 0;
        if(!isBalancedFlag) return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        int diff=Math.abs(lh-rh);
        // once unbalanced it can be balanced hence check for condition only if it is previously balanced
        isBalancedFlag= isBalancedFlag && diff<=1;
        return 1+Math.max(lh,rh); // Post order DFS since we are computing child trees before parent
    }
}
