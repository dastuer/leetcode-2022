package dp.maximumSubarray;

/**
 * 53. 最⼤⼦序和
 * 题⽬地址：https://leetcode-cn.com/problems/maximum-subarray/
 * 给定⼀个整数数组 nums ，找到⼀个具有最⼤和的连续⼦数组（⼦数组最少包含⼀个元素），返回其最
 * ⼤和。
 * 示例:
 * 输⼊: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续⼦数组 [4,-1,2,1] 的和最⼤，为 6。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{4, -1, 2, 1}));
    }
    public int maxSubArray(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            result = Math.max(dp[i],result);
        }
        return result;
    }

}
