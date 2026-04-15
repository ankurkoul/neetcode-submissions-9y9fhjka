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
    private int preorderIndex = 0;
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

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
        int n= inorder.length;
        // Build value -> index map for inorder
        for (int i = 0; i < n; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
       return dfs(preorder, 0, n-1);
    }

    private TreeNode dfs(int[] preorder, int inLeft, int inRight) {
        // No elements in this subtree
        if (inLeft > inRight) return null;
        // Pick current root from preorder
        int rootVal=preorder[preorderIndex++];
        TreeNode root=new TreeNode(rootVal);
        // get inorder id of root say mid
         int mid = inorderIndexMap.get(rootVal);
         // Recursively build left and right subtree
        root.left =dfs(preorder,inLeft, mid-1);
        root.right =dfs(preorder,mid+1, inRight);
       return root;

       /*
       Time:

        we iterate n nodes for building tree -> O(n)
        then we call recursion on n node

        At each recursive call:
            1 .Pick root → O(1)
            2. HashMap lookup → O(1)
            3. Two recursive calls 
                One recursive traversal that processes each node exactly once
                So recurrence relation: T(n) = T(left) + T(right) + O(1)
                left + right = n - 1
                O(1) = work done at current node
            hence total work done in recursive for n nodes=>  T(n) = T(left) + T(right) + O(1) = O(n) 
            Each call does O(1) non-recursive work.
            Total number of calls = number of nodes = n
            
       Space:
       map -> O(n)
       stack -> height of tree -> O(n) skewed  or O(logn) balanced
       */
    }
}
