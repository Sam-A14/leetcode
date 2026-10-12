class Solution {
    public int compress(char[] chars) {
      int i =0;
      int write =0;
      while(i<chars.length){
        int j=i;
        while(j<chars.length && chars[i]==chars[j]){
            j++;
        }
        chars[write++]=chars[i];
        int len = j-i;
        if(len>1){
            String s=String.valueOf(len);
            for(char c :s.toCharArray()){
                chars[write++]=c;
            }
        }
        i=j;
      } 
      return write; 
    }
}