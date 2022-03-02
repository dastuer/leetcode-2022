package backtrack.permute.permuteUnique;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1,3,2}));
    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] arr){
        Arrays.sort(arr);
        backtrack(new boolean[arr.length],arr);
        return result;

    }
    public void backtrack(boolean[] used,int[] arr){
        if (cur.size()==arr.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((i>0&&arr[i]==arr[i-1]&&!used[i-1])||used[i]){
                continue;
            }
            cur.add(arr[i]);
            used[i]=true;
            backtrack(used,arr);
            cur.remove(cur.size()-1);
            used[i]=false;
        }
    }

}
