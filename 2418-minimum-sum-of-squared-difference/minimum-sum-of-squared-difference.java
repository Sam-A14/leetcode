class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int max = 0;
        long k = (long) k1 + k2;
        int[] diff = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }

        long sum = 0;
        for (int d : diff) sum += d;

        if (k >= sum) return 0;

        long[] freq = new long[max + 1];
        for (int d : diff) freq[d]++;

        for (int d = max; d > 0 && k > 0; d--) {
            long move = Math.min(k, freq[d]);
            freq[d] -= move;
            freq[d - 1] += move;
            k -= move;
        }

        long ans = 0;
        for (int d = 1; d <= max; d++) {
            ans += freq[d] * d * d;
        }

        return ans;
    }
}