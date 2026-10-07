class Solution {

    Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {

        int leftRemove = 0;
        int rightRemove = 0;

        // Step 1: Find minimum removals needed
        for (char c : s.toCharArray()) {

            if (c == '(') {
                leftRemove++;
            } 
            else if (c == ')') {

                if (leftRemove > 0) {
                    leftRemove--;
                } 
                else {
                    rightRemove++;
                }
            }
        }

        // Step 2: Generate all valid strings
        dfs(s, 0, leftRemove, rightRemove, 0, new StringBuilder());

        return new ArrayList<>(set);
    }

    private void dfs(String s, int index,
                      int leftRemove, int rightRemove,
                      int balance, StringBuilder current) {

        // Invalid prefix
        if (balance < 0) {
            return;
        }

        // End of string
        if (index == s.length()) {

            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {

                set.add(current.toString());
            }

            return;
        }

        char c = s.charAt(index);

        // Case 1: '('
        if (c == '(') {

            // Remove it
            if (leftRemove > 0) {
                dfs(s, index + 1,
                    leftRemove - 1, rightRemove,
                    balance, current);
            }

            // Keep it
            current.append(c);

            dfs(s, index + 1,
                leftRemove, rightRemove,
                balance + 1, current);

            current.deleteCharAt(current.length() - 1);
        }

        // Case 2: ')'
        else if (c == ')') {

            // Remove it
            if (rightRemove > 0) {
                dfs(s, index + 1,
                    leftRemove, rightRemove - 1,
                    balance, current);
            }

            // Keep it only if it has a '(' to match
            if (balance > 0) {

                current.append(c);

                dfs(s, index + 1,
                    leftRemove, rightRemove,
                    balance - 1, current);

                current.deleteCharAt(current.length() - 1);
            }
        }

        // Case 3: letter
        else {

            current.append(c);

            dfs(s, index + 1,
                leftRemove, rightRemove,
                balance, current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}