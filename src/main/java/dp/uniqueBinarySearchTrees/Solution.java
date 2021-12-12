package dp.uniqueBinarySearchTrees;
/*
    96.不同的⼆叉搜索树
    题⽬链接：https://leetcode-cn.com/problems/unique-binary-search-trees/
    给定⼀个整数 n，求以 1 ... n 为节点组成的⼆叉搜索树有多少种？
    解法: 以任意一个节点作为根节点时的种数  = 左子节点种类*右子节点种类
    dp[i] = dp[i-1]*dp[n-i]
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(numTrees(3));

    }
    public static int numTrees(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }

}
