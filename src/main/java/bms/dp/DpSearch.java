package bms.dp;

public class DpSearch {

    public static void main(String[] args) {

        String s1 = "intention";
        String s2 = "execution";
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else {
                    int subCost = 0;
                    if (s1.charAt(i - 1) != s2.charAt(j - 1))
                        subCost = 1;
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1] + subCost,
                            dp[i - 1][j] + 1),
                            dp[i][j - 1] + 1);
                }
            }
        }
        System.out.println("result  = " + dp[s1.length()][s2.length()]);
        //return ;

    }



}
