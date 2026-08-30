class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;
        for(int i =0;i<n;i++){
            if(nums[i] <nums[minIdx]){
                minIdx = i;
            }
            if(nums[i]>nums[maxIdx]){
                maxIdx = i; 
            }
        }
        int L = Math.min(maxIdx,minIdx);
        int R = Math.max(maxIdx,minIdx);
        int Both_right = n-L;
        int Both_left = R+1;
        int One_from_each = (L+1)+(n-R);
        int answer = Math.min(Math.min(Both_right,Both_left), One_from_each);
        
        return answer;
    }
}