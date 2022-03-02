package backtrack.combine.subsetsWithDup;
/*
    给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
    解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/subsets-ii。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> cur = new ArrayList<>();
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> solution1 = solution.subsetsWithDup(new int[]{4,1,4,4,4});
        System.out.println(solution1);
//        solution.solution(new int[]{2,1,2,1,1,2},5).forEach(System.out::println);
    }

    public List<List<Integer>> subsetsWithDup(int[] arr){
        Arrays.sort(arr);
        backtrack(result, arr,0,new boolean[arr.length]);
        return result;
    }
    public void backtrack(List<List<Integer>> result,
                          int[] arr, int start,boolean[] used) {
        result.add(new ArrayList<>(cur));
//        HashSet<Integer> used = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
//            if (used.contains(arr[i]))continue;
            if (i>0&&arr[i]==arr[i-1]&&(!used[i-1]))continue;
            used[i]=true;
            cur.add(arr[i]);
            backtrack(result, arr, i+1,used);
            cur.remove(cur.size() - 1);
            used[i]=false;
        }
    }
}
