package greedy.lemonadeChange;

/**
 * 860.柠檬⽔找零
 * 题⽬链接：https://leetcode-cn.com/problems/lemonade-change/
 * 在柠檬⽔摊上，每⼀杯柠檬⽔的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills ⽀付的顺序）⼀次购买⼀杯。
 * 每位顾客只买⼀杯柠檬⽔，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易
 * 是每位顾客向你⽀付 5 美元。
 * 注意，⼀开始你⼿头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lemonadeChange(new int[]{5,5,10}));
    }
    public  boolean lemonadeChange(int[] money){
        int five = 0;
        int ten = 0;
        for (int deal : money) {
            if (deal == 5) {
                five++;
            }
            if (deal == 10) {
                if (five == 0)
                    return false;
                ten++;
                five--;
            }
            if (deal == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five > 2) {
                    five -= 3;
                } else {
                    return false;
                }
            }

        }

        return true;
    }
}
