package greedy.canCompleteCircuit;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
    }
    public int canCompleteCircuit(int[] gas,int[] costs){
        int totalSum = 0;
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i]-costs[i];
            totalSum += gas[i]-costs[i];
            if (curSum<0){
                start = i+1;
                curSum = 0;
            }
        }
        if (totalSum<0)return -1;
        return start;
    }
}
