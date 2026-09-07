class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int [] s1count = new int[26];
        int [] windowCount = new int[26];
        for(char c:s1.toCharArray()){
            s1count[c-'a']++;
        }
        int left = 0;
        for(int right =0;right<s2.length();right++){
            windowCount[s2.charAt(right)-'a']++;
            if(right-left+1>s1.length()){
            windowCount[s2.charAt(left)-'a']--;
            left++;
        }
        if(right-left+1==s1.length() && Arrays.equals(s1count,windowCount)){
            return true;
        }
        }
        return false;
    }
}