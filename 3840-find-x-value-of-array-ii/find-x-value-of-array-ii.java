class Solution {
    int k;
    long[][] t;

    long[] merge(long[] a, long[] b) {
        long[] c = new long[k + 1];

        c[k] = (a[k] * b[k]) % k;

        for (int r = 0; r < k; r++) {
            c[r] += a[r];
            c[(int)(a[k] * r % k)] += b[r];
        }

        return c;
    }

    void build(int p, int l, int r, int[] a) {
        if (l == r) {
            t[p] = new long[k + 1];

            t[p][a[l] % k] = 1;
            t[p][k] = a[l] % k;

            return;
        }

        int m = (l + r) / 2;

        build(p * 2, l, m, a);
        build(p * 2 + 1, m + 1, r, a);

        t[p] = merge(t[p * 2], t[p * 2 + 1]);
    }

    void update(int p, int l, int r, int i, int x) {
        if (l == r) {
            t[p] = new long[k + 1];

            t[p][x % k] = 1;
            t[p][k] = x % k;

            return;
        }

        int m = (l + r) / 2;

        if (i <= m)
            update(p * 2, l, m, i, x);
        else
            update(p * 2 + 1, m + 1, r, i, x);

        t[p] = merge(t[p * 2], t[p * 2 + 1]);
    }

    long[] query(int p, int l, int r, int ql) {

        if (ql <= l)
            return t[p];

        int m = (l + r) / 2;

        if (ql > m)
            return query(p * 2 + 1, m + 1, r, ql);

        return merge(
            query(p * 2, l, m, ql),
            t[p * 2 + 1]
        );
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;
        t = new long[4 * n][];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            update(
                1, 0, n - 1,
                queries[i][0],
                queries[i][1]
            );

            ans[i] = (int) query(
                1, 0, n - 1,
                queries[i][2]
            )[queries[i][3]];
        }

        return ans;
    }
}