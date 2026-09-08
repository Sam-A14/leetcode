class Solution {
    public int compress(char[] chars) {
        int i =0;
        int write =0;
        while(i<chars.length){
            int j =i;
            while(j<chars.length && chars[j]==chars[i]){
                j++;
            }
            int count=j-i;
            chars[write++]=chars[i];
            if(count>1){
                String str = String.valueOf(count);
                for(char c:str.toCharArray()){
                    chars[write++]=c;
                }
            }
            i=j;
        }
        return write;
    }
}