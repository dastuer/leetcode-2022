package backtrack.palindromePartitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 题⽬链接：https://leetcode-cn.com/problems/combination-sum/
 * 给定⼀个⽆重复元素的数组 candidates 和⼀个⽬标数 target ，找出 candidates 中所有可以使数字和为
 * target 的组合。
 * candidates 中的数字可以⽆限制重复被选取。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("aaaa").forEach(System.out::println);
//        solution.solution(new int[]{2,1,2,1,1,2},5).forEach(System.out::println);
    }

    public List<List<String>> solution(String s){
        List<List<String>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),s,0);
        return result;
    }
    public void backtrack(List<List<String>> result,List<String> cur,
                          String s,int start){
        if (start>=s.length()){
            result.add(new ArrayList<>(cur));
            return;
        }
        List<String> curr = new ArrayList<>(cur);
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s,start,i)){
                String s1 = s.substring(start,i+1);
                curr.add(s1);
                backtrack(result,curr,s,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
