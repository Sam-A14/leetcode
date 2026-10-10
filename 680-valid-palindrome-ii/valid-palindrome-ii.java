class Solution {
    public boolean validPalindrome(String s) {
        int n =s.length();
        int left=0;
        int right=n-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return isPal(s,left+1,right) || isPal(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    private boolean isPal(String s, int l ,int r){
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--)){
                return false;
            }
        }
        return true;
    }
}