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

public class Codec {


    StringBuilder sb=new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }   

    private void dfs(TreeNode root){
        //preorder
        if(root==null){
            sb.append("N,");
            return;
        }
        sb.append(""+root.val+",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    int idx=0;
    public TreeNode deserialize(String data) {
        String[]arr=data.split(",");
        return dfs(arr);
    }

    private TreeNode dfs(String[] val){
        if(val[idx].equals("N")){
            idx++; //process one node
            return null;
        }
        //prorder
        String rootVal=val[idx];
        //process node
        idx++;
        TreeNode root=new TreeNode(Integer.parseInt(rootVal));
        root.left=dfs(val);
        root.right=dfs(val);
        return root;

    }
}
