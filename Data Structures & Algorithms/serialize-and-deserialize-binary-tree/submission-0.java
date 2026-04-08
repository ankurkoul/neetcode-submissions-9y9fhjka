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
        if(root==null){
            sb.append("N,");
            return ;
        }
        //preoder traversal
        sb.append(""+root.val+",");
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    private int idx;
    public TreeNode deserialize(String data) {
        String[] dataArr=data.split(",");
        idx=0;
        return dfs(dataArr);
    }

    private TreeNode dfs(String[]dataArr){
        if(dataArr[idx].equals("N")){
            //null processed
            idx++;
            return null;
        }
        // preoder
        //root
        String rootVal= dataArr[idx];
        //root processed
        idx++;
        TreeNode root=new TreeNode(Integer.parseInt(rootVal));
        root.left= dfs(dataArr);
        root.right= dfs(dataArr);
        return root;
    }
}
