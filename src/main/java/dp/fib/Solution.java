package dp.fib;
// 题⽬地址：https://leetcode-cn.com/problems/fibonacci-number/
// 递推公式 dp[n] = dp[n-1] + dp[n-2]
public class Solution {
    public static void main(String[] args) {
        int fibonacci = fibonacci(10);
        int re = reFibonacci(10);
        System.out.println(fibonacci==re);

    }
    public static int fibonacci(int n){
        if (n<=1){
            return n;
        }
        int[] dp = new int[3];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[2] = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
    public static int reFibonacci(int n){
        if (n<=1){
            return n;
        }else {
            return reFibonacci(n-1)+reFibonacci(n-2);
        }
    }
}
