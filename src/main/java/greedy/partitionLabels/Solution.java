package greedy.partitionLabels;

import java.util.ArrayList;
import java.util.List;

/**
 * 763.划分字⺟区间
 * 题⽬链接： https://leetcode-cn.com/problems/partition-labels/
 * 字符串 S 由⼩写字⺟组成。我们要把这个字符串划分为尽可能多的⽚段，同⼀字⺟最多出现在⼀个⽚段中。返回⼀
 * 个表示每个字符串⽚段的⻓度的列表。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    }
    public List<Integer> partitionLabels(String s){
        int[] hash = new int[27];
        // 记录 每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a'] = i;
        }
        int right = 0;
        int left  = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right,hash[s.charAt(i)-'a']);
            if (i == right){
               result.add(right-left+1);
               left = i+1;
            }
        }
        return result;
    }
}
