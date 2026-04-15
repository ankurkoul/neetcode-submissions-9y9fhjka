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
    int preIdx=0;
    Map<Integer,Integer> posIdxMap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //ICORE
        /*
        in preorder -> first node is root 
        we find postiion of root in inorder -> say mid
        now recursively build left substree based on 
            preorder : [1 to n]
            inorder :[0 to mid-1]
        now recursively build right subtree based on:
                inorder :[mid+1]
                prorder
        then return root
        */
        //basedcondition 
        if(preorder==null || inorder==null)return null;
        if(preorder.length != inorder.length)return null;
        //load all inorder in map
        for(int i=0;i<inorder.length;i++){
            posIdxMap.put(inorder[i],i);
        }
       return dfs(preorder, 0, preorder.length-1);
    }

    private TreeNode dfs(int[] preorder, int start , int end){
        if(start> end) return null;
        int rootVal=preorder[preIdx++];
        TreeNode root=new TreeNode(rootVal);
        // get inorder id of root say mid
        int mid=posIdxMap.get(rootVal);
       root.left =dfs(preorder,start, mid-1);
       root.right =dfs(preorder,mid+1, end);
       return root;
    }
}
