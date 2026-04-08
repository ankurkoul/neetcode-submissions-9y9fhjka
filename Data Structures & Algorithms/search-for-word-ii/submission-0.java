class Solution {
    class TrieNode {
        String isEnd;
        Map<Character, TrieNode> children = new HashMap<>();

        void insert(String word, TrieNode root) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode()); // Fix: use `cur`
                cur = cur.children.get(c); // Move to next node
            }
            cur.isEnd = word;
        }
    }

    List<String> res = new ArrayList<>(); // Fix: Move outside TrieNode
    int[][] dirs = { {0,1}, {1,0}, {0,-1}, {-1,0} }; // Fix: Remove extra semicolon

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();

        // Insert words into Trie
        for (String word : words) {
            root.insert(word, root);
        }

        // Start DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode root) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == '*') return; // Already visited

        char temp = board[i][j];

        // Check if character exists in Trie
        TrieNode cur = root.children.get(temp);
        if (cur == null) return; // Fix: Backtrack properly
       
        // Mark word found
        if (cur.isEnd != null) {
            res.add(cur.isEnd);
            cur.isEnd = null; // Avoid duplicate words
        }

        // Mark visited just before dfs calls
        board[i][j] = '*';

        // Search in all directions
        for (int[] d : dirs) {
            dfs(board, i + d[0], j + d[1], cur);
        }

        // Backtrack
        board[i][j] = temp;
    }
}
