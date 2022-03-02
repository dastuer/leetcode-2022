package dp.isSubsequence;

/**
 * 392.判断⼦序列
 * 题⽬链接：https://leetcode-cn.com/problems/is-subsequence/
 * 给定字符串 s 和 t ，判断 s 是否为 t 的⼦序列。
 * 字符串的⼀个⼦序列是原始字符串删除⼀些（也可以不删除）字符⽽不改变剩余字符相对位置形成的新
 * 字符串。（例如，"ace"是"abcde"的⼀个⼦序列，⽽"aec"不是）。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("ace", "acede"));
    }
    public boolean isSubsequence(String s,String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i-1)==t.charAt(j-1))dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=dp[i][j-1];
            }
        }
        return dp[s.length()][t.length()]==s.length();
    }
 }
