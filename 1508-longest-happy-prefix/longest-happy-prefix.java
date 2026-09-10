class Solution {
    public String longestPrefix(String s) {
      int [] lps = new int[s.length()];
      int i =1;
      int length =0;
      while(i<s.length()){
        if(s.charAt(i)==s.charAt(length)){
            length++;
            lps[i]=length;
            i++;
        }else{
            if(length>0){
                length = lps[length-1];
            }else{
                lps[i]=0;
                i++;
            }
        }
      }
      return s.substring(0,lps[s.length()-1]);     
    }
}