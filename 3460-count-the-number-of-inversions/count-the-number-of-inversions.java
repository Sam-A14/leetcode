class Solution {

    static final int MOD = 1_000_000_007;
    static final int MAX = 400;

    public int numberOfPermutations(int n, int[][] requirements) {

        int[] req = new int[n];

        // -1 means no requirement at this index
        java.util.Arrays.fill(req, -1);

        for (int[] r : requirements) {
            req[r[0]] = r[1];
        }

        // Index 0 can never have an inversion
        if (req[0] > 0) {
            return 0;
        }

        req[0] = 0;

        // dp[j] = number of ways to form current prefix
        // having exactly j inversions
        int[] dp = new int[MAX + 1];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {

            int[] next = new int[MAX + 1];

            long window = 0;

            for (int j = 0; j <= MAX; j++) {

                // Add dp[j] to current window
                window += dp[j];

                // Remove value that is now outside the window
                if (j - i - 1 >= 0) {
                    window -= dp[j - i - 1];
                }

                window %= MOD;

                if (window < 0) {
                    window += MOD;
                }

                next[j] = (int) window;
            }

            // Apply requirement at index i
            if (req[i] != -1) {

                int required = req[i];

                int value = next[required];

                java.util.Arrays.fill(next, 0);

                next[required] = value;
            }

            dp = next;
        }

        return dp[req[n - 1]];
    }
}