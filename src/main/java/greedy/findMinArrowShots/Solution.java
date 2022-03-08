package greedy.findMinArrowShots;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. ⽤最少数量的箭引爆⽓球
 * 题⽬链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 在⼆维空间中有许多球形的⽓球。对于每个⽓球，提供的输⼊是⽔平⽅向上，⽓球直径的开始和结束坐标。由于它
 * 是⽔平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就⾜够了。开始坐标总是⼩于结束坐标。
 * ⼀⽀⼸箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出⼀⽀箭，若有⼀个⽓球的直径的开始和结束坐标
 * 为 xstart，xend， 且满⾜ xstart ≤ x ≤ xend，则该⽓球会被引爆。可以射出的⼸箭的数量没有限制。 ⼸箭⼀旦被
 * 射出之后，可以⽆限地前进。我们想找到使得所有⽓球全部被引爆，所需的⼸箭的最⼩数量。
 * 给你⼀个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有⽓球所必须射出的最⼩⼸箭数。
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(new int[][]{
                {1, 2}, {2, 3},{3,4},{4,5}
        }));
    }
    public int findMinArrowShots(int[][] points){
        if (points.length==0)
            return 0;
        // 左边界排序
        Arrays.sort(points, Comparator.comparingInt(p->p[0]));
        int minRight = points[0][1];
        int arrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > minRight){
                arrows++;
                minRight = points[i][1];
            }else {
                minRight = Math.min(minRight,points[i][1]);
            }
        }
        return arrows;
    }
}
