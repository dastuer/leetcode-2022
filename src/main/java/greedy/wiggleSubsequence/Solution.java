package greedy.wiggleSubsequence;

/**
 * 376. 摆动序列
 * 题⽬链接：https://leetcode-cn.com/problems/wiggle-subsequence/
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第⼀个差（如果存在
 * 的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }
    public int wiggleMaxLength(int[] nums){
        if (nums.length<=1)
            return nums.length;
        int preDiff = 0;
        int curDiff;
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            curDiff = nums[i+1]-nums[i];
            if ((preDiff>=0&&curDiff<0)||(preDiff<=0&&curDiff>0)){
                res++;
                preDiff = curDiff;
            }
        }
        return res+1;


    }

}
