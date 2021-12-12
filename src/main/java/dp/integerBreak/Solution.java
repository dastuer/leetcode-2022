package dp.integerBreak;
/*
    343. 整数拆分
    给定⼀个正整数 n，将其拆分为⾄少两个正整数的和，并使这些整数的乘积最⼤化。 返回你可以获得的
    最⼤乘积。
    dp[i] = Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*dp[j] ));
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(integerBreak(100));

    }
    public static  int  integerBreak(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i],Math.max(i-j,dp[i-j])*Math.max(j,dp[j]));
            }
        }
        return dp[n];
    }
}
