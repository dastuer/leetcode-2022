package backtrack.subsets;
/*
    回溯算法：求⼦集问题！
    第78题. ⼦集
    题⽬地址：https://leetcode-cn.com/problems/subsets/
    给定⼀组不含重复元素的整数数组 nums，返回该数组所有可能的⼦集（幂集）。
    说明：解集不能包含重复的⼦集。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> solution1 = solution.solution(new int[]{1, 2, 3,4});
        System.out.println(solution1);
//        solution.solution(new int[]{2,1,2,1,1,2},5).forEach(System.out::println);
    }

    public List<List<Integer>> solution(int[] arr){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(), arr,0);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> cur,
                          int[] arr, int start) {
        List<Integer> curr = new ArrayList<>(cur);
        result.add(new ArrayList<>(cur));
        for (int i = start; i < arr.length; i++) {
            curr.add(arr[i]);
            backtrack(result, curr, arr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
