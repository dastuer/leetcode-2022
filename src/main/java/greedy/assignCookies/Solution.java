package greedy.assignCookies;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
    public int findContentChildren(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        for (int i = s.length-1,j = g.length-1; i>=0&&j>=0;j--) {
            if (s[i]>=g[j]){
                res++;
                i--;
            }
        }
        return res;
    }
}
