class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSort(nums, temp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] temp, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        // Count reverse pairs in left half
        count += mergeSort(nums, temp, left, mid);

        // Count reverse pairs in right half
        count += mergeSort(nums, temp, mid + 1, right);

        // Count reverse pairs crossing left and right halves
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {

            while (j <= right &&
                   (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        // Normal merge
        int i = left;
        j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {

            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy sorted portion back
        for (i = left; i <= right; i++) {
            nums[i] = temp[i];
        }

        return count;
    }
}