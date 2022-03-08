package greedy.candy;

import java.util.stream.IntStream;

/**
 * 135. 分发糖果
 * 链接：https://leetcode-cn.com/problems/candy/
 * ⽼师想给孩⼦们分发糖果，有 N 个孩⼦站成了⼀条直线，⽼师会根据每个孩⼦的表现，预先给他们评分。
 * 你需要按照以下要求，帮助⽼师给这些孩⼦分发糖果：
 * 每个孩⼦⾄少分配到 1 个糖果。
 * 相邻的孩⼦中，评分⾼的孩⼦必须获得更多的糖果
 * 那么这样下来，⽼师⾄少需要准备多少颗糖果呢？
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1,2,2,5,4,3,2}));
    }
    public int candy(int[] ratings){
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        // 从前往后便利，右边比左边大
        for (int i = 1; i < ratings.length; i++) {
            candies[i] = 1;
            if (ratings[i-1] < ratings[i]){
                candies[i] = candies[i-1]+1;
            }
        }
        // 从后往前便利，左边比右边大
        for (int i = ratings.length-2; i >=0 ; i--) {
            if (ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }
        return IntStream.of(candies).sum();
    }
}
