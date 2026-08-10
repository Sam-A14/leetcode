class Solution {
    public int majorityElement(int[] nums) {
        int candi = 0;
        int count = 0;
        for(int i =0;i<nums.length;i++){
            if(count == 0){
              candi =nums[i];
            }
            if(candi ==  nums[i]){
                count++;
            }
            if(candi!=nums[i]){
                count--;
            }
        }
        return candi;
    }
}