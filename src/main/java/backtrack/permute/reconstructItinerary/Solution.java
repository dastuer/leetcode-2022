package backtrack.permute.reconstructItinerary;

import java.util.*;

/**
 * 题⽬地址：https://leetcode-cn.com/problems/reconstruct-itinerary/
 * 给定⼀个机票的字符串⼆维数组 [from, to]，⼦数组中的两个成员分别表示⻜机出发和降落的机场地点，
 * 对该⾏程进⾏重新规划排序。所有这些机票都属于⼀个从 JFK（肯尼迪国际机场）出发的先⽣，所以该⾏
 * 程必须从 JFK 开始。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> ss0 = new ArrayList<>(List.of("JFK","AAA"));
        ArrayList<String> ss1 = new ArrayList<>(List.of("AAA","JFK"));
        ArrayList<String> ss2 = new ArrayList<>(List.of("JFK","BBB"));
        ArrayList<String> ss3 = new ArrayList<>(List.of("JFK","CCC"));
        ArrayList<String> ss4 = new ArrayList<>(List.of("CCC","JFK"));
        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        // [["JFK","AAA"],["AAA","JFK"],["JFK","BBB"],["JFK","CCC"],["CCC","JFK"]]
        List<List<String>> lists = new ArrayList<>(List.of(ss0, ss1, ss2, ss3,ss4));
        System.out.println(solution.findItinerary01(lists));
    }
    private List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        String[][] arr = new String[tickets.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0]=tickets.get(i).get(0);
            arr[i][1]=tickets.get(i).get(1);
        }
        Arrays.sort(arr, Comparator.comparing(a -> a[1]));
        backtrack(new boolean[arr.length],arr,"JFK");
        return result;
    }
    public boolean backtrack(boolean[] used,String[][] arr,String target){
        if (this.result.size()==arr.length){
            result.add(target);
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]&& target.equals(arr[i][0])){
                used[i]=true;
                this.result.add(target);
                if (backtrack(used,arr,arr[i][1])){
                    return true;
                }
                this.result.remove(result.size()-1);
                used[i]=false;
            }
        }
        return false;
    }

// 优先队列
    private Map<String, PriorityQueue<String>> map = new HashMap<>();

    private LinkedList<String> resList = new LinkedList<>();

    public List<String> findItinerary01(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!map.containsKey(src)) {
                PriorityQueue<String> pq = new PriorityQueue<>();
                map.put(src, pq);
            }
            map.get(src).add(dst);
        }
        dfs("JFK");
        return resList;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = map.get(src);
        while (pq != null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        resList.addFirst(src);
    }
}
