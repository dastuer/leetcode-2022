package backtrack.combine.phoneNumberLetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  *17.电话号码的字⺟组合
 * 题⽬链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定⼀个仅包含数字 2-9 的字符串，返回所有它能表示的字⺟组合。
 * 给出数字到字⺟的映射如下（与电话按键相同）。注意 1 不对应任何字⺟。
 */

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("2"));
//        String[] letter = (",,abc,def,ghi,jkl,mon,pqrs,tuv,wxyz").split(",");
//        System.out.println(Arrays.toString("123".split("")));
//
//        System.out.println(Arrays.toString(letter));
//        List<String> strings = Arrays.asList(letter);
//        System.out.println(strings.stream().map(String::length).collect(Collectors.toList()));

    }
    public List<String> solution(String letters){
        String[] letterMap = (",,abc,def,ghi,jkl,mon,pqrs,tuv,wxyz").split(",");
        int[] inputNumber = Arrays.stream(letters.split("")).
                mapToInt(l -> l.charAt(0) - 48).toArray();
        List<String> result = new ArrayList<>();
        backtrack(result,"",letterMap,inputNumber,0);
        return result;
    }
    public void backtrack(List<String> result,String cur,String[] letterMap,int[] inputNumber,int startIndex){
        int len = inputNumber.length;
        if (cur.length()==len){
            result.add(cur);
        }
        StringBuilder sb = new StringBuilder(cur);
        for (int i = startIndex; i < len; i++) {
            char[] chars = letterMap[inputNumber[i]].toCharArray();
            for (char aChar : chars) {
                sb.append(aChar);
                backtrack(result, sb.toString(), letterMap, inputNumber, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
