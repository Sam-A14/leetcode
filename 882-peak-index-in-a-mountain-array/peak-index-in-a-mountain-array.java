class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int peak =0;
        for(int i =0;i<n;i++){
            if(arr[i]>arr[peak]){
                peak=i;
            }
            
        }
        return peak;
    }
}