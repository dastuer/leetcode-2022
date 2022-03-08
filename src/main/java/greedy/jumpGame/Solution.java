package greedy.jumpGame;

/**
 * 55. 跳跃游戏
 * 题⽬链接：https://leetcode-cn.com/problems/jump-game/
 * 给定⼀个⾮负整数数组，你最初位于数组的第⼀个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最⼤⻓度。
 * 判断你是否能够到达最后⼀个位置。
 *
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{3, 2, 1,0, 4}));
    }
    public boolean jump(int[] arr){
        int maxDistance = 0;
        for (int i = 0; i < arr.length&&maxDistance < arr.length; i++) {
            if (maxDistance<i)return false;
            maxDistance = arr[i]+i;
        }
        return true;
    }
}

/**
 * 45.跳跃游戏II
 * 题⽬地址：https://leetcode-cn.com/problems/jump-game-ii/
 * 给定⼀个⾮负整数数组，你最初位于数组的第⼀个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最⼤⻓度。
 * 你的⽬标是使⽤最少的 跳跃次数到达数组的最后⼀个位置。
 */
class Solution2{
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.jump(new int[]{2,3,1,1,4}));
    }
    public int jump(int[] arr){
        int curMaxLocation = 0;
        int nextMaxLocation = 0;
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            nextMaxLocation = Math.max(nextMaxLocation,i+arr[i]);
            if (curMaxLocation==i){ // 移动到当前步数能移动到的最大位置
                if (i!=arr.length-1){
                    steps++; // 步数+1
                    curMaxLocation = nextMaxLocation; // 当前步数能达到的最大距离换为原下一步所能达到的最大距离
                    if (nextMaxLocation>=arr.length-1)break;
                }else {
                    break;
                }
            }
        }
        return steps;

    }

}
