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

/**
 * 714. 买卖股票的最佳时机含⼿续费
 * 题⽬链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * 给定⼀个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；⾮负整数 fee 代表了交易股票的⼿续费⽤。
 * 你可以⽆限次地完成交易，但是你每笔交易都需要付⼿续费。如果你已经购买了⼀个股票，在卖出它之前你就不能
 * 再继续购买股票了。
 * 返回获得利润的最⼤值。
 * 注意：这⾥的⼀笔交易指买⼊持有并卖出股票的整个过程，每笔交易你只需要为⽀付⼀次⼿续费。
 */
class Solution2{
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(new int[]{1,3,2,8,4,9},2));

    }
    public int maxProfit(int[] prices,int fee){
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            if (prices[i]-minPrice-fee>0){
                profit+=prices[i]-minPrice-fee;
                minPrice=prices[i]-fee;
            }
        }
        return profit;
    }

}
