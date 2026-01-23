public class Problem1_LCS {

    public static int lcsLength(String text1, String text2) {
        char[] a = text1.toCharArray();
        char[] b = text2.toCharArray();
        int n = a.length, m = b.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a[i-1] == b[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String text1 = (args.length >= 1) ? args[0] : "alucards";
        String text2 = (args.length >= 2) ? args[1] : "alliances";

        System.out.println("Problem 1: Longest Common Subsequence Length");
        System.out.println("Input text1 = \"" + text1 + "\"");
        System.out.println("Input text2 = \"" + text2 + "\"");
        System.out.println("Output length = " + lcsLength(text1, text2));
    }
}
