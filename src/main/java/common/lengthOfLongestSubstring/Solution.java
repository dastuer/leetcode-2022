package common.lengthOfLongestSubstring;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abba"));
    }
    public int lengthOfLongestSubstring(String s){
        if (s.length()==0){return 0;}
        int beginIndex=0;
        int maxLen=1;
        int last;
        int[] lasts = new int[128];
        Arrays.fill(lasts, -1);
//        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            last = lasts[c];
            beginIndex = Math.max(last + 1, beginIndex);
            maxLen = Math.max(maxLen, i - beginIndex+1);
            lasts[c] = i;
        }
//            if ((last=map.get(c))!=null){
//                int len = i - beginIndex;
//                maxLen= Math.max(maxLen, len);
//                beginIndex = Math.max((last + 1), beginIndex);
//                map.put(c,i);
//            }else {
//                map.put(c,i);
//            }
//        int len = endIndex - beginIndex;
//        return Math.max(len,maxLen);
        return maxLen;
    }
}
