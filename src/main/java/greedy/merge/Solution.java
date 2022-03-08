package greedy.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 * 题⽬链接：https://leetcode-cn.com/problems/merge-intervals/
 * 给出⼀个区间的集合，请合并所有重叠的区间。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<int[]> merge = solution.merge(new int[][]{
//                {1, }, {2, 6}, {8, 10}, {15, 18}
                {1, 4}, {4, 5}
        });
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
    public List<int[]> merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
        int left = intervals[0][0];
        int maxRight = intervals[0][1];
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0]>maxRight){
                result.add(new int[]{left,maxRight});
                left = intervals[i][0];
                maxRight = intervals[i][1];
            }else {
                maxRight = Math.max(intervals[i][1],maxRight);
            }
        }
        result.add(new int[]{left,maxRight});
        return result;
    }
}
