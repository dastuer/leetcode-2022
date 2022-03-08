package greedy.reconstructQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.reconstructQueue(new int[][]{
//                {7,1},{4,4},{5,0},{6,1},{5,2},{7,0}
        })));
    }
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> queue = new LinkedList<>();
        Arrays.sort(people,(x,y) -> {
            if (x[0]==y[0]){
                return x[1]-y[1];
            }
            return y[0]-x[0];
        });
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[][]{new int[0]});
    }
}
