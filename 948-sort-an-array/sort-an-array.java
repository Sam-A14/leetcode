class Solution {
    public int[] sortArray(int[] nums) {
       mergesort(nums,0,nums.length-1);
        return nums;
    }
    private void mergesort(int [] nums , int left , int right){
        if(left>=right){
            return;
        }
        int mid = left +(right-left)/2;
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
     private void merge(int[] nums,int left,int mid,int right){
        int i = left;
        int j = mid+1;
        List<Integer> temp = new ArrayList<>();
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp.add(nums[i]);
                i++;
            }else{
                temp.add(nums[j]);
                j++;
            }
        }
    while(i<=mid){
        temp.add(nums[i]);
        i++;
    }
    while(j<=right){
        temp.add(nums[j]);
        j++;
    }
    for(int k=left;k<=right;k++){
        nums[k] = temp.get(k-left);
    }
}
}