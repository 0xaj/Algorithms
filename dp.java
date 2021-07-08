//  static int binomialCoeff(int n, int k)
//    {
//        int C[][] = new int[n + 1][k + 1];
//        int i, j;
//
//        // Calculate  value of Binomial
//        // Coefficient in bottom up manner
//        for (i = 0; i <= n; i++) {
//            for (j = 0; j <= min(i, k); j++) {
//                // Base Cases
//                if (j == 0 || j == i)
//                    C[i][j] = 1;
//
//                // Calculate value using
//                // previously stored values
//                else
//                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
//            }
//        }
//
//        return C[n][k];
//    }
//   static int permutationCoeff(int n,
//                                int k)
//    {
//        int P[][] = new int[n + 2][k + 2];
//
//        // Calculate value of Permutation
//        // Coefficient in bottom up manner
//        for (int i = 0; i <= n; i++)
//        {
//            for (int j = 0;
//                j <= Math.min(i, k);
//                j++)
//            {
//                // Base Cases
//                if (j == 0)
//                    P[i][j] = 1;
//
//                // Calculate value using previosly
//                // stored values
//                else
//                    P[i][j] = P[i - 1][j] +
//                            (j * P[i - 1][j - 1]);
//
//                // This step is important
//                // as P(i,j)=0 for j>i
//                P[i][j + 1] = 0;
//            }
//        }
//        return P[n][k];
//    }
//
//    //Explanation:
////1.First observation is all the string of size 1 will be pallindrommic subsequence of size one.
////2.Check if the first and last character are same,.
////3.If yes, we check for the remaining string formed after removing the first and last character.
////4.If no, we check for the two string ie. 1. string formed by removing the last one. 2. String formed by removing the first one.
//
//class Solution {
//    public int longestPalindromeSubseq(String s) {
//
//        int n=s.length();
//
//        int dp[][]=new int[n][n];
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i;j++){
//                int k=i+j;
//                if(i==0){
//                    dp[j][k]=1;
//                }else{
//                    if(s.charAt(j)==s.charAt(k)){
//                        dp[j][k]=2+dp[j+1][k-1];
//                    }else{
//                        dp[j][k]=Math.max(dp[j+1][k],dp[j][k-1]);
//                    }
//                }
//            }
//        }
//        return dp[0][n-1];
//    }
//}


    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        int len = s.length();
        int max = 0;
        String res = "";
        boolean table[][] = new boolean[len][len];
        for(int j = 0; j < len; j++){
            for(int i = 0; i <= j; i++){
                boolean check = s.charAt(i) == s.charAt(j);
                table[i][j] = (j - i > 2) ? table[i + 1][j - 1] && check : check;
                if(table[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
