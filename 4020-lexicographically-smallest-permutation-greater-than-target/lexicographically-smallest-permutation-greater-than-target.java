class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int t = target.charAt(i) - 'a';

            // Try to keep the same character
            if (count[t] > 0) {
                count[t]--;
                ans.append(target.charAt(i));
            } else {
                // Cannot continue matching target.
                // Find smallest character greater than target[i].
                for (int c = t + 1; c < 26; c++) {
                    if (count[c] > 0) {
                        ans.append((char) ('a' + c));
                        count[c]--;

                        // Append remaining characters in sorted order
                        for (int k = 0; k < 26; k++) {
                            while (count[k] > 0) {
                                ans.append((char) ('a' + k));
                                count[k]--;
                            }
                        }

                        return ans.toString();
                    }
                }

                // No greater character at this position.
                // Need to backtrack.
                break;
            }
        }

        // Backtrack to find a position that can be increased.
        while (ans.length() > 0) {
            int i = ans.length() - 1;
            int current = ans.charAt(i) - 'a';

            count[current]++;
            ans.deleteCharAt(i);

            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {
                if (count[c] > 0) {
                    ans.append((char) ('a' + c));
                    count[c]--;

                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}
