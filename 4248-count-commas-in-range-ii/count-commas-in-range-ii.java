class Solution {
    public long countCommas(long n) {
       long ans = 0;
       long x=1000;
       while(x<=n){
        long count =n-x+1;
        ans+=n-x+1;
        x*=1000;
       }
       return ans;
    }
}