class Solution {
    public int maxSubArray(int[] arr ){
        int curr = arr[0];
        int max =arr[0];
        int start = 0;
        int beststart = 0;
        int end = 0;
        for(int i =1;i<arr.length;i++){
            if(arr[i]>curr+arr[i]){
                curr=arr[i];
                start = i;
            } else{
                curr+= arr[i];
            }if(max<curr){
            max = curr;
            beststart = start;
            end = i;
        }
        }
        return max;
    }
}