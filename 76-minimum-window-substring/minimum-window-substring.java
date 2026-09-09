class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];
        int[] window = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            if (need[c] > 0 && window[c] <= need[c]) {
                count++;
            }

            while (count == t.length()) {

                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                char remove = s.charAt(left);
                window[remove]--;

                if (need[remove] > 0 && window[remove] < need[remove]) {
                    count--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}