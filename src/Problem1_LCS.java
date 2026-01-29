public class Problem1_LCS {

    // Computes the length of the Longest Common Subsequence
    //  using dynamic programming
    public static int lcsLength(String text1, String text2) {
        //  Converts strings to character arrays for easy indexing
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        int n = a.length, m = b.length;


        // dp[i][j] stores the LCS length of
        //  a[0..i-1] and b[0..j-1]
        //  Row 0 and column 0 represent empty prefixes (LCX = 0)
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                
                //  if the characters match,
                //  extend the LCS from the previous prefixes
                if(a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;

                    // If characters do not match, one of them is excluded.
                    //  We take the best result from skipping either character
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        //  The bottom right cell contains the LCS length
        return dp[n][m];
    }

    public static void main(String[] args) {
        //  Use command line arguments if provided, otherwise defaults
        String text1 = (args.length >= 1) ? args[0] : "alucards";
        String text2 = (args.length >= 2) ? args[1] : "alliances";

        // print everything out so we can see he result
        System.out.println("Problem 1: Longest Common Subsequence Length");
        System.out.println("Input text1 = \"" + text1 + "\"");
        System.out.println("Input text2 = \"" + text2 + "\"");
        System.out.println("Output length = " + lcsLength(text1, text2));
    }
}
