package dp.climbStairs;

/*
    70. 爬楼梯
    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的⽅法可以爬到楼顶呢？
    dp[n] = dp[n-1] + dp[n-2]

 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(minCostClimbStairs(new int[]{10, 15, 20}));

    }
    public static int climbStairs(int n){
        if (n<=1){
            return n;
        }
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[2] = dp[0]+dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
    /*
        746. 使⽤最⼩花费
        题⽬链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs/
        每当你爬上⼀个阶梯你都要花费对应的体⼒值，⼀旦⽀付了相应的体⼒值，你就可以选择向上爬⼀个阶
        梯或者爬两个阶梯。
        请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
        dp[n] = MIN(dp[n-1],dp[n-2])+cost[n]
     */
    public static int minCostClimbStairs(int[] cost){

        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
