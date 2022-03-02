package dp.houseRobber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

/**
 * 198.打家劫舍
 * 题⽬链接：https://leetcode-cn.com/problems/house-robber/
 * 你是⼀个专业的⼩偷，计划偷窃沿街的房屋。每间房内都藏有⼀定的现⾦，影响你偷窃的唯⼀制约因素
 * 就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同⼀晚上被⼩偷闯⼊，系统会⾃动报
 * 警。
 * 给定⼀个代表每个房屋存放⾦额的⾮负整数数组，计算你 不触动警报装置的情况下 ，⼀夜之内能够偷窃
 * 到的最⾼⾦额
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
    }
    public int rob(int[] arr){
        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i]=Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[arr.length-1];
    }
}
/**
 * 213.打家劫舍II
 * 题⽬链接：https://leetcode-cn.com/problems/house-robber-ii/
 * 你是⼀个专业的⼩偷，计划偷窃沿街的房屋，每间房内都藏有⼀定的现⾦。这个地⽅所有的房屋都 围成
 * ⼀圈 ，这意味着第⼀个房屋和最后⼀个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同⼀晚上被⼩偷闯⼊，系统会⾃动报警 。
 * 给定⼀个代表每个房屋存放⾦额的⾮负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最
 * ⾼⾦额。
 */
class Solution2{
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.rob(new int[]{1,2,3,1}));


    }
    public int rob(int[] arr){
        return Math.max(robRange(arr,0, arr.length-1),robRange(arr,1, arr.length));

    }
    public int robRange(int[] arr,int begin, int end){
        int len = end-begin;
        int[] dp = new int[len];
        dp[0]=arr[begin];
        dp[1]=Math.max(arr[begin],arr[begin+1]);
        for (int i = 2; i < len; i++) {
            dp[i]=Math.max(dp[i-1],arr[begin+i]+dp[i-2]);
        }
        return dp[len-1];
    }
}

/**
 * 337.打家劫舍 III
 * 题⽬链接：https://leetcode-cn.com/problems/house-robber-iii/
 * 在上次打劫完⼀条街道之后和⼀圈房屋后，⼩偷⼜发现了⼀个新的可⾏窃的地区。这个地区只有⼀个⼊
 * ⼝，我们称之为“根”。 除了“根”之外，每栋房⼦有且只有⼀个“⽗“房⼦与之相连。⼀番侦察之后，聪明的
 * ⼩偷意识到“这个地⽅的所有房屋的排列类似于⼀棵⼆叉树”。 如果两个直接相连的房⼦在同⼀天晚上被
 * 打劫，房屋将⾃动报警。
 * 计算在不触动警报的情况下，⼩偷⼀晚能够盗取的最⾼⾦额。
 */
class Solution3{
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }
    public int rob(TreeNode root) {
        List<Integer> vals = robTree(root);
        return Math.max(vals.get(0), vals.get(1));
    }
    // list 0 选当前节点，1 不选当前节点
    List<Integer> robTree(TreeNode root){
        if (root==null)return Arrays.asList(0,0);
        else {
            // 打劫左节点
            List<Integer> leftVals = robTree(root.left);
            // 打劫右节点
            List<Integer> rightVals = robTree(root.right);
            //  选当前节点, 不能选直接子节点，只能选非直接子节点的
            int val1 = root.val + leftVals.get(1) + rightVals.get(1);
            // 不选当前节点,可以选当前节点的直接子节点和非直接子节点（二选一）
            int val2 = Math.max(leftVals.get(0),leftVals.get(1))+
                    Math.max(leftVals.get(1),leftVals.get(1));
            return Arrays.asList(val1,val2);
        }
    }

}

