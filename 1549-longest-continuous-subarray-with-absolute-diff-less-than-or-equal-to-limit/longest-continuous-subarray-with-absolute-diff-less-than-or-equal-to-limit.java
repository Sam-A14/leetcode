class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int ans=0;
        int left =0;
        for(int right =0;right<n;right++){
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()]<nums[right]){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            while(!minDeque.isEmpty() && nums[minDeque.peekLast()]>nums[right]){
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

        while(nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()]>limit){
            if(maxDeque.peekFirst()==left){
                maxDeque.pollFirst();
            }
            if(minDeque.peekFirst()==left){
                minDeque.pollFirst();
            }
            left++;
        }
        ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}