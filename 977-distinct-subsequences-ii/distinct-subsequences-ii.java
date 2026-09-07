class Solution {
    public int distinctSubseqII(String s) {
        long MOD =1000000007;
        long dp = 1;
        long [] last = new long[26];
        for(char c:s.toCharArray()){
            int index =c-'a';
            long old = dp;
            dp =(2*dp -last[index] + MOD)% MOD;
            last [index] = old;
        }
        return (int)((dp-1 +MOD)%MOD);
    }
}