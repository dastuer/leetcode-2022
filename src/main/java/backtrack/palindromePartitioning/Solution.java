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
        solution.solution(new int[]{2,1,2,1,1,2},5).forEach(System.out::println);
    }

    public List<List<Integer>> solution(int[] array,int target){
        // 排序去重
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),0,array,0,
                target,new boolean[array.length]);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> cur,
                          int sum,int[] array,int start,int target,boolean[] used){
        if (sum==target){
            result.add(new ArrayList<>(cur));
        }
        List<Integer> curr = new ArrayList<>(cur);
        for (int i = start; i < array.length&&sum<target; i++) {
            // 去重 同级别相同数字去掉
            if (i>0&&array[i]==array[i-1]&& !used[i - 1]){
                continue;
            }
            sum += array[i];
            used[i] = true;
            curr.add(array[i]);
            backtrack(result,curr,sum,array,i+1,target,used);
            sum-=array[i];
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}
