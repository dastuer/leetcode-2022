package backtrack.restoreIpAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 93.复原IP地址
 题⽬地址：https://leetcode-cn.com/problems/restore-ip-addresses/
 给定⼀个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间⽤
 '.' 分隔。
 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和
 "192.168@1.1" 是 ⽆效的 IP 地址。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("1000012").forEach(System.out::println);
//        solution.solution(new int[]{2,1,2,1,1,2},5).forEach(System.out::println);
    }

    public List<String> solution(String s){
        List<List<String>> result1 = new ArrayList<>();
        List<String> result;
        backtrack(result1,new ArrayList<>(),s,0,0);
        result = result1.stream().map((f)->{
            StringBuilder sb = new StringBuilder();
            AtomicInteger n= new AtomicInteger(0);
            f.forEach((f1)->{
                sb.append(f1);
                n.getAndIncrement();
                if (n.get()<4){
                    sb.append(".");}
            });
            return sb.toString();}).collect(Collectors.toList());
        return result;
    }
    public void backtrack(List<List<String>> result,List<String> cur,
                          String s,int start,int pointNum){
        List<String> curr = new ArrayList<>(cur);
        if (pointNum==3){
            String last = s.substring(start);
            if (last.startsWith("0")&&last.length()>1)return;
            if (Long.parseLong(last)<=255){
                curr.add(last);
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        for (int i = start; i < s.length()-1; i++) {
            if (s.length()-i<(4-pointNum))return;
            String s1 = s.substring(start,i+1);
            if (s1.startsWith("0")&&s1.length()>1)return;
            if (Long.parseLong(s1)<=255){
                curr.add(s1);
                pointNum++;
                backtrack(result,curr,s,i+1,pointNum);
                curr.remove(curr.size()-1);
                pointNum--;
            }
        }
    }
}
