package greedy.nonOverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. ⽆重叠区间
 * 题⽬链接：https://leetcode-cn.com/problems/non-overlapping-intervals/
 * 给定⼀个区间的集合，找到需要移除区间的最⼩数量，使剩余区间互不重叠。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{
                {1,2},{1,2},{1,2}

        }));
    }
    public int eraseOverlapIntervals(int[][] intervals){
        if (intervals.length==0)return 0;
        Arrays.sort(intervals, Comparator.comparingInt(i->i[1]));
        int minRight = intervals[0][1];
        int nonCount = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= minRight){
                minRight = intervals[i][1];
                nonCount++;
            }
            else {
                minRight = Math.min(minRight,intervals[i][1]);
            }
        }
        return intervals.length-nonCount;
    }
}
