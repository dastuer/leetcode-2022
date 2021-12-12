package dp.uniquePaths;
/*
    62.不同路径
    题⽬链接：https://leetcode-cn.com/problems/unique-paths/
    ⼀个机器⼈位于⼀个 m x n ⽹格的左上⻆ （起始点在下图中标记为 “Start” ）。
    机器⼈每次只能向下或者向右移动⼀步。机器⼈试图达到⽹格的右下⻆（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？
    dp[m][n] = dp[m-1][n]+dp[m][n-1];

 */

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
        System.out.println(
                uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

    }
    public static int uniquePaths(int m ,int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    /*
        63. 不同路径 II
        题⽬链接：https://leetcode-cn.com/problems/unique-paths-ii/
        ⼀个机器⼈位于⼀个 m x n ⽹格的左上⻆ （起始点在下图中标记为“Start” ）。
        机器⼈每次只能向下或者向右移动⼀步。机器⼈试图达到⽹格的右下⻆（在下图中标记为“Finish”）。
        现在考虑⽹格中有障碍物。那么从左上⻆到右下⻆将会有多少条不同的路径？
     */
    public static int uniquePathsWithObstacles(int[][] obstacles){
        int m = obstacles.length;
        int n = obstacles[0].length;
        int[][] dp = obstacles;
        for (int i = 0; i < m; i++) {
            dp[i][0] = dp[i][0]^1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = dp[0][i]^1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j]==1?0:(dp[i-1][j]+dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
