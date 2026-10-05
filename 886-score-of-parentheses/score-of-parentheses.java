class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer>stack = new Stack<>();
        int count =0;
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(count);
                count=0;
            }else{
                int prev = stack.pop();
                if(count==0){
                    count=prev+1;
                }else {
                    count =prev +2*count;
            }
         }
        }
        return count;
    }
}