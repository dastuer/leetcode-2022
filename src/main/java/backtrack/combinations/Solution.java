package backtrack.combinations;

import java.util.ArrayList;
import java.util.List;

// 题⽬链接：https://leetcode-cn.com/problems/combinations/

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(2,2).forEach(System.out::println);
    }
    public List<List<Integer>> solution(int n,int k){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,n,new ArrayList<>(),k,1);
        return result;
    }
    public void backtracking(List<List<Integer>> result, int n, List<Integer> cur, int k,int startIndex){
        if (cur.size()==k){
            result.add(new ArrayList<>(cur));
            return;
        }
        List<Integer> curr = new ArrayList<>(cur);
        for (int i = startIndex; i <= n ; i++) {
            if ((n-i)+1<(k-curr.size()))return;
            curr.add(i);
            backtracking(result, n, curr, k, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
