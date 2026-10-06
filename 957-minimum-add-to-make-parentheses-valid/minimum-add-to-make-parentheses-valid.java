class Solution {
    public int minAddToMakeValid(String s) {
       int bal=0;
       int ans =0;
       for(char c :s.toCharArray()){
        if(c=='('){
            bal++;
        }else{
            if(bal>0){
                bal--;
            }else{
                ans++;
            }
        }
       }
       return ans+bal;
    }
}