class Solution {
    public boolean isPalindromic(String s) {
       int left=0;
       int right=s.length()-1;
       while(left<right){
       int leftval = s.charAt(left);
       int rightval = s.charAt(right);
       for(int i =0;i<8;i++){
        int leftdigit =(leftval>>(7-i))&1;
        int rightdigit =(rightval>>i)&1;
        if(leftdigit!=rightdigit){
            return false;
        }
       }
        left++;
        right--;
       
       }
       while(left==right){
        int val = s.charAt(left);
          for(int i =0;i<8;i++){
        int leftdigit =(val>>(7-i))&1;
        int rightdigit =(val>>i)&1;
        if(leftdigit!=rightdigit){
            return false;
        }
       }
        left++;
        right--;
       }
       return true;
    }
}