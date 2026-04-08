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
        //q
        /*
            i: root can be empty? what is max nodes 
               can value be duplicate?
            o: in case of empty? list<list> for rest?
            a: bfs since level by level  , although dfs with level can achieve same
            e: should null values be added as part of output?
                // arrayDeque doesnt allow null
    
        */
       // dfs(root,0);
        //return res;
       return bfs(root);
    }
    //Maintain a list of lists (res) 
    //where each index corresponds to a level in the tree.
    List<List<Integer>> res=new ArrayList<>();
    private void dfs(TreeNode root, int level){
        if(root==null)return;
        if(level==res.size()){
            // it means we have reached this level first time 
            /*          1
                    2       3
                4               5

                Start at root (1), level = 0
                level == res.size() (0 == 0), so create a new list for level 0.
                Add 1 to res[0] → [[1]]

                then go left
                Move to left child (2), level = 1
                level == res.size() (1 == 1), so create a new list for level 1.
                Add 2 to res[1] → [[1], [2]].

                Move to left child (4), level = 2
                level == res.size() (2 == 2), so create a new list for level 2.
                Add 4 to res[2] → [[1], [2], [4]].

                Backtrack to right child (3), level = 1
                level == res.size() (1 == 3) is false, 
                so no new list is created.
                Add 3 to res[1] → [[1], [2, 3], [4]].
            */
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
         // Recursive calls for left and right children (preorder: Node → Left → Right)
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }

    private List<List<Integer>> bfs(TreeNode root){
        if(root==null)return res;
        Queue<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            //level by level 
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            while(size-->0){
                //preoder traverseal -> node-> left->right
                TreeNode top=q.poll();
                level.add(top.val);
                if(top.left!=null) q.offer(top.left);
                if(top.right!=null) q.offer(top.right);
            }
            //level is complete 
            res.add(level);
        }
        return res;
    }
}
