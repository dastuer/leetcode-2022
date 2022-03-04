package dp.minDistance;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使⽤的最少操作数 。
 * 你可以对⼀个单词进⾏如下三种操作：
 * 插⼊⼀个字符
 * 删除⼀个字符
 * 替换⼀个字符
 *
 * if (word1[i - 1] == word2[j - 1]) {
 *  dp[i][j] = dp[i - 1][j - 1];
 * }
 * else {
 *  dp[i][j] = min({dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]}) + 1; }
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("ab", "abc"));
    }
    public int minDistance(String source, String target){
        int sl = source.length();
        int tl = target.length();
        int[][] dp = new int[sl + 1][tl + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] =  i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (source.charAt(i-1)==target.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[sl][tl];
    }
}
