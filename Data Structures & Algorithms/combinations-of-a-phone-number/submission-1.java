class Solution {
    // Result list to store all combinations
    List<String> res = new ArrayList<>();
    
    // Mapping of digits to letters, similar to phone keypad
    String[] dict = {
        "", "",      // 0 and 1 have no letters
        "abc", "def", "ghi", // 2, 3, 4
        "jkl", "mno", "pqrs", "tuv", "wxyz" // 5, 6, 7, 8, 9
    };

    public List<String> letterCombinations(String digits) {
        // Edge case: if input is empty, return empty list
        if (digits.isEmpty()) return res;

        // Start DFS from the first digit
        dfs(0, "", digits);
        
        // Return all combinations found
        return res;
    }

    private void dfs(int id, String cur, String digits) {
        // Base Case: If the current combination length equals the input length,
        // then a complete combination is formed
        if (cur.length() == digits.length()) {
            res.add(cur); // Add to result list
            return;
        }

        // Get the current digit
        char key = digits.charAt(id);
        // Get the corresponding letters from the dict
        String value = dict[key - '0'];

        // Loop through all letters for the current digit
        for (char v : value.toCharArray()) {
            // Recursively build the combination
            // Move to the next digit (id + 1) and add the current letter (cur + v)
            dfs(id + 1, cur + v, digits);

            // 🔄 Backtracking is implicit here:
            // After returning from the recursive call,
            // it continues to the next letter for the same digit.
            // No explicit "undo" step needed as each recursive call 
            // creates a new string for `cur`.
        }
    }
}
