class Solution {
    static final long MOD = 1_000_000_007L;

    class SegmentTree {
        long[] sum, sumSq, lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long val) {
            long len = r - l + 1L;
            sumSq[node] = (sumSq[node] + 2L * val * sum[node]
                    + val * val % MOD * len) % MOD;
            sum[node] = (sum[node] + val * len) % MOD;
            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }

        void update(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(node, l, r, 1);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            update(node * 2, l, mid, ql, qr);
            update(node * 2 + 1, mid + 1, r, ql, qr);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sumSq[node] = (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
        }

        long querySumSq() {
            return sumSq[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long ans = 0;

        for (int r = 0; r < n; r++) {
            int prev = lastSeen.getOrDefault(nums[r], -1);

            st.update(1, 0, n - 1, prev + 1, r);
            lastSeen.put(nums[r], r);

            ans = (ans + st.querySumSq()) % MOD;
        }

        return (int) ans;
    }
}