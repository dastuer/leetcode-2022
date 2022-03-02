package dp.partitionEqualSubsetSum;

import java.util.Arrays;

/*
    416. 分割等和⼦集
    题⽬链接：https://leetcode-cn.com/problems/partition-equal-subset-sum/
    题⽬难易：中等
    给定⼀个只包含正整数的⾮空数组。是否可以将这个数组分割成两个⼦集，使得两个⼦集的元素和相
    等。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1, 5, 5, 11,4}));
    }
    public boolean canPartition(int[] arr){
        int sum = Arrays.stream(arr).sum();
        if (sum%2==1)return false;
        int target = sum/2;
        int[] dp = new int[target + 1];
        for (int k : arr) {
            for (int j = target; j >= k; j--) {
                dp[j] = Math.max(dp[j], dp[j - k] + k);
            }
        }
        return dp[target]==target;
    }
}
