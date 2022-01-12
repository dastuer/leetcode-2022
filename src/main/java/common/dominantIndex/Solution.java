package common.dominantIndex;

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 *
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dominantIndex(new int[]{1, 2, 3,4}));
    }
    public int dominantIndex(int[] nums){
        int max = 0;
        int sec = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max<nums[i]){
                sec = max;
                max = nums[i];
                maxIndex = i;
            }else if (sec<nums[i]){
                sec = nums[i];
            }
        }
        return max>=sec*2?maxIndex:-1;
    }
}
