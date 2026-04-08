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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
       // helper(root); 
        // Not max = Math.max(max, helper(root)) as l+r;
       // return max;
       return iterativePostDFS(root);
    }

    private int iterativePostDFS(TreeNode root){
        if(root==null)return 0;
        //Stack
        //map : to store val of diameter and height of node
        Map<TreeNode, int[]> map=new HashMap<>();
        map.put(null, new int[]{0, 0}); // in case of null it will thriugh null pointer exception
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
             TreeNode node = stack.peek(); //why peek not pop?
             /*
                As We need to process a node only after processing its left and right children.
                This is why we peek the node first and push its children if they are not processed yet.
                We only pop when both children have been processed.
                Hence Postorder traversal 
            */
            //process child nodes
             if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            }else{
                //both child nodes are processed hence can process root
                node= stack.pop();
                //get its child data
                int[] leftData= map.get(node.left);
                int[] rightData= map.get(node.right);

                int lh=leftData[0],ld=leftData[1];
                int rh=rightData[0],rd=rightData[1];
                int height=1+ Math.max(lh,rh);
                int diamter=Math.max(lh+rh, Math.max(ld,rd));
                map.put(node, new int[]{height,diamter});
            }
        }

        return map.get(root)[1];
    }
    private int helper(TreeNode root){
        if(root ==null)return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        int d= l+r;
        max=Math.max(max,d);
        return 1+ Math.max(l,r);
        // t: O(N)
        //s: O(H) where h is log N in balanced  and N in case of skewed tree
    }
}
