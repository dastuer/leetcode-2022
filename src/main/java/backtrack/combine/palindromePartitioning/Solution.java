package backtrack.combine.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * 131.分割回⽂串
 * 题⽬链接：https://leetcode-cn.com/problems/palindrome-partitioning/
 * 给定⼀个字符串 s，将 s 分割成⼀些⼦串，使每个⼦串都是回⽂串。
 * 返回 s 所有可能的分割⽅案。
 * ]
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
