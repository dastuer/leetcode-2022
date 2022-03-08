package greedy.maxProfit;

/**
 * 122.买卖股票的最佳时机II
 * 题⽬链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 给定⼀个数组，它的第 i 个元素是⼀⽀给定股票第 i 天的价格。
 * 设计⼀个算法来计算你所能获取的最⼤利润。你可以尽可能地完成更多的交易（多次买卖⼀⽀股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
    }
    public int maxProfit(int[] prices){
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if (profit>0){
                result+=profit;
            }
        }
        return result;

    }
}
