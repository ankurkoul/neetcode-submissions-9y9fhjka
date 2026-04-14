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
    public int kthSmallest(TreeNode root, int k) {
        //Q
        /*
        I: root can be null then return?
            max no of nodes
            max value of k
            if k is not present then?
            tree is binary or bst?
        */
        //approach  inorder traversal
       //  dfs(root);
        //return res.get(k-1);
        return morrisTraversal(root,k);
    }

    private void dfs(TreeNode root){
        if(root==null)return ;
        //inoreder treavese -> left, node, right
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
              /** time compexity:
        T(n) = T(left) + T(right) + O(1)
        T(L) = O(L)
        T(R) = O(R)
        T(n) = O(L) + O(R) + O(1)
             = O(L + R + 1)
             = O(n)
        
         */
    }

    private int morrisTraversal(TreeNode root, int k) {
        /*
        Morris Traversal:
        is a way to perform inorder traversal of a binary tree 
        using O(1) space.
        It avoids using a stack or recursion 
        by temporarily modifying the tree structure using Threads
        "threads" (links) that point back to parent nodes.

        The Two-Visit Cycle
        Visit 1: The Setup (Going Down)
            When cur first arrives at a node (let's call it Node A), 
            it looks to its left. 
            It sees a subtree 
            and says, "I need to go down there, but I need a way back."
            ie
             1. find pred -> run pred ptr first
             2. link pred.right =cur
             3. then shift cur to left

        Visit 2: The Return (Coming Back)
            After visiting each node to reach back to same pred node hence pred.right==cur
            means travesed left side completly
        After visiting,
             these links are removed to restore the original tree structure.
        */
         TreeNode cur = root;
         int count = 0; // To keep track of the number of nodes visited
          while (cur != null) {
            // Case 1: No left child
            if (cur.left == null) {
                //  vist node , 
                //  Check if count ==k then return node
                //  move to right for next
                count++;
                if(count==k)return cur.val;
                cur=cur.right;
            }else{
                // Case 2: Left Child Exists
                // 1. visit the entire left subtree first.
                // 2. find the predecessor -> rightmost in left subtree

                // Start at cur.left 
                // and keep going right until you hit null or the cur node itself
                TreeNode pred=cur.left;
                while(pred.right!=null && pred.right!=cur){
                    pred = pred.right;
                }
                //loop end
                // check condition
                // if pred.right is null 
                // This is the first time we've reached the predecessor
                // pred.right = cur. This "thread" acts as a parent connect.
                if(pred.right==null){
                    //create thread
                    pred.right = cur;
                    // move to left of curr
                    // now parent link setup we can traverse it and go back to root
                    cur=cur.left;
                }else{
                    //break thread
                     pred.right = null;
                    //vist node
                    count++;
                    if(count==k)return cur.val;
                    cur=cur.right;
                }
            }
            /*
            Time complexity 
            Each edge in the tree is visited at most 2 times:
                Once when creating the thread
                Once when removing the thread

            And each node:
            Is processed exactly once (when count++ happens)

            Although there is a nested while loop to find the inorder predecessor, 
            each edge of the tree is traversed at most twice — once to create the temporary thread and once to remove it.
            So overall, every node and every edge is processed a constant number of times.
            Therefore, total time complexity is O(n)
            */
          }
         return -1; // This should never be reached if k is valid
    }
}
