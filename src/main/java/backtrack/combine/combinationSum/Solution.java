package backtrack.combine.combinationSum;

import java.util.ArrayList;
import java.util.List;

// 链接：https://leetcode-cn.com/problems/combination-sum-iii/
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复
//的数字。
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3,6).forEach(System.out::println);
    }
    public List<List<Integer>> solution(int k,int n){
        List<List<Integer>> solutions = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(solutions,cur,n,k,1);
        return solutions;
    }
    public void backtrack(List<List<Integer>> solutions,List<Integer> cur,int target ,int k,int startIndex){
        if (cur.size()==k){
            if (cur.stream().mapToInt(Integer::intValue).sum()==target){
                solutions.add(new ArrayList<>(cur));
            }
            return;
        }
        List<Integer> curr = new ArrayList<>(cur);
        for (int i = startIndex; i <= 11-(k-curr.size()); i++) {
//            if ((10-i+1)<(k-curr.size()))// i>11-(k-curr.size())
//                return;
            curr.add(i);
            backtrack(solutions,curr,target,k,i+1);
            curr.remove(curr.size()-1);
        }
    }



}
