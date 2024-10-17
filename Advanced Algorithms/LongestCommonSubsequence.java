public class LongestCommonSubsequence {
    /**
     * Calculates and returns the longest common subsequence (LCS) between two strings.
     * This method uses dynamic programming to build a 2D table that stores the lengths of
     * LCS solutions for different substrings of the input strings and reconstructs the LCS.
     *
     * @param s1 First string to compare.
     * @param s2 Second string to compare.
     * @return The longest common subsequence string.
     */
    public static String findLCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Fill the dp table to find the length of the LCS
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the LCS from the dp array
        StringBuilder lcs = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        String lcs = findLCS(s1, s2);
        System.out.println("LCS for '" + s1 + "' and '" + s2 + "' is: " + lcs + " (Length: " + lcs.length() + ")");

        String s3 = "ABC";
        String s4 = "DEF";
        lcs = findLCS(s3, s4);
        System.out.println("LCS for '" + s3 + "' and '" + s4 + "' is: " + lcs + " (Length: " + lcs.length() + ")");

        String s5 = "ABCDE";
        String s6 = "ABCDE";
        lcs = findLCS(s5, s6);
        System.out.println("LCS for '" + s5 + "' and '" + s6 + "' is: " + lcs + " (Length: " + lcs.length() + ")");

        String s7 = "AAB";
        String s8 = "ACAB";
        lcs = findLCS(s7, s8);
        System.out.println("LCS for '" + s7 + "' and '" + s8 + "' is: " + lcs + " (Length: " + lcs.length() + ")");
    }
}