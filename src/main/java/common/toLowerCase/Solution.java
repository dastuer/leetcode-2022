package common.toLowerCase;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.toLowerCase("ACSvhj213"));

    }
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(s.split("")).forEach((l)-> sb.append(l.charAt(0)>='A'&&l.charAt(0)<='Z'?(char)(l.charAt(0)+32):l.charAt(0)));
//
//
//
//
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c>='A'&&c<='Z'){
//                sb.append((char) (c+32));
//            }else {
//                sb.append(c);
//            }
//        }
        return sb.toString();
    }
}