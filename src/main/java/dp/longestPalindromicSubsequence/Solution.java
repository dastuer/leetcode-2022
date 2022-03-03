package dp.longestPalindromicSubsequence;

/**
 * 516.最⻓回⽂⼦序列
 * 题⽬链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * 给定⼀个字符串 s ，找到其中最⻓的回⽂⼦序列，并返回该序列的⻓度。可以假设 s 的最⼤⻓度为 1000
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }
    public int longestPalindromeSubseq(String s){
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length()-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length();j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
