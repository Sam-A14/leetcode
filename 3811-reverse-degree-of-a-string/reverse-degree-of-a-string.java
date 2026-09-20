class Solution {
    public int reverseDegree(String s) {
        int n =s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int reverseValue =26-(s.charAt(i)-'a');
            ans+= reverseValue*(i+1);
        }
        return ans;
    }
}