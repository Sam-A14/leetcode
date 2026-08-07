class Solution {
    String [] map ={
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
    public List<String> letterCombinations(String digits) {
     List<String> ans = new ArrayList<>();
     if(digits.length()==0){
        return ans ;
     }
     StringBuilder curr = new StringBuilder();
     backtrack(digits,0,curr,ans);
     return ans;
    }
    private void backtrack(String digits,int index,StringBuilder curr ,List<String> ans){
        if(index==digits.length()){
            ans.add(curr.toString());
            return ;
        }
        char digit = digits.charAt(index);
        String letter = map[digit - '0'];
        for(int i =0;i<letter.length();i++){
            curr.append(letter.charAt(i));
            backtrack(digits,index+1,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }
   }
}