package dp.targetSum;

import java.util.Arrays;

/*
    494. ⽬标和
    题⽬链接：https://leetcode-cn.com/problems/target-sum/
    难度：中等
    给定⼀个⾮负整数数组，a1, a2, ..., an, 和⼀个⽬标数，S。现在你有两个符号 + 和 -。对于数组中的任意
    ⼀个整数，你都可以从 + 或 -中选择⼀个符号添加在前⾯。
    返回可以使最终数组和为⽬标数 S 的所有添加符号的⽅法数。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public int findTargetSumWays(int[] arr,int s){
        int sum = Arrays.stream(arr).sum();
        int total = s+sum;
        if (total%2==1)return 0;
        int target = (total)/2;
        int[] dp = new int[target + 1];
        dp[0]=1;
        for (int k : arr) {
            for (int j = target; j >= k; j--) {
                dp[j] += dp[j - k];
            }
        }
        return dp[target];

    }
}
