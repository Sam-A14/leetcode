class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        BackTrack(sb,0,0,n,ans);
        return ans;
    } 
    void BackTrack(StringBuilder sb,int open,int close,int n,List<String>ans){
        if(sb.length()==2*n){
            ans.add(sb.toString());
            return ;
        }
        if(open<n){
            sb.append('(');
            BackTrack(sb,open+1,close,n,ans);
            sb.deleteCharAt(sb.length()-1);
        }
         if(close<open){
            sb.append(')');
            BackTrack(sb,open,close+1,n,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    } 
}