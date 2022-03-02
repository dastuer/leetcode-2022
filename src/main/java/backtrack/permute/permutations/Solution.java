package backtrack.permute.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.solution(4,2);
        result.forEach(System.out::println);
    }
    // used数组标记访问状态
    public List<List<Integer>> solution(int n,int k){
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        boolean[] used = new boolean[n];
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        backtracking(result,arr,cur,k,used);
        return result;
    }
    public void backtracking(List<List<Integer>> result, int[] n, List<Integer> cur, int k, boolean[] used){
        List<Integer> curr = new ArrayList<>(cur);
        if (curr.size()==k){
            result.add(curr);
            return;
        }
        for (int i = 0; i < n.length; i++) {
            if (!used[i]){
                curr.add(n[i]);
                used[i] = true;
                backtracking(result,n,curr,k,used);
                used[i] = false;
                curr.remove(new Integer(n[i]));
            }
        }
    }
}
