class Solution {
    int n, m;
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        res = new ArrayList<>();

        // Outer loop: iterate over each word
        // Time: O(W)
        for (String word : words) {

            boolean found = false;

            // For each word, scan entire board
            // Time: O(n * m)
            for (int r = 0; r < n && !found; r++) {
                for (int c = 0; c < m && !found; c++) {

                    // Start DFS from each cell
                    if (dfs(board, r, c, word, 0)) {
                        res.add(word);   // add only once per word
                        found = true;    // stop further search for this word
                    }
                }
            }
        }

        return res;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int idx) {

        // ✅ Base case: matched entire word
        // Time: O(1)
        if (idx == word.length()) return true;

        // ❌ Boundary + mismatch pruning
        // This pruning reduces average time but NOT worst-case
        if (r < 0 || r == n || c < 0 || c == m || board[r][c] != word.charAt(idx)) {
            return false;
        }

        // Mark visited (avoid revisiting same cell)
        char temp = board[r][c];
        board[r][c] = '#';

        // Explore 4 directions
        // First step → 4 choices
        // Next steps → 3 choices (can't go back)
        boolean found =
                dfs(board, r + 1, c, word, idx + 1) ||
                dfs(board, r - 1, c, word, idx + 1) ||
                dfs(board, r, c + 1, word, idx + 1) ||
                dfs(board, r, c - 1, word, idx + 1);

        // Backtrack (restore state)
        board[r][c] = temp;

        return found;
    }

    //total time complexity= O(W × n × m × 3^L)
}