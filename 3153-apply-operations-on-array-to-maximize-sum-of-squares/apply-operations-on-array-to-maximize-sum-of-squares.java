class Solution {
    public int maxSum(List<Integer> nums, int k) {
       int MOD = 1_000_000_007;
       int [] count = new int[31];
       for(int num:nums){
        for(int b =0;b<31;b++){
            if((num&(1<<b))!=0){
                count[b]++;
            }
        }
       }
       long ans=0;
       for(int i =0;i<k;i++){
          long num =0;

            for(int b =0;b<31;b++){
                if(count[b]>0){
                   num|=(1L<<b);
                   count[b]--;
                }
            }
              ans=(ans+num*num)%MOD;
       }
       return (int) ans;
    }
}