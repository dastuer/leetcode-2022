package dp.maxProfit;

/*
  121. 买卖股票的最佳时机
  题⽬链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
  给定⼀个数组 prices ，它的第 i 个元素 prices[i] 表示⼀⽀给定股票第 i 天的价格。
  你只能选择 某⼀天 买⼊这只股票，并选择在 未来的某⼀个不同的⽇⼦ 卖出该股票。设计⼀个算法来计
  算你所能获取的最⼤利润。
  返回你可以从这笔交易中获取的最⼤利润。如果你不能获取任何利润，返回 0
 */

/**
 * 解法1贪⼼
 * 因为股票就买卖⼀次，那么贪⼼的想法很⾃然就是取最左最⼩值，取最右最⼤值，那么得到的差值就是
 * 最⼤利润。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public int maxProfit(int[] arr){
        int maxProfit = 0;
        int lowPrice = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxProfit = Math.max(maxProfit,arr[i]-lowPrice);
            lowPrice = Math.min(lowPrice,arr[i]);
        }
        return maxProfit;
    }
}

/**
 * 解法2： 动态规划
 * dp[n][i] dp[n][0] 第n天或之前持有的最小花费，dp[n][1]第n天或之前出售的所能达到的最大利润
 */
class Solution2{
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public int maxProfit(int[] arr){
        int[][] dp = new int[arr.length][2];
        dp[0][0] = -arr[0];
        dp[0][1] = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-arr[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+arr[i]);
        }
        return dp[arr.length-1][1];
    }

}
