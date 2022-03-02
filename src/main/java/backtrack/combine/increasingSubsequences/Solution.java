package backtrack.combine.increasingSubsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * 491.递增⼦序列
 * 题⽬链接：https://leetcode-cn.com/problems/increasing-subsequences/
 * 给定⼀个整型数组, 你的任务是找到所有该数组的递增⼦序列，递增⼦序列的⻓度⾄少是2。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1}));
    }
    public List<List<Integer>> solution(int[] arr){
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),arr,0);
        return result;
    }
    public void backtrack(List<List<Integer>> result,List<Integer> cur,
                          int[] arr,int start){
        List<Integer> curr = new ArrayList<>(cur);
        if (curr.size()>=2){
            result.add(new ArrayList<>(cur));
        }
//        HashSet<Integer> used = new HashSet<>();
        boolean[] used = new boolean[202];
        for (int i = start; i < arr.length; i++) {
            if ((curr.size()>0&&arr[i]<curr.get(curr.size()-1))
                ||used[arr[i]]){
//                    ||used.contains(arr[i])){
                continue;
            }
            curr.add(arr[i]);
            used[arr[i]]=true;
//            used.add(arr[i]);
            backtrack(result, curr, arr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
