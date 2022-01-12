package common.longestCommonPrefix;

import java.util.Locale;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"ca", "aabc", "aabbbcc", "aadsdf"}));
    }
    public String longestCommonPrefix(String[] strs) {
        int end = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char last  = strs[0].charAt(i);
            for (int i1 = 1; i1 < strs.length; i1++) {
                if (i>=strs[i1].length()||last!=strs[i1].charAt(i)){
                    return strs[0].substring(0,end);
                }
            }
            end++;
        }
        return strs[0].substring(0,end);
    }
}
