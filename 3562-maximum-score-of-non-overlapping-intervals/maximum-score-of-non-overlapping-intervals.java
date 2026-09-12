class Solution {
    class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    int[][] arr;
    Result[][] memo;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();

        arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        memo = new Result[n][5];

        Result ans = dp(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private Result dp(int i, int k) {
        if (i == n || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (memo[i][k] != null) {
            return memo[i][k];
        }

        Result skip = dp(i + 1, k);

        int next = findNext(i);

        Result future = dp(next, k - 1);

        long takeScore = arr[i][2] + future.score;

        List<Integer> takeIndices = new ArrayList<>();
        takeIndices.add(arr[i][3]);
        takeIndices.addAll(future.indices);

        Collections.sort(takeIndices);

        Result take = new Result(takeScore, takeIndices);

        Result best;

        if (take.score > skip.score) {
            best = take;
        } 
        else if (take.score < skip.score) {
            best = skip;
        } 
        else {
            if (isLexicographicallySmaller(take.indices, skip.indices)) {
                best = take;
            } 
            else {
                best = skip;
            }
        }

        return memo[i][k] = best;
    }

    private int findNext(int i) {
        int target = arr[i][1];

        int low = i + 1;
        int high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid][0] > target) {
                high = mid;
            } 
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean isLexicographicallySmaller(
            List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}